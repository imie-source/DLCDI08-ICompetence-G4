package org.imie.servlet.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.dto.Profil;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
// @WebFilter(description = "restriction liée au login mot de passe",
// urlPatterns = { "/RestrictionFilter" })
public class RestrictionFilter implements Filter {

	private static final String MSG_PAS_DE_ROLE = "Pas de role";
	private static final String MSG_ERREUR_AUTHENTIFICATION = "Erreur d'accès à l'authentification"; //$NON-NLS-1$

	private static final String PASSWORD = "password"; //$NON-NLS-1$
	private static final String LOGIN = "login"; //$NON-NLS-1$
	private static final String ACCUEIL_USER = "AccueilUser"; //$NON-NLS-1$
	private static final String ACCUEIL_ADM = "Administration"; //$NON-NLS-1$
	
	private static final String ACCES_CONNEXION = "./jsp/index.jsp"; //$NON-NLS-1$
	
	private static final String ERROR_MESSAGE = "errorMessage"; //$NON-NLS-1$
	private static final String SESSION_USER = "user"; //$NON-NLS-1$
	private static final String SESSION_PROFIL = "profil"; //$NON-NLS-1$
	private static final String SESSION_TITRE = "titre"; //$NON-NLS-1$
	private static final String SESSION_ACCUEIL = "accueil";	// par défaut //$NON-NLS-1$
	private static final String ENV = env.getString("env.env"); //$NON-NLS-1$
	

	private Utilisateur userAuthorized;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		/* Non-filtrage des ressources statiques */
		String chemin = request.getRequestURI().substring(
				request.getContextPath().length());
		if (chemin.startsWith("/css") || chemin.startsWith("/img") //$NON-NLS-1$ //$NON-NLS-2$
				|| chemin.startsWith("/js")) { //$NON-NLS-1$
			chain.doFilter(request, response);
			return;
		}

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		if ((request.getParameter(LOGIN) != null)
				|| (request.getParameter(PASSWORD) != null)) {

			Utilisateur user = new Utilisateur();
			user.setLogin(request.getParameter(LOGIN));
			user.setPass(request.getParameter(PASSWORD));

			try {
				IUserService svcUser = Factory.getInstance().createUserService(
						null);
				IProjectService svc = Factory.getInstance()
						.createProjectService(null);

				userAuthorized = svcUser.IsAuthorized(user);
				if (userAuthorized == null) {
					request.setAttribute(ERROR_MESSAGE, user.getLogin()
							+ env.getString("env.16")); //$NON-NLS-1$
				} else {
					List<Profil> profils = svc.getProfilsByUser(user);
					session.setAttribute(SESSION_ACCUEIL,ACCUEIL_USER);
					System.out.println(session.getAttribute(SESSION_ACCUEIL));
					for (Profil profil : profils) {
						if (profil.getNom() != null) {
							session.setAttribute(SESSION_PROFIL,
									profil.getNom());
							session.setAttribute(SESSION_TITRE, env.getString("env.17") //$NON-NLS-1$
									+ userAuthorized.getNom() + env.getString("env.18") //$NON-NLS-1$
									+ userAuthorized.getPrenom() + env.getString("env.19") //$NON-NLS-1$
									+ profil.getNom() + env.getString("env.20") + ENV + env.getString("env.21")); //$NON-NLS-1$ //$NON-NLS-2$
							if (env.getString("env.22").equalsIgnoreCase(profil.getNom()) || env.getString("env.23").equalsIgnoreCase(profil.getNom())) { //$NON-NLS-1$ //$NON-NLS-2$
								session.setAttribute(SESSION_ACCUEIL,ACCUEIL_ADM);
							}
						} else {
							session.setAttribute(SESSION_TITRE, env.getString("env.24") //$NON-NLS-1$
									+ userAuthorized.getNom() + env.getString("env.25") //$NON-NLS-1$
									+ userAuthorized.getPrenom() + env.getString("env.26") //$NON-NLS-1$
									+ MSG_PAS_DE_ROLE + env.getString("env.27") + ENV + env.getString("env.28")); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					if (profils == null) {
						session.setAttribute(SESSION_TITRE, env.getString("env.29") //$NON-NLS-1$
								+ userAuthorized.getNom() + env.getString("env.30") //$NON-NLS-1$
								+ userAuthorized.getPrenom() + env.getString("env.31") //$NON-NLS-1$
								+ MSG_PAS_DE_ROLE + env.getString("env.32") + ENV + env.getString("env.33")); //$NON-NLS-1$ //$NON-NLS-2$
					}
					session.setAttribute(SESSION_USER, userAuthorized);
				}
			} catch (TransactionalConnectionException e) {
				request.setAttribute(ERROR_MESSAGE,
						MSG_ERREUR_AUTHENTIFICATION);
			}
		} else {
			request.setAttribute(ERROR_MESSAGE,
					MSG_ERREUR_AUTHENTIFICATION);
		}

		/**
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */
		if (session.getAttribute(SESSION_USER) == null) {
			/* Redirection vers la page publique */
			request.getRequestDispatcher(ACCES_CONNEXION).forward(request,
					response);
		} else {
			/* Affichage de la page restreinte */
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

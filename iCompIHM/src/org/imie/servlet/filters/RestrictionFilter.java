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
// @WebFilter(description = "restriction liée au login mot de passe",
// urlPatterns = { "/RestrictionFilter" })
public class RestrictionFilter implements Filter {

	private static final String ACCES_CONNEXION = "./jsp/index.jsp";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String SESSION_USER = "user";
	private static final String SESSION_PROFIL = "profil";
	private static final String SESSION_TITRE = "titre";

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
		if (chemin.startsWith("/css") || chemin.startsWith("/img")
				|| chemin.startsWith("/js")) {
			chain.doFilter(request, response);
			return;
		}

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		if ((request.getParameter("login") != null)
				|| (request.getParameter("password") != null)) {

			Utilisateur user = new Utilisateur();
			user.setLogin(request.getParameter("login"));
			user.setPass(request.getParameter("password"));

			try {
				IUserService svcUser = Factory.getInstance().createUserService(
						null);
				IProjectService svc = Factory.getInstance()
						.createProjectService(null);

				userAuthorized = svcUser.IsAuthorized(user);
				if (userAuthorized == null) {
					request.setAttribute(ERROR_MESSAGE, user.getLogin()
							+ " n'est pas un login valide");
				} else {
					List<Profil> profils = svc.getProfilsByUser(user);
					System.out.println("Login : " + userAuthorized.getLogin());
					for (Profil profil : profils) {
						if (profil.getNom() != null) {
							System.out.println("profil :" + profil.getNom());
							session.setAttribute(SESSION_TITRE, " - "
									+ userAuthorized.getNom() + " "
									+ userAuthorized.getPrenom() + " - " + profil.getNom());
						} else {
							session.setAttribute(SESSION_TITRE, " - "
									+ userAuthorized.getNom() + " "
									+ userAuthorized.getPrenom() + " - "
									+ "Pas de role");
						}
					}
					if (profils != null) {
						session.setAttribute(SESSION_TITRE, " - "
								+ userAuthorized.getNom() + " "
								+ userAuthorized.getPrenom() + " - " + "Pas de role");
					}
					session.setAttribute(SESSION_USER, userAuthorized);
				}
			} catch (TransactionalConnectionException e) {
				request.setAttribute(ERROR_MESSAGE,
						"Erreur d'accès à l'authentification");
			}
		} else {
			request.setAttribute(ERROR_MESSAGE,
					"Erreur d'accès à l'authentification");
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

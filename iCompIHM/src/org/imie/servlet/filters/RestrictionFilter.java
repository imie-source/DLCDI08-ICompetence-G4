package org.imie.servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
// @WebFilter(description = "restriction liée au login mot de passe",
// urlPatterns = { "/RestrictionFilter" })
public class RestrictionFilter implements Filter {

	public static final String ACCES_CONNEXION = "./jsp/index.jsp";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
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
			System.out.println("A SUP : login : "+request.getParameter("login") + " Pass : " + request.getParameter("password"));

			try {
				IUserService svc = Factory.getInstance()
						.createUserService(null);
				userAuthorized = svc.IsAuthorized(user);
				System.out.println("Nom dans 'RectrictedFilter' :" + userAuthorized.getNom());
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				System.out.println("Utilisateur non autorisé");
			}

			if (userAuthorized != null) {
				session.setAttribute(ATT_SESSION_USER, userAuthorized);
			}

		}

		/**
		 * Si l'objet utilisateur n'existe pas dans la session en cours, alors
		 * l'utilisateur n'est pas connecté.
		 */
		if (session.getAttribute(ATT_SESSION_USER) == null) {
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

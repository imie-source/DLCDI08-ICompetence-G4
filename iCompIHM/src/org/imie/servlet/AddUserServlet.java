package org.imie.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.dto.Cursus;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.TransactionalConnectionException;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Add User Form");
		response.setContentType("text/html");
		request.getRequestDispatcher("./jsp/addUser.jsp")
				.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Add User Process");
		
		IUserService svc = Factory.getInstance().createUserService(null);

		Utilisateur user = new Utilisateur();

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("dateNaissance");
		String mail = request.getParameter("mail");
		String tel = request.getParameter("tel");
		String fax = request.getParameter("fax");
		String enFormation = request.getParameter("enFormation");
		String disponible = request.getParameter("disponible");
		String cursus = request.getParameter("cursus");
		String login = request.getParameter("identifiant");
		String password = request.getParameter("password");
		

		if (user != null) {
			if (nom != null && nom.length()<50) {
				user.setNom(nom);
			}
			if (prenom != null && prenom.length()<50) {
				user.setPrenom(prenom);
			}
			if (dateNaissance != null && dateNaissance != "") {
				Date datenaissance = null;
				try {
					datenaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dateNaissance);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				System.out.println("DN" + datenaissance.getTime());
				java.sql.Date d = new java.sql.Date(datenaissance.getTime());
				user.setDateNaissance(d);
			}
			if (mail != null) {
				user.setMail(mail);
			}
			if (tel != null) {
				user.setTel(tel);
			}
			if (fax != null) {
				user.setFax(fax);
			}
			
			Cursus cursusDto = null;
			int i = Integer.valueOf(cursus);
			try {
				cursusDto = svc.findCursus(i);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TransactionalConnectionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			if (cursus != null) {
				user.setCursus(cursusDto);
			}
			if (login != null) {
				user.setLogin(login);
			}
			if (password != null) {
				user.setPass(password);
			}
			
			try {
				Utilisateur usr = svc.insertUser(user);
			} catch (TransactionalConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(dateNaissance);
		System.out.println(mail);
		System.out.println(tel);
		System.out.println(fax);
		System.out.println(enFormation);
		System.out.println(disponible);
		System.out.println(cursus);
		System.out.println(login);
		System.out.println(password);

		response.setContentType("text/html");
		response.sendRedirect("./FindAllUsers");
	}

}

package org.imie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement statement = null;
		ResultSet rs = null;
		Connection connexion = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur Class");
		}

		try {
			connexion = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/filrouge", "postgres",
					"postgres");
			System.out.println("Connexion établie");
		} catch (SQLException e) {
			System.out.println("Erreur connexion");
		}

		try {
			statement = connexion.createStatement();
			System.out.println("Statement ok");
		} catch (SQLException e1) {
			System.out.println("Erreur Statement");
		}

		try {
			rs = statement.executeQuery("select * from utilisateur");
			System.out.println("requete ok");
		} catch (SQLException e1) {
			System.out.println("Erreur requete");
		}
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>Sample Application Servlet Page</title>");
			writer.println("</head>");
			writer.println("<body bgcolor=white>");
			writer.println("<table>");
			while (rs.next()) {
				writer.println("<tr><td>");
				writer.println(rs.getString("usr_nom"));
				writer.println("</td></tr>");
			}
			writer.println("</table>");

			writer.println("</body>");
			writer.println("</html>");

			writer.println("<!-- cadre principal -->");


			writer.println("<div id='cadremenu'>");
			writer.println("<form name='deconnexion' method='post' action='index'>");
			writer.println("<input name='deconnexion' type='submit' id='deconnexion' value='deconnexion' />");
			writer.println("</form>");
			writer.println("</div>");			
		} catch (SQLException e) {
			System.out.println("Erreur de connexion");
		}

		try {
			if (rs != null) {
				rs.close();
			}
			if (statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute(ATT_SESSION_USER, null);
	}

}

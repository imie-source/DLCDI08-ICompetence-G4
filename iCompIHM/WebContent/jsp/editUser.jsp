<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
 
<%@ page import="fr.imie.dto.Utilisateur" %>
<%@ page import="fr.imie.dto.Cursus" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.UserService" %>
<%@ page import="fr.imie.service.interfaces.IUserService" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>


<%! private String login;%>
<%! private Utilisateur user = new Utilisateur(); %>
<%! IUserService svc; %>

<% svc = Factory.getInstance().createUserService(null); %>

<% login = request.getParameter("login");%>
<% user = svc.findUserByLogin(login); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Modifier un Utilisateur</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/addUser.css" media="all" type="text/css" />
<script src="js/addUser.js" type="text/javascript"></script>
</head>

<body>
	<div id="mainwrapper">
		<%-- Div Title --%>
		<div id = "title">
			<h1>Modifier un utilisateur</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id = "wrapper">
		
			<%-- Div AddUserForm --%>
			<div id = "addUserForm">
		
				<%-- Form --%>
				<form onsubmit="return valider(this)" method="post" action="./EditUser">
				
				<%-- NOM --%>
				<div class = "formLibelle">Nom * : </div>
				<div class = "formInput"><input type="textbox" name="nom" maxlength="50" value="<%if(user.getNom() == null){ %><%}else { %><%=user.getNom()%><%}%>"/></div><br />
				
				<%-- PRENOM --%>
				<div class = "formLibelle">Prenom * : </div>
				<div class = "formInput"><input type="textbox" name="prenom" maxlength="50" value="<%if(user.getPrenom() == null){ %><%}else { %><%=user.getPrenom()%><%}%>"/></div><br />
				
				<%-- DATE DE NAISSANCE --%>
				<% 
				if(user.getDateNaissance() != null){
					DateFormat dateFormat = null;
					
					dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					
					String dat = dateFormat.format(user.getDateNaissance());
				%>
				<div class = "formLibelle">Date de Naissance : </div>
				<div class = "formInput"><input type="textbox" name="dateNaissance" value="<%if(user.getDateNaissance() == null){ %><%}else { %><%=dat%><%}%>"/></div><br />
				<%
				}
				 %>
				<%-- E-MAIL --%>
				<div class = "formLibelle">E-mail * : </div>
				<div class = "formInput"><input type="textbox" name="mail" maxlength="50" value="<%if(user.getMail() == null){ %><%}else { %><%=user.getMail()%><%}%>" /></div><br />
				
				<%-- TELEPHONE --%>
 				<div class = "formLibelle">Telephone : </div> 
				<div class = "formInput"><input type="textbox" name="tel" maxlength="10" value="<%if(user.getTel() == null){ %><%}else { %><%=user.getTel()%><%}%>"/></div><br /> 
				
				<%-- FAX --%>
 				<div class = "formLibelle">Fax : </div> 
				<div class = "formInput"><input type="textbox" name="fax" maxlength="10" value="<%if(user.getFax() == null){ %><%}else { %><%=user.getFax()%><%}%>"/></div><br /> 
				
				<%--EST EN FORMATION --%>
 				<div class = "formLibelle">En Formation : </div> 
 				<div class = "formInput"><input type="radio" name="enFormation" value="1" <%if(user.getEstEnFormation() == 1){%>checked<%} %> /> Oui 
 				<input type="radio" name="enFormation" value="0" <%if(user.getEstEnFormation() == 0){%>checked<%} %> /> Non</div><br />
 				
 				
				
				<%-- EST DISPONIBLE --%>
				<div class = "formLibelle">Disponible : </div>
 				<div class = "formInput"><input type="radio" name="disponible" value="1" <%if (user.getEstDisponible() == 1){%>checked<%} %>  /> Oui 
				<input type="radio" name="disponible" value="0" <%if (user.getEstDisponible() == 0){%>checked<%} %> /> Non</div><br />
				
				<%-- CURSUS --%>
 				<div class = "formLibelle">Cursus : </div> 
				<div class = "formInput"> 
 				<select name="cursus" id="selectcursus">
				<%
 				List<Cursus> curlist = svc.findAllCursus(); 
				
 				for (Cursus cursus : curlist) {%>
				
				<option <%if(user.getCursus().getId() == cursus.getId()){ %>selected <%}%>value="<%=cursus.getId()%>"><%=cursus.getLibelle()%></option>
				<%
				}
				%>
				</select>
				</div><br />
				
				<%-- LOGIN --%>
				<div class = "formLibelle">Login * : </div>
				<div class = "formInput"><input type="textbox" name="identifiant" maxlength="20" value="<%if(user.getLogin() == null){ %><%}else { %><%=user.getLogin()%><%}%>" readonly/></div><br />
				
				<%-- Submit --%>
				<div class = "formLibelle"></div>
				<div class = "formInput"><input id="submit" type="submit" name="editUser" value="Modifier" /></div><br />
				
				<%-- End Form --%>
				</form>
		
			<%-- End Div AddUserForm --%>
			</div>
			
		
		<%-- End Div Wrapper --%>
		</div>

		<%-- Div Footer --%>
		<div id="footer">
		<a class="backlink" href="./FindAllUsers">Retour Liste</a>
		</div>
	</div>

</body>
</html>
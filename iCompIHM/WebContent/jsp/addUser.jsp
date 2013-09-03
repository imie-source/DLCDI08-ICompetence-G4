<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
 
<%@ page import="fr.imie.dto.Cursus" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.UserService" %>
<%@ page import="fr.imie.service.interfaces.IUserService" %>

<%! IUserService svc; %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Ajouter un Utilisateur</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/addUser.css" media="all" type="text/css" />
<script src="js/addUser.js" type="text/javascript"></script>
</head>

<body>
		
		<% svc = Factory.getInstance().createUserService(null); %>

		<%-- Div Title --%>
		<div id = "title">
			<h1>Ajouter un utilisateur</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id = "wrapper">
		
			<%-- Div AddUserForm --%>
			<div id = "addUserForm">
		
				<%-- Form --%>
				<form onsubmit="return valider(this)" method="post" action="./AddUser">
				
				<%-- NOM --%>
				<div class = "formLibelle">Nom * : </div>
				<div class = "formInput"><input type="textbox" name="nom" maxlength="50" /></div><br />
				
				<%-- PRENOM --%>
				<div class = "formLibelle">Prenom * : </div>
				<div class = "formInput"><input type="textbox" name="prenom" maxlength="50" /></div><br />
				
				<%-- DATE DE NAISSANCE --%>
				<div class = "formLibelle">Date de Naissance : </div>
				<div class = "formInput"><input type="textbox" name="dateNaissance" value="JJ/MM/AAAA"/></div><br />
				
				<%-- E-MAIL --%>
				<div class = "formLibelle">E-mail * : </div>
				<div class = "formInput"><input type="textbox" name="mail" maxlength="50" /></div><br />
				
				<%-- TELEPHONE --%>
				<div class = "formLibelle">Telephone : </div>
				<div class = "formInput"><input type="textbox" name="tel" maxlength="10" /></div><br />
				
				<%-- FAX --%>
				<div class = "formLibelle">Fax : </div>
				<div class = "formInput"><input type="textbox" name="fax" maxlength="10" /></div><br />
				
				<%-- EST EN FORMATION --%>
				<div class = "formLibelle">En Formation : </div>
				<div class = "formInput"><input type="radio" name="enFormation" value="true" checked /> Oui
				<input type="radio" name="enFormation" value="false" /> Non</div><br />
				
				<%-- EST DISPONIBLE --%>
				<div class = "formLibelle">Disponible : </div>
				<div class = "formInput"><input type="radio" name="disponible" value="true" checked /> Oui
				<input type="radio" name="disponible" value="false" /> Non</div><br />
				
				<%-- CURSUS --%>
				<div class = "formLibelle">Cursus : </div>
				<div class = "formInput">
				<select name="cursus" id="selectcursus">
				<%
				List<Cursus> curlist = svc.findAllCursus(); 
				
				for (Cursus cursus : curlist) {
				%>
				<option value="<%=cursus.getId()%>"><%=cursus.getLibelle()%></option>
				<%
				}
				%>
				</select>
				</div><br />
				
				<%-- LOGIN --%>
				<div class = "formLibelle">Login * : </div>
				<div class = "formInput"><input type="textbox" name="identifiant" maxlength="20" /></div><br />
				
				<%-- MOT DE PASSE --%>
				<div class = "formLibelle">Mot de Passe * : </div>
				<div class = "formInput"><input type="password" name="password" maxlength="25" /></div><br />
				
				<%-- CONFIRMATION MOT DE PASSE --%>
				<div class = "formLibelle">Confirmer Mot de Passe * : </div>
				<div class = "formInput"><input type="password" name="confirmpassword" maxlength="25" /></div><br />
				
				<%-- Submit --%>
				<div class = "formLibelle"></div>
				<div class = "formInput"><input id="submit" type="submit" name="insertUser" value="Ajouter" /></div><br />
				
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

</body>
</html>
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
	<div id=mainwrapper">
		<%-- Div Title --%>
		<div id = "title">
			<h1>Ajouter un utilisateur</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id = "wrapper">
		
			
		
		<%-- End Div Wrapper --%>
		</div>

		<%-- Div Footer --%>
		<div id="footer">
		<a class="backlink" href="./FindAllUsers">Retour Liste</a>
		</div>
	</div>

</body>
</html>
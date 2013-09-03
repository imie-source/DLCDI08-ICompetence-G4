<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Utilisateur" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.UserService" %>
<%@ page import="fr.imie.service.interfaces.IUserService" %>
<%@ page import="fr.imie.dao.interfaces.IUtilisateurDAO" %>

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
<title><%= user.getPrenom() + " " + user.getNom() %></title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findUser.css" media="all" type="text/css" />
</head>

<body>

		

		<%-- Div Title --%>
		<div id="title">
			<h1><%=user.getPrenom() + " " + user.getNom()%></h1>
		</div>
		
		<%-- Div Wrapper --%>
		<div id = "wrapper">

		<p class="title2">Profil</p>
		
		<%-- Div UserInfos --%>
		<div id = "userinfos">
		
		<p class="attributes"><span class="attributesname">Prenom : </span><%=user.getPrenom()%></p>
		<p class="alternativeattributes"><span class="attributesname">Nom : </span><%=user.getNom()%></p>
		<p class="attributes"><span class="attributesname">Age : </span><%=user.getAge()%>  ans</p>
		<p class="alternativeattributes"><span class="attributesname">E-Mail : </span><%=user.getMail()%></p>
		<p class="attributes"><span class="attributesname">Tel : </span><%=user.getTel()%></p>
		
		<%-- End Div UserInfos --%>
		</div>
		
		<%-- End Div Wrapper --%>
		</div>
		
		<%-- Div Footer --%>
		<div id="footer">
		<a class="backlink" href="./FindAllUsers">Retour Liste</a>
		</div>

</body>
</html>
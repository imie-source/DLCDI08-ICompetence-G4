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

		
<div id="mainwrapper">
		<%-- Div Title --%>
		<div id="title">
			<h1><%=user.getPrenom() + " " + user.getNom()%></h1>
		</div>
		
		<%-- Div Wrapper --%>
		<div id = "wrapper">
			<%-- Div Profil --%>
			<div id= "profil">
	
				<p class="title2">Profil</p>
				
				<%-- Div UserInfos --%>
				<div id = "userinfos">
				
				<p class="attributes"><span class="attributesname">Prenom : </span><%if(user.getPrenom() != null){%><%=user.getPrenom()%><%}%></p>
				<p class="alternativeattributes"><span class="attributesname">Nom : </span><%if(user.getNom() != null){%><%=user.getNom()%><%}%></p>
				<p class="attributes"><span class="attributesname">Age : </span><%if(user.getAge() != 0){%><%=user.getAge()%>  ans<%}%></p>
				<p class="alternativeattributes"><span class="attributesname">E-Mail : </span><%if(user.getMail() != null){%><%=user.getMail()%><%}%></p>
				<p class="attributes"><span class="attributesname">Tel : </span><%if(user.getTel() != null){%><%=user.getTel()%><%}%></p>
				
				<%-- End Div UserInfos --%>
				</div>
			<%-- End Div Profil --%>
			</div>
			
			<%-- Div Adresse --%>
			<div id="adresse">
			
				<p class="title2">Adresse</p>
				
				<%-- Div UserInfos --%>
				<div id = "userinfos">
				
				<p class="attributes"><span class="attributesname">Adresse : </span><%if(user.getAdresse().getRue() != null){%><%=user.getAdresse().getRue()%><%}%></p>
				<p class="alternativeattributes"><span class="attributesname">Complement : </span><%if(user.getAdresse().getComplement() != null){%><%=user.getAdresse().getComplement()%><%}%></p>
				<p class="attributes"><span class="attributesname">Code Postal : </span><%if(user.getAdresse().getCodePostal() != null){%><%=user.getAdresse().getCodePostal()%><%}%></p>
				<p class="alternativeattributes"><span class="attributesname">Ville : </span><%if(user.getAdresse().getVille() != null){%><%=user.getAdresse().getVille()%><%}%></p>
				
				<%-- End Div User Infos --%>
				</div>
			<%-- End Div Adresse --%>
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
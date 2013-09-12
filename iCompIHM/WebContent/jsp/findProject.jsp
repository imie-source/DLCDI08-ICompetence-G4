<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Groupe" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.ProjectService" %>
<%@ page import="fr.imie.service.interfaces.IProjectService" %>
<%@ page import="fr.imie.dao.interfaces.IGroupeDAO" %>


<%! private String grpid = "1";%>
<%! private Groupe groupe = new Groupe(); %>
<%! IProjectService psvc; %>

<%  psvc = Factory.getInstance().createProjectService(null); %>

<% //grpid = request.getParameter("grpid");%>
<%  groupe = psvc.findGroupById(grpid);%>




    
<!DOCTYPE html>
<html>
<head>
<title<%= groupe.getId() + " " + groupe.getNom() %>/title> 
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findUser.css" media="all" type="text/css" />
</head>

<body>

	
		

		<%-- Div Title --%>
		<div id="title">
			<h1><%=groupe.getId() + " " + groupe.getNom()%></h1>
		</div>
		
		<%-- Div Wrapper --%>
		<div id = "wrapper">
		<div id= "profil">

		<p class="title2">Information Projet</p>
		
		<%-- Div UserInfos --%>
		<div id = "groupeinfos">
		
		<p class="attributes"><span class="attributesname">Id Projet : </span><%=groupe.getId()%></p>
		<p class="alternativeattributes"><span class="attributesname">Avancement : </span><%=groupe.getAvancement()%></p>
		<p class="attributes"><span class="attributesname">description : </span><%=groupe.getDescription()%></p>
		<p class="alternativeattributes"><span class="attributesname">Nom : </span><%=groupe.getNom()%></p>

		<%-- End Div UserInfos --%>
		</div>
		</div>
		<%-- End Div Wrapper --%>
		</div>
		
		<%-- Div Footer --%>
		<div id="footer">
		
		<a class="backlink" href="./FindAllUsers">Retour Liste</a>
		
		</div>

</body>
</html>
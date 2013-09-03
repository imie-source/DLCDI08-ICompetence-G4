<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Utilisateur" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.UserService" %>
<%@ page import="fr.imie.service.interfaces.IUserService" %>
<%@ page import="java.util.List" %>

<%! IUserService svc; %>
<% svc = Factory.getInstance().createUserService(null); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Liste des Utilisateurs</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findAllUsers.css" media="all" type="text/css" />
</head>

<body>

	<%-- Div Title --%>
	<div id="title">
		<h1>Liste des Utilisateurs</h1>
	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
	
		<%-- Div User List --%>
		<div id="userlist">

			<%-- Div Header Line --%>
			<div class="headerline">

				<%-- Div Header Num --%>
				<div class="num">
					<p class="header">Num</p>
				</div>

				<%-- Div Header Identite --%>
				<div class="identite">
					<p class="header">Identite</p>
				</div>

				<%-- Div Header Age --%>
				<div class="age">
					<p class="header">Age</p>
				</div>

				<%-- Div Header Tool1 (Empty) --%>
				<div class="toolHeader">
				</div>

				<%-- Div Header Tool2 (Add) --%>
				<div class="toolHeader">
					<a href="./AddUser"> <img src=img/add.png alt="Add"
						title="Add" />
					</a>
				</div>

			<%-- End Div Header Line --%>
			</div>

			<%
			List<Utilisateur> listuser = svc.getUsers(); 
			int i = 1; 
			int j = 0; 
			
			for (Utilisateur usr : listuser){
				
				if (j % 2 == 0) {
			%>
				
			<div class="line">
				
			<%
				} else {
			%>
			
			<div class="alternativeline">
			
			<%
				} 
			%>
			
				<a href="./FindUser?login=<%=usr.getLogin()%>">
					<%-- Div Num --%>
					<div class="num">
						<p class="content">	
			
							<%=i%> 
						
						</p>
					</div>
		
					<%-- Div Identite --%>
					<div class="identite">
						<p class="content"><%=usr.getPrenom() + " " + usr.getNom()%></p>
					</div>
		
					<%-- Div Age --%>
					<div class="age">
						<p class="content"><%=usr.getAge() + " ans"%></p>
						
					</div>
				</a>
								
				<%-- Div Edit --%>
				<div class="edit">
					<img src=img/edit.png alt="Edit" title="Edit" />
				</div>
	
				<%-- Div Delete --%>
				<div class="delete">
					<a href="./DeleteUser?login=<%=usr.getLogin()%>"><img src=img/remove.png alt="Delete" title="Delete" onclick="return(confirm('Etes-vous sûr de vouloir supprimer cette entrée?'));"/></a>
				</div>
 			
 			<%-- End Div Line / AlternativeLine --%>
			</div>
			<%
			i++; 
			j++; 
			}
			%>
		<%-- End Div User List --%>
		</div>
	
	<%-- End Div Wrapper --%>
	</div>
	
	<%-- Div Footer --%>
	<div id="footer">
	</div>
	
</body>
</html>
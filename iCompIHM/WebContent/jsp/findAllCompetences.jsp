<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.imie.factory.Factory"%>
<%@page import="fr.imie.service.interfaces.IUserService"%>
<%@page import="fr.imie.dto.Competence"%>
<%@page import="java.util.List"%>
    

<%! IUserService svc; %>
<% svc = Factory.getInstance().createUserService(null); %>
<%	final String SESSION_TITRE = "titre"; %>
       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Competences <%=session.getAttribute(SESSION_TITRE)%></title>
<link rel="stylesheet"href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet"href="css/findAllUsers.css" media="all" type="text/css" />
</head>


<body>
	<div id=mainwrapper>
	<%-- Div Title --%>
	<div id="title">
		<h1>Liste des Competences</h1>
	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
	
		<%-- Div User List --%>
		<div id="userlist">

			<%-- Div Header Line --%>
			<div class="headerline">

				<%-- Div Header Num --%>
				<div class="num">
					<p class="header">Libelllé Competence</p>
				</div>

			

				<%-- Div Header Tool1 (Empty) --%>
				<div class="toolHeader">
				</div>

				

			<%-- End Div Header Line --%>
			</div>

			<%
			List<Competence> listcomp = svc.getCompetences(); 
			int i = 1; 
			int j = 0; 
			
			for (Competence comp : listcomp){
				
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
			
				
		
					<%-- Div Identite --%>
					<div class="identite">
						<p class="content"><%=comp.getLibelle()%></p>
					</div>
		
					
				
 			
 			<%-- End Div Line / AlternativeLine --%>
			</div>
			<%
			 
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
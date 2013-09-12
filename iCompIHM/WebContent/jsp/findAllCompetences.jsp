<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.imie.factory.Factory"%>
<%@page import="fr.imie.service.interfaces.IUserService"%>
<%@page import="fr.imie.dto.Competence"%>
<%@page import="java.util.List"%>
    

<%! IUserService svc; %>
<% svc = Factory.getInstance().createUserService(null); %>

       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Competences</title>
<link rel="stylesheet"href="css/findAllComptences.css" media="all" type="text/css" />
<link rel="stylesheet"href="css/style.css" media="all" type="text/css" />

</head>


<body>
	<div id="title">
		<h1> Liste des Competences</h1>
	</div>
	
	<div id="wrapper">
	
		<div id="competencelist">
		
			<div class="headerline">
			
				<div class="num">
					<p class="header">Numero Competence</p>
				</div>
				
				<div class="cptence">
					<p class="header">Nom Competences</p>
				</div>
					
			</div>
			<% List<Competence> listcompetences = svc.getCompetences();
			
			int i = 1;
			int j = 0;
			
			for(Competence comp : listcompetences){
				
				if(j % 2 == 0){
			%>
			
			<div class="line">
			
			<%
				}else{
			
			%>
			<div class="alternativeline">
			
			<%
				}
			%>
				<div class="num">
					<p class="content">
						<%= i %>
					</p>
				</div>
				
				<div class="cptence">
				
					<p class="content"><%=comp.getLibelle()%>
				
				</div>
			</div>
			<% 
			
			i++;
			j++;
				
			}
			
			%>
			
			
			</div>
		
			
		</div>
	</div>
	
</body>
</html>
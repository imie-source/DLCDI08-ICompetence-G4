<%@page import="fr.imie.factory.Factory"%>
<%@ page import="fr.imie.dto.Groupe" %>
<%@ page import="java.util.List" %>
<%@page import="fr.imie.service.interfaces.IProjectService"%>
<%@page import="fr.imie.service.interfaces.IUserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!IProjectService svcProject;%>
<%
	svcProject = Factory.getInstance().createProjectService(null);
%>
<%!IUserService svcUser;%>
<%
	svcUser = Factory.getInstance().createUserService(null);
%>
<%	final String SESSION_TITRE = "titre"; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil <%=session.getAttribute(SESSION_TITRE)%></title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/stylepres3.css" media="all" type="text/css" />
</head>
<body>
<div id="mainwrapper">
	<div id="header_content">
		<img src="img/logoimie.png" alt="" />
		<div id="site_name">
			<div id="title">
				<h1>Gestion des competences</h1>
			</div>
		</div>
	</div>

	<div id="wrapper">
		<div id="menu">
			<!-- Menu de navigation du site-->
			<div id="menuListe_left">
				<div id="button">
					<ul>

							<li><a href="./AccueilUser" title="">Accueil</a></li>
							<li><a href="./Authentification" title="">Deconnexion</a></li>
							<li><a href="./FindAllProjects" title="">Infos projets</a></li>
							<li><a href="./FindAllUsers" title="">Infos utilisateurs</a></li>
					</ul>
				</div>
			</div>
		</div>


		<div id="mesinfos">
			<!-- bloc Mes Infos-->
			<h3>Infos utilisateur :</h3>
			<h5>Ne pas afficher</h5>
		</div>

		<div id="projet">
			<div id="projetleft">
				<div id="projetsEnCours">
					<!--Projets en cours -->
					<h3>Projets en cours</h3>
					
					
		<% List<Groupe> listprojet2 = svcProject.findGroupByStatut(2); 
	
		for (Groupe projet : listprojet2){	%>
					
					<div class="projet">
						<h4><%=projet.getNom() %></h4>
						<p>Chef de projet : <%=projet.getChefProjet().getPrenom() + " " + projet.getChefProjet().getNom() %></p>
						<p>Résumé : <%=projet.getDescription()%></p>
						<a href="./FindProject?id=<%=projet.getId()%>&provenanceProjet=ACC" title="Info">[+ d'infos]</a>
						<p>Etat d'avancement : <%=projet.getAvancement()%>%</p>
						<div class="button2">
							<ul>
								<li><a href="./FindAllUsers?grpid=<%=projet.getId()%>" title="Liste utilisateurs">Liste des Utilisateurs</a></li>


							</ul>
						</div><br />
					</div>
		<% } %>
					
				</div>

		
				<div id="projetsRealises">
					<!--Projets réalisés -->
					<h3>Projets Réalisés</h3>
					
		<% List<Groupe> listprojet3 = svcProject.findGroupByStatut(3);
		
		for (Groupe projet : listprojet3){	%>
		
					<div class="projet">
						<h4><%=projet.getNom() %></h4>
						<p>Résumé : <%=projet.getDescription()%></p>
						<a href="./FindProject?id=<%=projet.getId()%>&provenanceProjet=ACC" title="Info">[+ d'infos]</a>
					</div>	
		<% } %>
				</div>

			</div>

			<div id="projetright">
				<div id="propositiondeprojets">
					<!--Propositions de projets -->
					<h3>Propositions de projets</h3>
					
					
		<% List<Groupe> listprojet1 = svcProject.findGroupByStatut(1);
		
		for (Groupe projet : listprojet1){	%>
					
					
					<div class="projetxx">
						<h4><%=projet.getNom() %></h4>
						<p>Résumé : <%=projet.getDescription()%></p>
						<a href="./FindProject?id=<%=projet.getId()%>&provenanceProjet=ACC" title="Info">[+ d'infos]</a>
					</div>
		<% } %>
				</div>

			</div>

		</div>
	</div>
	<div id="footer">
		<a href="http://imie-ecole-informatique.fr/" title="">Mentions légales</a> - <a href="http://imie-ecole-informatique.fr/" title="">Site
			officiel de l'IMIE</a> - <a href="http://imie-ecole-informatique.fr/" title="">Contact</a>
	</div>
</div>
</body>
</html>
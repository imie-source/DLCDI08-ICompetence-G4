<%@page import="fr.imie.factory.Factory"%>
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


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil - Michel Hardy - CP</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/stylepres3.css" media="all" type="text/css" />
</head>
<body>
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
						<li><a href="" title="">Accueil</a></li>
						<li><a href="" title="">Deconnexion</a></li>
						<li><a href="" title="">Infos projets</a></li>
						<li><a href="" title="">Infos utilisateurs</a></li>
					</ul>
				</div>
			</div>
		</div>


		<div id="mesinfos">
			<!-- bloc Mes Infos-->
			<h3>Infos utilisateur :</h3>
			<h5>Eminuit autem inter humilia supergressa iam impotentia fines
				mediocrium</h5>
		</div>

		<div id="projet">
			<div id="projetleft">
				<div id="projetsEnCours">
					<!--Projets en cours -->
					<h4>Projets en cours</h4>
					<div id="projet1">
						<h6>Projet 1 en cours</h6>
						<div id="button2">
							<ul>
								<li><a href="" title="">Liste des Utilisateurs</a></li>
							</ul>
						</div>
						<p>Chef de projet : Michel Hardy</p>
						<p>Résumé du projet 1</p>
						<a href="" title="">[+ d'infos]</a>
						<p>Etat d'avancement : 60%</p>
					</div>

					<div id="projet2">
						<h6>Projet 2 en cours</h6>
						<div id="button2">
							<ul>
								<li><a href="" title="">Liste des Utilisateurs</a></li>
							</ul>
						</div>
						<p>Chef de projet : Michel Hardy</p>
						<p>Résumé du projet 2</p>
						<a href="" title="">[+ d'infos]</a>
						<p>Etat d'avancement : 80%</p>
					</div>
				</div>

				<div id="projetsRealises">
					<!--Projets réalisés -->
					<h4>Projets Réalisés</h4>
					<div id="projet5">
						<h6>developpement d'une interface graphique</h6>
						<p>Résumé du projet réalisé 1</p>
						<a href="" title="">[+ d'infos]</a>
					</div>
				</div>

			</div>

			<div id="projetright">
				<div id="propositiondeprojets">
					<!--Propositions de projets -->
					<h4>Propositions de projets</h4>
					<div id="projetxx">
						<h6>développement d'un logiciel comptable</h6>
						<p>résumé du projet 1 proposé</p>
						<a href="" title="">[+ d'infos]</a>
						<h6>développement d'un annuaire des anciens élèves</h6>
						<p>résumé du projet 2 proposé</p>
						<a href="" title="">[+ d'infos]</a>
					</div>
				</div>

			</div>

		</div>
	</div>
	<div id="footer">
		<a href="" title="">Mentions légales</a> - <a href="" title="">Site
			officiel de l'IMIE</a> - <a href="" title="">Contact</a>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Groupe"%>
<%@ page import="fr.imie.factory.*"%>
<%@ page import="fr.imie.service.ProjectService"%>
<%@ page import="fr.imie.service.interfaces.IProjectService"%>
<%@ page import="java.util.List"%>

<%!IProjectService svc;%>
<%
	svc = Factory.getInstance().createProjectService(null);
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Administration Panel</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/administration.css" media="all"
	type="text/css" />
</head>

<body>
	<div id=mainwrapper>
		<%-- Div Title --%>
		<div id="title">
			<h1>Administration Panel</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id="wrapper">

			<div id="indicators">

				<div class="indicator_type">
					<p>Nombre de projets</p>
				</div>
				<div class="indicator_value">
					<%-- countAllProjects --%>
				</div>

				<div class="indicator_type">
					<p>Nombre de projets en cours</p>
				</div>
				<div class="indicator_value">
					<%-- countCurrentsProjects --%>
				</div>

				<div class="indicator_type">
					<p>Nombre d'utilisateurs</p>
				</div>
				<div class="indicator_value">
					<%-- countAllUsers --%>
				</div>

				<div class="indicator_type">
					<p>Nombre de competences</p>
				</div>
				<div class="indicator_value">
					<%-- countAllCompetences --%>
				</div>

			</div>

			<%-- Div Project List --%>
			<div id="projectlist">

				<%-- Div Header Line --%>
				<div class="headerline">

					<%-- Div Header Nom Projet --%>
					<div class="project_name">
						<p class="header">Nom</p>
					</div>

					<%-- Div Header Chef de Projet --%>
					<div class="project_chief">
						<p class="header">Chef de Projet</p>
					</div>

					<%-- Div Header Nombre de participants --%>
					<div class="project_users">
						<p class="header">Participants</p>
					</div>

					<%-- Div Header Etat --%>
					<div class="project_state">
						<p class="header">Etat</p>
					</div>

					<%-- Div Header Tool1 (Empty) --%>
					<div class="toolHeader"></div>

					<%-- Div Header Tool2 (Empty) --%>
					<div class="toolHeader"></div>

					<%-- Div Header Tool3 (Empty) --%>
					<div class="toolHeader"></div>

					<%-- Div Header Tool2 (Add) --%>
					<div class="toolHeader">
						<a href="#" data-width="500" data-rel="popup1" class="poplight">
							<img src=img/add.png alt="Add" title="Add" />
						</a>
					</div>

					<%-- End Div Header Line --%>
				</div>

				<%
					List<Groupe> listgroup = svc.getGroupes(); 
					int i = 1; 
					int j = 0; 
					
					for (Groupe grp : listgroup){
						
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

						<a href="#"> <%-- Div Nom du projet --%>
							<div class="project_name">
								<p class="content"><%=grp.getNom()%></p>
							</div> <%-- Div Chef de projet --%>
							<div class="project_chief">
								<p class="content">
									<%
										if(grp.getChefProjet() != null){
									%><%=grp.getChefProjet().getPrenom() + " " + grp.getChefProjet().getNom()%>
									<%
										}
									%>
								</p>

							</div> <%-- Div Nbre participants --%>
							<div class="project_users">
								<p class="content">
									<%--countUserByGroup%></p>
						
					</div>
					
					<%-- Div Etat --%>
								<div class="project_state">
									<p class="content">
										<%--StateOfProject%></p>
						
					</div>
				</a>
								
				<%-- Div Edit --%>
									<div class="edit">
										<a href="#"><img src=img/edit.png alt="Edit" title="Edit" /></a>
									</div>

									<%-- Div Delete --%>
									<div class="delete">
										<a href="#"><img src=img/remove.png alt="Delete"
											title="Delete"
											onclick="return(confirm('Etes-vous sûr de vouloir supprimer cette entrée?'));" /></a>
									</div>

									<%-- Div ChangeChief --%>
									<div class="changechief">
										<a href="#"><img src=img/changechief.png
											alt="Change Project Leader" title="Change Project Leader" /></a>
									</div>

									<%-- Div AddUser --%>
									<div class="adduser">
										<a href="#"><img src=img/adduser.png
											alt="Add user to the project" title="Add user to the project" /></a>
									</div>

									<%-- End Div Line / AlternativeLine --%>
								</div>
								<%
									i++; 
									j++; 
									}
								%>
								<%-- End Div User List --%>
							</div> <%-- End Div Wrapper --%>
					</div>

					<%-- Div Footer --%>
					<div id="footer"></div>


				</div>
</body>
</html>
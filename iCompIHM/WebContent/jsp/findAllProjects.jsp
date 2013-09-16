<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Groupe"%>
<%@ page import="fr.imie.factory.*"%>
<%@ page import="fr.imie.service.ProjectService"%>
<%@ page import="fr.imie.service.interfaces.IProjectService"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.imie.dto.Cursus"%>

<%!IProjectService svc;%>
<%
	svc = Factory.getInstance().createProjectService(null);
%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Liste des Projets</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findAllProjects.css" media="all"
	type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>

</head>
<body>
	<div id=mainwrapper>
		<%-- Div Title --%>
		<div id="title">
			<h1>Liste des Projet</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id="wrapper">

			<%-- Div User List --%>
			<div id="userlist">

				<%-- Div Header Line --%>
				<div class="headerline">

					<%-- Div Header Identite --%>
					<div class="identite">
						<p class="header">Identite</p>
					</div>

					<%-- Div Header Age --%>
					<div class="age">
						<p class="header">Age</p>
					</div>

					<%-- Div Header Tool1 (Empty) --%>
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
					List<Groupe> listgroupe = svc.getGroupes(); 
															int i = 1; 
															int j = 0; 
															
															for (Groupe grp : listgroupe){
																
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

						<%-- Div Nom --%>
						<div class="nom">
							<p class="content"><%=grp.getNom()%></p>

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
			<div id="footer"></div>
		</div>
	</div>
</body>
</html>
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
<%	final String SESSION_TITRE = "titre"; %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Administration <%=session.getAttribute(SESSION_TITRE)%></title>
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

			<%-- End Div Wrapper --%>
					</div>

					<%-- Div Footer --%>
					<div id="footer"></div>


				</div>
</body>
</html>
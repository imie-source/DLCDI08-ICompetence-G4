<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Groupe"%>
<%@ page import="fr.imie.factory.*"%>
<%@ page import="fr.imie.service.ProjectService"%>
<%@ page import="fr.imie.service.interfaces.IProjectService"%>
<%@ page import="java.util.List"%>
<%@ page import="fr.imie.dto.Cursus"%>

<%!IProjectService psvc;%>
<%
	psvc = Factory.getInstance().createProjectService(null);
%>
<%	final String SESSION_TITRE = "titre"; %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Liste des Projets <%=session.getAttribute(SESSION_TITRE)%>s/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findAllProjects.css" media="all"
	type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>

</head>
<body>
	<div id=mainwrapper>
		<%-- Div Title --%>
		<div id="title">
		<h1>Liste des Projets</h1>
		</div>

		<%-- Div Wrapper --%>
		<div id="wrapper">

			<%-- Div User List --%>
			<div id="userlist">

				<%-- Div Header Line --%>
				<div class="headerline">

					<%-- Div Header Identite --%>
					<div class="identite">
					<p class="header">Groupe</p>
					</div>

					<%-- Div Header Age --%>
					<div class="age">
					<p class="header">Avancement</p>
					</div>

					<%-- Div Header Tool1 (Empty) --%>
					<div class="toolHeader"></div>

					<%-- Div Header Tool2 (Add) --%>
					<div class="toolHeader">
					</div>

					<%-- End Div Header Line --%>
				</div>

				<%
					List<Groupe> listgroupe = psvc.getGroupes(); 
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


						




                    <a href="./FindProject?id=<%=grp.getId()%>&provenanceProjet=LPR"> <%-- Div Identite --%>
						<%-- Div Nom --%>
					<div class="identite">
					        <%if (grp.getNom()!=null) {%>
							<p class="content"><%=grp.getNom()%></p>
							<%}else{%>
							<p class="content"></p>
							<%}%>  
							

						</div>

			    	<%-- Div Nom --%>
					<div class="age">
						<p class="content"><%if(grp.getAvancement() != 0){%><%=grp.getAvancement() %><%}%></p>
						
					</div>
				
					</a>			
				
								<%-- Div Edit --%>
				<div class="edit">
					
				</div>								
								
				<div class="edit">
					<a href="./FindProject?id=<%=grp.getId()%>"><img src=img/edit.png alt="Edit" title="Edit" /></a>
				</div>
	
	
						<%-- End Div Line / AlternativeLine --%>
					</div>
					<%
						i++; 
					j++; 
					}
					%>
		<%-- End Div Group List --%>
				</div>

				<%-- End Div Wrapper --%>
			</div>

			<%-- Div Footer --%>
			<div id="footer"></div>
	<a class="backlink" href="./AccueilUser">Retour Accueil</a>
	</div>
</body>
</html>
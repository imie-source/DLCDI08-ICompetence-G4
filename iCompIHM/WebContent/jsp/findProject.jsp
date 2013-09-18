<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Utilisateur"%>
<%@ page import="fr.imie.dto.Groupe"%>
<%@ page import="fr.imie.dto.Statut"%>
<%@ page import="fr.imie.factory.*"%>
<%@ page import="fr.imie.service.UserService"%>
<%@ page import="fr.imie.service.interfaces.IUserService"%>
<%@ page import="fr.imie.service.ProjectService"%>
<%@ page import="fr.imie.service.interfaces.IProjectService"%>
<%@ page import="fr.imie.dao.interfaces.IGroupeDAO"%>
<%@ page import="fr.imie.dao.interfaces.IStatutDAO"%>
<%@ page import="java.util.List"%>


<%!
	    
%>

<%

    int id = Integer.parseInt(request.getParameter("id"));
    String provenanceProjet = request.getParameter("provenanceProjet");
%>
<%

%>

<%
	IProjectService psvc;
%>
<%
	IUserService svc;
%>

<%
	psvc = Factory.getInstance().createProjectService(null);
%>
<%
	svc  = Factory.getInstance().createUserService(null);
%>

<%
	Groupe groupe = psvc.findGroupById(id);
%>
<%
	Utilisateur userCP = svc.getChefProjetbyGrpid(id);
%>

<%      final String SESSION_TITRE = "titre"; 
%>


<!DOCTYPE html>
<html>
<head>
<title>Projet <%=session.getAttribute(SESSION_TITRE)%></title>
	<link rel="stylesheet" href="css/styleProject.css" media="all"
		type="text/css" />
	<link rel="stylesheet" href="css/findProject.css" media="all"
		type="text/css" />
	<link rel="stylesheet" href="css/findAllProjects.css" media="all"
		type="text/css" />
	<link rel="stylesheet" href="css/addUser.css" media="all"
		type="text/css" />
</head>

<body>




	<%-- Div Title --%>
	<div id="title">
		<h1><%if(groupe.getNom() != null){%><%=groupe.getNom()%><%}%></h1>
	</div>

	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
		<div id="profil">

			<p class="title2">Informations Projet</p>

			<%-- Div UserInfos --%>
			<div id="groupeinfos">

				<p class="attributes">
					<span class="attributesname">Nom : </span><%if(groupe.getNom() != null){%><%=groupe.getNom()%><%}%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Chef de Projet : </span><%if(userCP.getPrenom() != null){%><%=userCP.getPrenom()%><%}%>
					<%if(userCP.getNom() != null){%><%=userCP.getNom()%><%}%></p>
				<p class="attributes">
					<span class="attributesname">Avancement : </span><%=groupe.getAvancement()%>%</p>
				<p class="alternativeattributes">
					<span class="attributesname">Resume : </span><%if(groupe.getResume() != null){%><%=groupe.getResume()%><%}%></p>
				<p class="attributes">
					<span class="attributesname">Description : </span><%if(groupe.getDescription() != null){%><%=groupe.getDescription()%><%}%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Statut : </span><%if(groupe.getStatut().getLibelle() != null){%><%=groupe.getStatut().getLibelle()%><%}%></p>

				<%-- End Div UserInfos --%>
			</div>
		</div>
		<%-- End Div Wrapper --%>
	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
		<div id="profil2">

			<p class="title3">Liste des volontaires du Projet</p>
			<p class="title4"><span class="marge"></span>Identité
			                  <span class="marge"></span><span class="marge"></span>Cursus 
			                  <span class="marge"></span><span class="marge"></span>Téléphone
			                  <span class="marge"></span><span class="marge"></span>Mail</p>


			<%-- Div UserInfos --%>
			<div id="groupeinfos">
				<%
					List<Utilisateur> listuser = svc.getUsersbyGrpId(id); 
					int i = 1; 
					int j = 0; 
					
					for (Utilisateur usr : listuser){
						
						if (j % 2 == 0) {
				%>

				<div class="line2">

					<%
						} else {
					%>

					<div class="alternativeline2">

						<%
							}
						%>

						
							<div class="identite1">


								<p class="content"><%if(usr.getPrenom() + " " + usr.getNom() != null){%><%=usr.getPrenom() + " " + usr.getNom()%><%}%></p>
							</div> <%-- Div Cursus --%>
							<div class="identite2">
								<p class="content"><%if(usr.getCursus().getLibelle() != null){%><%=usr.getCursus().getLibelle()%><%}%></p>

							</div> <%-- Div Téléphone --%>
							<div class="identite3">
							
								<p class="content"><%if(usr.getTel() != null){%><%=usr.getTel()%><%}%></p>

							</div> <%-- Div Mail --%>
							<div class="identite4">
								<p class="content"><%if(usr.getMail() != null){%><%=usr.getMail()%><%}%></p>

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

				<%-- End Div groupeInfos --%>
			</div>
			

				<%-- End Div profil2r --%>
			</div>









			<%-- Div Footer --%>
			<div id="footer">
			    <%if (provenanceProjet.equals("LPR")) {%>
				<a class="backlink" href="./FindAllProjects">Retour Liste</a>
				<%}else{%>
		        <a class="backlink" href="./AccueilUser">Retour Liste</a>
				<%}%>
			</div>

				<%-- End Div Wrapper --%>
			</div>
		
</body>
</html>

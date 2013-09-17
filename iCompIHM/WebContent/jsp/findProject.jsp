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
					<span class="attributesname">Nom : </span><%=groupe.getNom()%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Chef de Projet : </span><%=userCP.getNom()%></p>
				<p class="attributes">
					<span class="attributesname">Avancement : </span><%=groupe.getAvancement()%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Resume : </span><%=groupe.getResume()%></p>
				<p class="attributes">
					<span class="attributesname">Description : </span><%=groupe.getDescription()%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Statut : </span><%=groupe.getStatut().getLibelle()%></p>

				<%-- End Div UserInfos --%>
			</div>
		</div>
		<%-- End Div Wrapper --%>
	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
		<div id="profil2">

			<p class="title3">Liste des volontaires du Projet</p>
			<p class="title4">
				<span class="marge"> Identité </span><span class="marge">
					Cursus </span> <span class="marge2"> Téléphone </span><span class="marge3">
					Mail </span>
			</p>

			<%-- Div UserInfos --%>
			<div id="groupeinfos">
				<%
					List<Utilisateur> listuser = svc.getUsersbyGrpId(id); 
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

<<<<<<< HEAD
						<a href="./FindUser?login=<%if(usr.getLogin() != null){%><%=usr.getLogin()%>"<%}%>> <%-- Div Identite --%>
=======
						<a href="./FindUser?login=<%=usr.getLogin()%>&provenanceUser=CPR"> <%-- Div Identite --%>
>>>>>>> 193ceb2e455eb436f9d229dff0bffaf7c6f3ae61
							<div class="identite">
								<p class="content"><%if(usr.getPrenom() + " " + usr.getNom() != null){%><%=usr.getPrenom() + " " + usr.getNom()%><%}%></p>
							</div> <%-- Div Cursus --%>
							<div class="identite">
								<p class="content"><%if(usr.getCursus().getLibelle() != null){%><%=usr.getCursus().getLibelle()%><%}%></p>

							</div> <%-- Div Téléphone --%>
							<div class="identite">
							
								<p class="content"><%if(usr.getTel() != null){%><%=usr.getTel()%><%}%></p>

							</div> <%-- Div Mail --%>
							<div class="identite">
								<p class="content"><%if(usr.getMail() != null){%><%=usr.getMail()%><%}%></p>

							</div>
						</a>


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
			    <%if (request.getParameter("provenanceProjet") == "LPR") {%>
				<a class="backlink" href="./FindAllProjects">Retour Liste</a>
				<%}else{%>
		        <a class="backlink" href="./AccueilUser">Retour Liste</a>
				<%}%>
			</div>

				<%-- End Div Wrapper --%>
			</div>
		
</body>
</html>

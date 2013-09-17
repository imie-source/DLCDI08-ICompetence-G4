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


<%
	//final int grpId = 1;
%>

<%
	String id = (String) request.getParameter("grpid");
	if (id != null) {
		int grpId = Integer.parseInt(id);
	}
%>
<%
	//String provenance =  (String) request.getParameter("provenance");
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
	Groupe groupe = psvc.findGroupById(Integer.parseInt(id));
%>
<%
	Utilisateur userCP = svc.getChefProjetbyGrpid(Integer.parseInt(id));
%>



<!DOCTYPE html>
<html>
<head>
<title><%=groupe.getNom()%></title>
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

	<%-- Div Wrapper --%>
	<div id="wrapper">
		<div id="profil">

			<p class="title2">Informations Projet</p>

			<%-- Div UserInfos --%>
			<div id="groupeinfos">

				<p class="attributes">
					<span class="attributesname">Nom : </span><%if(groupe.getNom() != null){%><%=groupe.getNom()%><%}%></p>
				<p class="alternativeattributes">
					<span class="attributesname">Chef de Projet : </span><%if(userCP.getNom() != null){%><%=userCP.getNom()%><%}%></p>
				<p class="attributes">
					<span class="attributesname">Avancement : </span><%if(groupe.getAvancement() != 0){%><%=groupe.getAvancement()%><%}%></p>
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
			<p class="title4">
				<span class="marge"> Identité </span><span class="marge">
					Cursus </span> <span class="marge2"> Téléphone </span><span class="marge3">
					Mail </span>
			</p>

			<%-- Div UserInfos --%>
			<div id="groupeinfos">
				<%
					List<Utilisateur> listuser = svc.getUsersbyGrpId(Integer.parseInt(id)); 
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

						<a href="./FindUser?login=<%if(usr.getLogin() != null){%><%=usr.getLogin()%>"<%}%>> <%-- Div Identite --%>
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

				<%-- End Div Wrapper --%>
			</div>

			<%-- Div Footer --%>
			<div id="footer">

				<a class="backlink" href="./FindAllUsers">Retour Liste</a>

			</div>
		</div>
	</div>
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/FctModal.js"></script>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/ArborescenceCompetence.css" media="all"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	ecrireTitre('Fenetre des index', 'nom', false);
</script>


</head>
<body>
	<div id="mainWrapper">
		<div id="title">
			<h1>Fenetre des index</h1>
		</div>
		<div id="wrapper">
			<div id="dialog-form" title="Authentification">
				<table class="tableContour" align=center width="80%" height="100">
					<tr>
						<td class="Title"><img src="img/add.png" class="logo" title="logo" /></td>
						
					</tr>
					<tr>
						<td class="SubTitle">Application de Référentiel de Gestion de
							compétence</td>
					</tr>
					<tr>
						<td class="SubTitle">Vous êtes sur la page d'accueil.</td>
					</tr>
				</table>
				<br>
				<br>
				<br>
				<%
					if (session.getAttribute("sessionUtilisateur") == null) {
				%>
				<form name="Connexion" method="get" action="index">

					<table class=tableau align=center width="80%" height="100">
						<tr>
							<td width="5%">&nbsp;</td>
							<td class="ParaText" width="10%">Login :</td>
							<td width="20%"><input name="login" id="login" size="12"
								style="WIDTH: 90px" maxLength=10></td>
						</tr>
						<tr>
							<td width="5%">&nbsp;</td>
							<td class="ParaText" width="10%">Password :</td>
							<td width="20%"><input name="password" id="password"
								size="12" style="WIDTH: 90px" maxLength=10></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="Rechercher"
								id="btnRechercher"></td>
							<td><input type="reset" value="Réinitialiser" id=reset1
								name=reset1></td>
						</tr>
					</table>
				</form>
				<%
					} else {
				%>
				<h1>Erreur sur la connexion de l'utilisateur</h1>
				<%
					}
				%>
			</div>


		</div>
		<div id="footer"></div>
	</div>
</body>
</html>
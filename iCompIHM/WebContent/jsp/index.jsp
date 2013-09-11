<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jpe page index html transformee en jsp</title>

</head>
<body>
	<!-- page -->

	<div id="page">

		<%
			if (session.getAttribute("sessionUtilisateur") == null) {
		%>
		<div id="dialog-form" title="Authentification">
			<form name="Connexion" method="get" action="index">
				Merci d'entrer votre login pour vous connecter <input type="text" name="login"
					id="login" /> <br> Merci d'entrer votre mot de passe <input
					type="text" name="password" id="password" /> <input type="submit"
					value="submit">
			</form>
		</div>
		<%
			} else {
		%>
		toto
		<%
			}
		%>

	</div>
	<!-- page -->
</body>
</html>
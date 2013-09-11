<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.imie.dto.Utilisateur" %>
<%@ page import="fr.imie.factory.*" %>
<%@ page import="fr.imie.service.UserService" %>
<%@ page import="fr.imie.service.interfaces.IUserService" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.imie.dto.Cursus" %>

<%! IUserService svc; %>
<% svc = Factory.getInstance().createUserService(null); %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>Liste des Utilisateurs</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/findAllUsers.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/addUser.css" media="all" type="text/css" />
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/addUser.js" type="text/javascript"></script>
<script>

jQuery(function($){
						   		   
	//Lorsque vous cliquez sur un lien de la classe poplight
	$('a.poplight').on('click', function() {
		var popID = $(this).data('rel'); //Trouver la pop-up correspondante
		var popWidth = $(this).data('width'); //Trouver la largeur

		//Faire apparaitre la pop-up et ajouter le bouton de fermeture
		$('#' + popID).fadeIn().css({ 'width': popWidth}).prepend('<a href="#" class="close"><img src="img/close_pop.png" class="btn_close" title="Close Window" alt="Close" /></a>');
		
		//Récupération du margin, qui permettra de centrer la fenêtre - on ajuste de 80px en conformité avec le CSS
		var popMargTop = ($('#' + popID).height() + 80) / 2;
		var popMargLeft = ($('#' + popID).width() + 80) / 2;
		
		//Apply Margin to Popup
		$('#' + popID).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		//Apparition du fond - .css({'filter' : 'alpha(opacity=80)'}) pour corriger les bogues d'anciennes versions de IE
		$('body').append('<div id="fade"></div>');
		$('#fade').css({'filter' : 'alpha(opacity=80)'}).fadeIn();
		
		return false;
	});
	
	
	//Close Popups and Fade Layer
	$('body').on('click', 'a.close, #fade', function() { //Au clic sur le body...
		$('#fade , .popup_block').fadeOut(function() {
			$('#fade, a.close').remove();  
	}); //...ils disparaissent ensemble
		
		return false;
	});

	
});

</script>
</head>

<body>
<div id=mainwrapper>
	<%-- Div Title --%>
	<div id="title">
		<h1>Liste des Utilisateurs</h1>
	</div>

	<%-- Div Wrapper --%>
	<div id="wrapper">
	
		<%-- Div User List --%>
		<div id="userlist">

			<%-- Div Header Line --%>
			<div class="headerline">

				<%-- Div Header Num --%>
				<div class="num">
					<p class="header">Num</p>
				</div>

				<%-- Div Header Identite --%>
				<div class="identite">
					<p class="header">Identite</p>
				</div>

				<%-- Div Header Age --%>
				<div class="age">
					<p class="header">Age</p>
				</div>

				<%-- Div Header Tool1 (Empty) --%>
				<div class="toolHeader">
				</div>

				<%-- Div Header Tool2 (Add) --%>
				<div class="toolHeader">
					<a href="#" data-width="500" data-rel="popup1" class="poplight"> <img src=img/add.png alt="Add"
						title="Add" />
					</a>
				</div>

			<%-- End Div Header Line --%>
			</div>

			<%
			List<Utilisateur> listuser = svc.getUsers(); 
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
			
				<a href="./FindUser?login=<%=usr.getLogin()%>">
					<%-- Div Num --%>
					<div class="num">
						<p class="content">	
			
							<%=i%> 
						
						</p>
					</div>
		
					<%-- Div Identite --%>
					<div class="identite">
						<p class="content"><%=usr.getPrenom() + " " + usr.getNom()%></p>
					</div>
		
					<%-- Div Age --%>
					<div class="age">
						<p class="content"><%=usr.getAge() + " ans"%></p>
						
					</div>
				</a>
								
				<%-- Div Edit --%>
				<div class="edit">
					<a href="./EditUser?login=<%=usr.getLogin()%>"><img src=img/edit.png alt="Edit" title="Edit" /></a>
				</div>
	
				<%-- Div Delete --%>
				<div class="delete">
					<a href="./DeleteUser?login=<%=usr.getLogin()%>"><img src=img/remove.png alt="Delete" title="Delete" onclick="return(confirm('Etes-vous sûr de vouloir supprimer cette entrée?'));"/></a>
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
	<div id="footer">
	</div>
	
	<div id="popup1" class="popup_block">
	
		<h2>Ajouter un Utilisateur</h2>
		
		<%-- Div AddUserForm --%>
			<div id = "addUserForm">
		
				<%-- Form --%>
				<form onsubmit="return valider(this)" method="post" action="./AddUser">
				
				<%-- NOM --%>
				<div class = "formLibelle">Nom * : </div>
				<div class = "formInput"><input type="textbox" name="nom" maxlength="50" /></div><br />
				
				<%-- PRENOM --%>
				<div class = "formLibelle">Prenom * : </div>
				<div class = "formInput"><input type="textbox" name="prenom" maxlength="50" /></div><br />
				
				<%-- DATE DE NAISSANCE --%>
				<div class = "formLibelle">Date de Naissance : </div>
				<div class = "formInput"><input type="textbox" name="dateNaissance" value="JJ/MM/AAAA"/></div><br />
				
				<%-- E-MAIL --%>
				<div class = "formLibelle">E-mail * : </div>
				<div class = "formInput"><input type="textbox" name="mail" maxlength="50" /></div><br />
				
				<%-- TELEPHONE --%>
				<div class = "formLibelle">Telephone : </div>
				<div class = "formInput"><input type="textbox" name="tel" maxlength="10" /></div><br />
				
				<%-- FAX --%>
				<div class = "formLibelle">Fax : </div>
				<div class = "formInput"><input type="textbox" name="fax" maxlength="10" /></div><br />
				
				<%-- EST EN FORMATION --%>
				<div class = "formLibelle">En Formation : </div>
				<div class = "formInput"><input type="radio" name="enFormation" value="true" checked /> Oui
				<input type="radio" name="enFormation" value="false" /> Non</div><br />
				
				<%-- EST DISPONIBLE --%>
				<div class = "formLibelle">Disponible : </div>
				<div class = "formInput"><input type="radio" name="disponible" value=1 checked /> Oui
				<input type="radio" name="disponible" value=0 /> Non</div><br />
				
				<%-- CURSUS --%>
				<div class = "formLibelle">Cursus : </div>
				<div class = "formInput">
				<select name="cursus" id="selectcursus">
				<%
				List<Cursus> curlist = svc.findAllCursus(); 
				
				for (Cursus cursus : curlist) {
				%>
				<option value="<%=cursus.getId()%>"><%=cursus.getLibelle()%></option>
				<%
				}
				%>
				</select>
				</div><br />
				
				<%-- LOGIN --%>
				<div class = "formLibelle">Login * : </div>
				<div class = "formInput"><input type="textbox" name="identifiant" maxlength="20" /></div><br />
				
				<%-- MOT DE PASSE --%>
				<div class = "formLibelle">Mot de Passe * : </div>
				<div class = "formInput"><input type="password" name="password" maxlength="25" /></div><br />
				
				<%-- CONFIRMATION MOT DE PASSE --%>
				<div class = "formLibelle">Confirmer Mot de Passe * : </div>
				<div class = "formInput"><input type="password" name="confirmpassword" maxlength="25" /></div><br />
				
				<%-- Submit --%>
				<div class = "formLibelle"></div>
				<div class = "formInput"><input id="submit" type="submit" name="insertUser" value="Ajouter" /></div><br />
				
				<%-- End Form --%>
				</form>
		
			<%-- End Div AddUserForm --%>
			</div>
			
	</div>
</div>
	
	
</body>
</html>
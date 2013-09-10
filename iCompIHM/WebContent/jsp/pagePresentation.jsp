<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des Utilisateurs</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/stylepres3.css" media="all" type="text/css" />
</head>
<body>
<div id="title">
		<h1>Gestion des competences</h1>
	</div>

	<%-- Div wrapper --%>
	<div id="wrapper"> 
		<nav id="menu"> <!-- Menu de navigation du site-->	
			
			<%-- Div menuListe_left --%>		
			<div id="menuListe_left">
			
			<%-- Div button --%>
			<div id="button">
				<a href="">Accueil</a>
				<a href="">Deconnexion</a>
			</div>
			
			<%-- Div menuRecherche_right --%>
			<div id="menuRecherche_right">
				<form>
				<input type="search" name="recherche" placeholder="Recherche"/>
				<input class="buton" type="submit" value="OK"/>
				</form>
			</div>
		</nav>
		
		<%-- Div mesinfos --%>
		<div id="mesinfos"> <!-- bloc Mes Infos-->
				<h2>Infos utilisateur</h2>
		</div>
		
		<%-- Div projet --%>
		<div id="projet">
		
			<%-- Div projetleft --%>
			<div id="projetleft">
			
				<%-- Div projetsEnCours --%>
				<div id="projetsEnCours"> <!--Projets en cours -->
						<h4>Projets en cours</h4>
						
						<%-- Div projet1 --%>
						<div id="projet1">
						<h6>Projet 1 en cours</h6>
						<p>Chef de projet : Michel Hardy</p>
						<p>Eminuit autem inter humilia supergressa iam impotentia fines mediocrium delictorum nefanda Clematii cuiusdam Alexandrini nobilis mors repentina;
						cuius socrus cum misceri sibi generum, flagrans eius amore, non impetraret, ut ferebatur, per palatii pseudothyrum introducta, oblato pretioso
						</p><a href="" title="">[+ d'infos]</a>
						<p>Etat d'avancement : 60%</p>
						</div>

						<%-- Div projet2 --%>
						<div id="projet2">
						<h6>Projet 2 en cours</h6>
						<p>Chef de projet : Michel Hardy</p>
						<p>Eminuit autem inter humilia supergressa iam impotentia fines mediocrium delictorum nefanda Clematii cuiusdam Alexandrini nobilis mors repentina;
						cuius socrus cum misceri sibi generum, flagrans eius amore, non impetraret, ut ferebatur, per palatii pseudothyrum introducta, oblato pretioso
						reginae monili id adsecuta est, ut ad Honoratum tum comitem orientis formula missa letali omnino scelere nullo contactus idem
						Clematius nec hiscere nec loqui permissus occideretur.
						</p><a href="" title="">[+ d'infos]</a>
						<p>Etat d'avancement : 80%</p>
						</div>
				</div>
				
				<%-- Div projetsRealises --%>
				<div id="projetsRealises"> <!--Projets réalisés -->
						<h4>Projets Réalisés</h4>
						
						<%-- Div projet5 --%>
						<div id="projet5">
						<h6>developpement d'une interface graphique</h6>
						<p>Eminuit autem inter humilia supergressa iam impotentia fines mediocrium delictorum nefanda Clematii cuiusdam Alexandrini nobilis mors repentina;
						</p><a href="" title="">[+ d'infos]</a>
						</div>
				</div>
			
			</div>
		
		<%-- Div projetright --%>
		<div id="projetright">
		
				<%-- Div propositiondeprojets --%>
				<div id="propositiondeprojets"> <!--Propositions de projets -->
					<h4>Propositions de projets</h4>
					<div id="projetxx">
					<h6>développement d'un logiciel comptable</h6>
					<p>description du projet : Eminuit autem inter humilia supergressa iam impotentia fines mediocrium delictorum nefanda Clematii cuiusdam Alexandrini nobilis mors repentina;
						cuius socrus 
					</p><a href="" title="">[+ d'infos]</a>
					<h6>développement d'un annuaire des anciens élèves</h6>
					<p>description du projet : 
					</p><a href="" title="">[+ d'infos]</a>
					</div>
				</div>
		
		</div>
	
	</div>
</div>
				<footer>
								<%-- Div footer --%>
								<div id="footer">
								<a href="" title="">Mentions légales</a> - <a href="" title="">Site officiel de l'IMIE</a> - <a href="" title="">Contact</a>
								</div>
				</footer>

</body>
</html>
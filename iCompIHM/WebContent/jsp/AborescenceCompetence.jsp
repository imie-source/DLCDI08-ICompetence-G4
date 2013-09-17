<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Competence</title>
<link rel="stylesheet" href="css/style.css" media="all" type="text/css" />
<link rel="stylesheet" href="css/ArborescenceCompetence.css" media="all" type="text/css" />
</head>
<body>

<div id="mainWrapper">
	<div id="title">
		<h1>Competence</h1>
	</div>
	<div id="wrapper">
		<div id="dialog-form" title="RechercherCompetence">
				<form name="Recherche" method="get" action="index">
					Veuillez saisir une competence
					<input type="text" name="competence" id="competence" /> 
					<input type="submit" value="Recherche" />
				</form>
				
		</div>
		<div class="css-treeview" title="treeviewDomaineComptence">
			 <ul>
        		<li><input type="checkbox" id="item-0" /><label for="item-0">This Folder is Closed By Default</label>
            		<ul>
                		<li><input type="checkbox" id="item-0-0" /><label for="item-0-0">Ooops! A Nested Folder</label>
                    		<ul>
                        		<li><input type="checkbox" id="item-0-0-0" /><label for="item-0-0-0">Look Ma - No Hands!</label>
                            		
                                		<li><a href="./">First Nested Item</a></li>
                                		<li><a href="./">Second Nested Item</a></li>
                                		
                            		
                        		</li>
                        		
                    		</ul>
                		</li>
               		 	
                	</ul>
                </li>
                <li><input type="checkbox" id="item-1" checked="checked" /><label for="item-1">This One is Open by Default...</label>
        			<ul>
            			<li><input type="checkbox" id="item-1-0" /><label for="item-1-0">And Contains More Nested Items...</label>
                			<ul>
                    			<li><a href="./">Look Ma - No Hands</a></li>
                    			<li><a href="./">Another Item</a></li>
                    			
                			</ul>
            				</li>
            				<li><a href="./">Lorem</a></li>
            				<li><a href="./">Ipsum</a></li>
            				
        			</ul>
				</li>
             </ul>
              
				
				
		</div>
		
		<div id="dialog-form2" title="treevieu">
				<form name="Recherche" method="get" action="index">
				
					<input type="submit" value="Supprimer" /> 
					<input type="submit" value="Modifier" />
					
				</form>
				
		</div>
	
	
	
	</div>
	<div id="footer">
	</div>
</div>

</body>
</html>
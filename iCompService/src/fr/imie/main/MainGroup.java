package fr.imie.main;

import fr.imie.dto.Groupe;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;

public class MainGroup {

		
	
	// LISTE DES DONNEES D'UN GROUPE
	    
	    private static int grpid = 1;
	
	
		public static void groupedonnees() {
			
			
			
			
			IProjectService psvc = Factory.getInstance().createProjectService(null);
			
			System.out.println("********************************");
			System.out.println("DONNES PROJET");
			System.out.println("********************************\n");

			try {
				Groupe groupedon = psvc.findGroupById(grpid);
				 
				
				
					System.out.print(groupedon.getId() + " : "
							+ " " + groupedon.getNom() + " " + groupedon.getAvancement()
						    + " " +  groupedon.getDescription() 
						    + groupedon.getResume() + "---" + groupedon.getStatut().getId() 
						    + groupedon.getStatut().getLibelle() +	    "\n");
				
				System.out.println("\n********************************\n");

			} catch (Exception e) {
				System.out.println("Erreur à l'execution de Screen.groupedonnees()");
			}
		}
		
		public static void main(String[] args) {
			groupedonnees();
		}
	}
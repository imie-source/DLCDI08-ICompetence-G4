package fr.imie.main;

import fr.imie.dto.Statut;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;

public class MainStatut2 {

		
	
	// LISTE DES DONNEES D'UN STATUT
	    
	    private static String staId = "1";
	
	
		public static void statutdonnees() {
			
			
			
			
			IProjectService psvc = Factory.getInstance().createProjectService(null);
			
			System.out.println("********************************");
			System.out.println("\nDONNES STATUT");
			System.out.println("\n********************************\n");

			try {
				Statut statdon = psvc.findStatutById(staId);   
				
				
					System.out.print(statdon.getId() + " : "
							+ " " + statdon.getLibelle() + " "  + "\n");
				
				System.out.println("\n********************************\n");

			} catch (Exception e) {
				System.out.println("Erreur à l'execution de Screen.statutdonnees()");
			}
		}
		
		public static void main(String[] args) {
			statutdonnees();
		}
	}
package fr.imie.main;

import java.util.List;

import fr.imie.dto.Statut;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;


public class MainStatut {

	// LISTE DES CURSUS
	

	public static void statutList() {
		
		IProjectService svc = Factory.getInstance().createProjectService(null);
		
		System.out.println("********************************");
		System.out.println("\nLISTE STATUS");
		System.out.println("\n********************************\n");

		try {
			    
			List<Statut> liststa = svc.findallStatuts() ;

			for (Statut sta : liststa) {
				System.out.print(sta.getId() + " : "
						+ sta.getLibelle() + "\n");
			}

			System.out.println("\n********************************\n");

		} catch (Exception e) {
			System.out.println("Erreur à l'execution de Screen.staList()");
		}
	}
	
	public static void main(String[] args) {
		statutList();
	}
}
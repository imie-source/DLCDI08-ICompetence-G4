package fr.imie.main;

import java.util.List;

import fr.imie.dto.Groupe;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;

public class FindGroupByStatut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IProjectService svc = Factory.getInstance().createProjectService(null);
		System.out.println("Liste projets");
		try {
			List<Groupe> groupes = svc.findGroupByStatut(1);
			
			for (Groupe groupe : groupes) {
				System.out.println("le mot clé est " + groupe.getNom() + "\n");
			}
			

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}

}

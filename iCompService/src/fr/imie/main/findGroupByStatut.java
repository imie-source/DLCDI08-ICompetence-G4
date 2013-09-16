package fr.imie.main;

import java.util.List;

import fr.imie.dto.Groupe;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;

public class findGroupByStatut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IProjectService svc = Factory.getInstance().createProjectService(null);
		System.out.println("findGroupByStatut");
		try {
			List<Groupe> groupes = svc.findGroupByStatut(1);
			
			for (Groupe groupe : groupes) {
				System.out.println("groupe : " + groupe.getNom() + "\n");
				System.out.println("CP : " + groupe.getChefProjet().getNom() + "\n");
			}
			

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}

}

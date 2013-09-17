package fr.imie.main;

import java.util.List;

import fr.imie.dto.Profil;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IProjectService;

public class FindProfilByUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IProjectService svc = Factory.getInstance().createProjectService(null);
		System.out.println("findProfilByUser");
		try {
			Utilisateur user = new Utilisateur();
			user.setLogin("mha01");
			List<Profil> profils = svc.getProfilsByUser(user);
			
			for (Profil profil : profils) {
				System.out.println("profil : " + profil.getNom() + "\n");
			}
			

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}

}

package fr.imie.main;

import fr.imie.dao.interfaces.IAdresseDAO;
import fr.imie.dto.Adresse;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;

public class MainFindUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IAdresseDAO svc = Factory.getInstance().createAdresseDAO(null);
		System.out.println("findUserByLogin");
		try {
			Utilisateur user = new Utilisateur();
			user.setId(1);
			Adresse adresse = svc.getAdresseByUser(user);
			
			System.out.println("id user : " + user.getId());
			System.out.println("id adresse : " + adresse.getId() + "\n");
			

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}
		

	}

}

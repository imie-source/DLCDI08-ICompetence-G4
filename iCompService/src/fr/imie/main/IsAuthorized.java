package fr.imie.main;

import fr.imie.dto.Profil;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.TransactionalConnectionException;

public class IsAuthorized {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserService svcUser = Factory.getInstance()
				.createUserService(null);

		Utilisateur user = new Utilisateur();
		user.setLogin("mha01");
		user.setPass("mha01");
		Utilisateur userAuthorized = null;
		try {
			userAuthorized = svcUser.IsAuthorized(user);
		} catch (TransactionalConnectionException e) {
			e.printStackTrace();
		}
		if (userAuthorized != null) {
			System.out.println("Login : " + userAuthorized.getLogin());
			for (Profil profil : userAuthorized.getProfils()) {
				System.out.println("Profil : " + profil.getNom());
			}
		}
	}

}

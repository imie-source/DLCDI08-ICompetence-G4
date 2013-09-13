package fr.imie.main;

import java.util.List;

import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;

public class MainAfficheUsersGRPID {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println("Liste Uilisateurs par projet");
		
	
		try {
			String grpid = "2";
			IUserService svc = Factory.getInstance().createUserService(null);
			List<Utilisateur> list = svc.getUsersbyGrpId(grpid);

			for (Utilisateur var : list) {
				System.out.println(var.getNom() + "\n");
			}
			System.out.println("Fin");

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}
		

	

}

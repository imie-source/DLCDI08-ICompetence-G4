package fr.imie.main;

import java.util.List;

import fr.imie.dto.Cursus;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;


public class AfficheListeCursus {

	// LISTE DES CURSUS

	public static void cursusList() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nLISTE CURSUS");
		System.out.println("\n********************************\n");

		try {

			List<Cursus> listcur = svc.findAllCursus();

			for (Cursus cur : listcur) {
				System.out.print(cur.getId() + " : "
						+ cur.getLibelle() + "\n");
			}

			System.out.println("\n********************************\n");

		} catch (Exception e) {

			System.out.println("Erreur à l'execution de Screen.cursusList()");
			e.printStackTrace(); // @TODO A preciser / A gerer

		}
	}
	
	public static void main(String[] args) {
		cursusList();
	}
}

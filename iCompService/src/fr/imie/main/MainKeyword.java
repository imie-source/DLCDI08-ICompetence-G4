package fr.imie.main;

import java.util.List;

import fr.imie.dto.Keyword;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;

public class MainKeyword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserService svc = Factory.getInstance().createUserService(null);
		System.out.println("Liste Keyword");
		try {
			List<Keyword> list = svc.getKeyword();
			
			for(Keyword var : list){
				System.out.println(var.getId() + " : " + var.getLibelle() + "\n");
			}
			
		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}

}

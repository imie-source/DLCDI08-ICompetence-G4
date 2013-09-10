package fr.imie.main;

import java.util.List;

import fr.imie.dto.Competence;
import fr.imie.dto.Keyword;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;

public class MainGetCompetenceByKeyword {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IUserService svc = Factory.getInstance().createUserService(null);
		System.out.println("Get Competence By keyword");
		Keyword keyword = new Keyword();
		keyword.setLibelle("java");
		try {
			List<Competence> list = svc.getCompetenceByKeyword(keyword);

			for (Competence var : list) {
				System.out.println(var.getLibelle()
						+ "\n");
			}
			System.out.println("Fin");

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}

	}

}

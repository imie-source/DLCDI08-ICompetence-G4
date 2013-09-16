package fr.imie.main;

import java.util.List;

import fr.imie.dto.Competence;
import fr.imie.dto.Keyword;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;


public class AfficheListeCursus {

	// LISTE DES CURSUS

	public static void cursusList() {
		IUserService svc = Factory.getInstance().createUserService(null);
		System.out.println("Liste Keyword");
		try {
			Keyword keyword = new Keyword();
			keyword.setLibelle("UML");
			List<Competence> competences = svc.findCompetenceByKeyword(keyword);
			
			for (Competence competence : competences) {
				System.out.println("le mot clé est " + competence.getLibelle() + "\n");
			}
			

		} catch (Exception e) {
			System.out.println("erreur");
			e.printStackTrace();
		}
		

	}
	
	public static void main(String[] args) {
		cursusList();
	}
}

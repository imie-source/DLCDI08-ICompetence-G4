package fr.imie.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fr.imie.dto.Competence;
import fr.imie.dto.Cursus;
import fr.imie.dto.Niveau;
import fr.imie.dto.Utilisateur;
import fr.imie.factory.Factory;
import fr.imie.service.interfaces.IUserService;
import fr.imie.transactionalFramework.TransactionalConnectionException;
//import java.util.Iterator;

public class ScreenV2 {

	// MENU

	public static int menu() {

		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nMENU");
		System.out.println("\n********************************\n");
		System.out.println("1 - Liste Utilisateurs");
		System.out.println("2 - Liste Competences");
		System.out.println("3 - Exit");

		System.out.print("\nChoix : ");

		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!line.equals("1") && !line.equals("2") && !line.equals("3")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de saisie !\n");
			System.out.println("1 - Liste Utilisateurs");
			System.out.println("2 - Liste Competences");
			System.out.println("3 - Exit");

			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return Integer.valueOf(line);

	}

	// COMPETENCES DES UTILISATEURS

	public static int usersComp() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nCOMPETENCES DES UTILISATEURS");
		System.out.println("\n********************************\n");

		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		List<Utilisateur> listuser = null;
		try {
			listuser = svc.getUsers();
		} catch (Exception e) {
			System.out.println("Erreur à l'execution de Screen.usersComp()");
			e.printStackTrace(); // @TODO A preciser / A gerer

		}

		if (listuser != null) {
			for (Utilisateur usr : listuser) {
				System.out.print("\n" + usr.getId() + " : "
						+ usr.getPrenom() + " " + usr.getNom() + " - "
						+ usr.getAge() + " ans \n");

				List<Competence> listcompetence = usr.getCompetences();

				for (Competence competence : listcompetence) {
					System.out.print("|- " + competence.getLibelle());

					List<Niveau> listniveau = competence.getListNiveau();

					for (Niveau niv : listniveau) {
						System.out.println(" - " + niv.getDescription());
					}
				}
			}
		}

		System.out.println("\n********************************\n");

		System.out.println("0 - Retour au Menu");
		System.out.print("\nChoix : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!line.equals("0")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de Saisie !\n");
			System.out.println("0 - Retour au Menu");
			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Integer.valueOf(line);

	}

	// LISTE DES UTILISATEURS

	public static int usersList() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nLISTE UTILISATEURS");
		System.out.println("\n********************************\n");
		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		List<Utilisateur> listuser = null;

		try {
			listuser = svc.getUsers();
		} catch (Exception e) {
			System.out.println("Erreur à l'execution de Screen.usersList()");
		}

		Main.currentUsers = listuser;
		int i = 1;

		if (listuser != null) {
			for (Utilisateur usr : listuser) {
				System.out
						.print("\n" + i + " : " + usr.getPrenom() + " "
								+ usr.getNom() + " - " + usr.getAge()
								+ " ans \n");
				i++;
			}
		}

		System.out.println("\n********************************\n");

		System.out.println("0 - Retour au Menu");
		System.out.println("1 - Competences des Utilisateurs");
		System.out.println("2 - Selectionner un Utilisateur");
		System.out.println("\n3 - Creer un Utilisateur");
		System.out.println("4 - Supprimer un Utilisateur");

		System.out.print("\nChoix : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TANT QUE "ERREUR DE SAISIE" DANS LA LISTE UTILISATEUR,
		// REDEMANDER
		// UN CHOIX

		while (!line.equals("0") && !line.equals("1") && !line.equals("2")
				&& !line.equals("3") && !line.equals("4")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de Saisie !\n");
			System.out.println("0 - Retour au Menu");
			System.out.println("1 - Competences des Utilisateurs");
			System.out.println("2 - Selectionner un Utilisateur");
			System.out.println("3 - Creer un Utilisateur");
			System.out.println("4 - Supprimer un Utilisateur");

			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Integer.valueOf(line);

	}

	// LISTE DES COMPETENCES

	public static int competencesList() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nLISTE COMPETENCES");
		System.out.println("\n********************************\n");
		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		List<Competence> listcom = null;

		try {
			listcom = svc.getCompetences();
		} catch (Exception e) {
			System.out
					.println("Erreur à l'execution de Screen.competencesList()");
		}

		for (Competence com : listcom) {
			System.out.print("\n" + com.getId() + " : "
					+ com.getLibelle());
		}

		System.out.println("\n********************************\n");

		System.out.println("0 - Retour au Menu");
		System.out.println("1 - Utilisateurs par Competences");
		System.out.print("\nChoix : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TANT QUE "ERREUR DE SAISIE" DANS LISTE COMPETENCES,
		// REDEMANDER UN CHOIX

		while (!line.equals("0") && !line.equals("1")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de Saisie !\n");
			System.out.println("0 - Retour au Menu");
			System.out.println("1 - Utilisateurs par Competences");
			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return Integer.valueOf(line);

	}

	// UTILISATEURS PAR COMPETENCE

	public static int competencesUser() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nUTILISATEURS PAR COMPETENCE");
		System.out.println("\n********************************\n");
		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		List<Competence> listcom = null;

		try {
			listcom = svc.getCompetences();
		} catch (Exception e) {

			System.out
					.println("Erreur à l'execution de Screen.competencesUser()");
			e.printStackTrace(); // @TODO A preciser / A gerer

		}

		for (Competence com : listcom) {
			System.out.print("\n" + com.getId() + " : "
					+ com.getLibelle() + "\n");

			List<Utilisateur> listuser = com.getUtilisateur();

			for (Utilisateur usr : listuser) {
				System.out.print("|- " + usr.getId() + " "
						+ usr.getPrenom() + " " + usr.getNom() + "\n");

				/*
				 * ArrayList<Niveau> listniveau = competence.getNiveau();
				 * Iterator<Niveau> nivitr = listniveau.iterator();
				 * 
				 * while (nivitr.hasNext()) {
				 * 
				 * Niveau niv = nivitr.next(); System.out.println(" - " +
				 * niv.getNivlibelle());
				 * 
				 * }
				 */

			}

		}

		System.out.println("\n********************************\n");

		System.out.println("0 - Retour au Menu");
		System.out.print("\nChoix : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// TANT QUE "ERREUR DE SAISIE" DANS UTILISATEURS PAR COMPETENCE,
		// REDEMANDER UN CHOIX

		while (!line.equals("0")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de Saisie !\n");
			System.out.println("0 - Retour au Menu");
			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Integer.valueOf(line);

	}

	// FICHE UTILISATEUR

	public static int userSelect(Utilisateur user) {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		System.out.println("\033[2J\033[;H");
		System.out.println("********************************");
		System.out.println("\nFICHE UTILISATEUR");
		System.out.println("\n********************************\n");
		String line = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			System.out.println("Nom : " + user.getNom() + "\nPrenom : "
					+ user.getPrenom() + "\nAge : " + user.getAge()
					+ " ans\n");

			Cursus cur = svc.findCursusByUser(user);

			System.out.println("Cursus : " + cur.getLibelle() + "\n");

			List<Competence> listcom = svc.getCompetenceByUser(user);

			for (Competence com : listcom) {
				System.out.print("|- " + com.getLibelle() + "\n");
			}

			System.out.println("\n********************************\n");

			System.out.println("0 - Retour au Menu");
			System.out.println("1 - Precedent");
			System.out.print("\nChoix : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// TANT QUE "ERREUR DE SAISIE" DANS FICHE UTILISATEUR,
			// REDEMANDER UN CHOIX

			while (!line.equals("0") && !line.equals("1")) {

				System.out.println("\n********************************\n");
				System.out.println("Erreur de Saisie !\n");
				System.out.println("0 - Retour au Menu");
				System.out.println("1 - Precedent");
				System.out.print("\nChoix : ");

				try {
					line = buffer.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			System.out.println("Erreur à l'execution de Screen.userScreen()");
			e.printStackTrace(); // @TODO A preciser / A gerer
		}

		return Integer.valueOf(line);

	}

	// SUPPRIMER UTILISATEUR

	public static void userDel() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		String line = null;
		String choice = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedReader buffer2 = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Supprimer : ");

		try {
			choice = buffer2.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print("Sur ? (O/N) : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (!line.equalsIgnoreCase("O") && !line.equalsIgnoreCase("N")) {

			System.out.println("\n********************************\n");
			System.out.println("Erreur de Saisie !\n");
			System.out.print("\nSur ? (O/N) : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (line.equalsIgnoreCase("O")) {

			try {
				// Recupere l'utilisateur à supprimer dans la liste des
				// utilisateurs
				int choiceInt = Integer.valueOf(choice);
				Main.currentUser = Main.currentUsers.get(choiceInt - 1);
				svc.deleteUser(Main.currentUser);
			} catch (Exception sqle) {
				sqle.printStackTrace();
			}

		}

	}

	// AJOUTER UTILISATEUR

	public static void userAdd() {
		IUserService svc = Factory.getInstance().createUserService(null);
		
		Utilisateur user = new Utilisateur();
		String line = null;

		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		// ADD NOM

		System.out.println("\033[2J\033[;H");
		System.out.print("Nom : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setNom(line);

		// ADD PRENOM

		System.out.print("Prenom : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setPrenom(line);

		// ADD DATE NAISSANCE

		Boolean checked = false;

		while (!checked) {
			System.out.print("Date de naissance (JJ/MM/AAAA): ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Date datenaissance;
			try {
				datenaissance = new SimpleDateFormat("dd/MM/yyyy").parse(line);
				java.sql.Date d = new java.sql.Date(datenaissance.getTime());
				user.setDateNaissance(d);
				checked = true;
			} catch (ParseException e1) {
				System.out.println("\nMauvais Format !!");
				checked = false;
			}
		}

		// ADD MAIL

		System.out.print("Mail : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setMail(line);

		// ADD TEL

		System.out.print("Tel : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setTel(line);

		// ADD FAX

		System.out.print("Fax : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setFax(line);

		// ADD IDENTIFIANT

		System.out.print("\nIdentifiant : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		user.setLogin(line);

		// ADD PASSWORD

		Boolean correspond = false;

		while (!correspond) {

			System.out.print("Mot de Passe : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String mdp1 = line;

			System.out.print("Repeter Mot de Passe : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			String mdp2 = line;

			// SI MOT DE PASSE 1 ET MOT DE PASSE 2 CORRESPONDENT

			if (mdp1.equals(mdp2)) {
				correspond = true;
				user.setPass(mdp2);
			}
		}

		// ADD CURSUS

		line = null;

		ScreenV2.cursusList();
		System.out.print("\nCursus : ");

		try {
			line = buffer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//user.setCurNum(Integer.valueOf(line));

		Boolean created = false;

		while (!created) {

			System.out.println("\033[2J\033[;H");
			System.out.println("Recapitulatif :\n");
			System.out.println("Nom : " + user.getNom());
			System.out.println("Prenom : " + user.getPrenom());
			System.out.println("Date de naissance : "
					+ user.getDateNaissance());
			System.out.println("Mail : " + user.getMail());
			System.out.println("Tel : " + user.getTel());
			System.out.println("Fax : " + user.getFax());
			System.out.println("Identifiant : " + user.getLogin());
			System.out.println("Mot de Passe : " + user.getPass());
			//System.out.println("\nCursus : " + user.getCurNum());

			System.out.print("\nValider (O/N) : ");

			try {
				line = buffer.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (line.equalsIgnoreCase("O")) {

				try {
					svc.insertUser(user);
				} catch (TransactionalConnectionException e) {
					System.out.println("Erreur d'insertion");
				}
				System.out.println("\nUtilisateur cree avec succes.");
				created = true;
			}

		}
	}

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

}

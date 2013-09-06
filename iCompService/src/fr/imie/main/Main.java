package fr.imie.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import fr.imie.dto.Utilisateur;

public class Main {
	// classe principale
/*	private static ScreenName currentScreen = null;
	public static Utilisateur currentUser = null;
	public static List<Utilisateur> currentUsers = null;

	public static void main(String[] args) {

		currentScreen = ScreenName.menu;
		Boolean endApplication = false;
		int i;

		while (!endApplication) {

			switch (currentScreen) {

			// MENU

			case menu:

				i = ScreenV2.menu();

				switch (i) {

				case 1:

					currentScreen = ScreenName.users_list;
					break;

				case 2:

					currentScreen = ScreenName.comp_list;
					break;

				case 3:

					endApplication = true;
					break;

				default:

					break;

				}

				break;

			// LISTE UTILISATEUR

			case users_list:

				i = ScreenV2.usersList();

				switch (i) {

				case 0:

					currentScreen = ScreenName.menu;
					break;

				case 1:

					currentScreen = ScreenName.users_comp;
					break;

				case 2:

					currentScreen = ScreenName.users_select;
					break;

				case 3:

					currentScreen = ScreenName.users_add;
					break;

				case 4:

					currentScreen = ScreenName.users_del;

				default:

					break;

				}
				break;

			// COMPETENCES PAR UTILISATEUR

			case users_comp:

				i = ScreenV2.usersComp();

				switch (i) {

				case 0:

					currentScreen = ScreenName.menu;
					break;

				default:

					break;

				}

				break;

			// SELECTION D'UN UTILISATEUR

			case users_select:

				String line = null;
				BufferedReader buffer = new BufferedReader(
						new InputStreamReader(System.in));

				System.out.print("Selection : ");

				try {

					line = buffer.readLine();

				} catch (IOException e) {

					e.printStackTrace();

				}

				int choice = Integer.valueOf(line);
				currentUser = currentUsers.get(choice - 1);
				i = ScreenV2.userSelect(currentUser);

				switch (i) {

				case 0:

					currentScreen = ScreenName.menu;
					break;

				case 1:

					currentScreen = ScreenName.users_list;
					break;

				default:

					break;

				}

				break;

			// AJOUTER UN UTILISATEUR

			case users_add:

				ScreenV2.userAdd();
				currentScreen = ScreenName.users_list;
				break;

			// SUPPRIMER UN UTILISATEUR

			case users_del:

				ScreenV2.userDel();
				currentScreen = ScreenName.users_list;
				break;

			// LISTE DES COMPETENCES

			case comp_list:

				i = ScreenV2.competencesList();

				switch (i) {

				case 0:

					currentScreen = ScreenName.menu;
					break;

				case 1:

					currentScreen = ScreenName.comp_users;
					break;

				default:

					break;

				}

				break;

			// UTILISATEURS PAR COMPETENCE

			case comp_users:

				i = ScreenV2.competencesUser();

				switch (i) {

				case 0:

					currentScreen = ScreenName.menu;
					break;

				}

			}

		}
	}*/
	
	
}

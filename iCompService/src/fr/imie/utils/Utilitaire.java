package fr.imie.utils;

import java.util.Calendar;
import java.util.Date;

// Utilisation du pattern SINGLETON
/**
 * 
 * @author Michel Hardy
 *
 */
public class Utilitaire {

	private static Utilitaire instance;

	public void Util() {
	}

	public static synchronized Utilitaire getInstance() {
		if (instance == null) {
			instance = new Utilitaire();
		}
		return instance;
	}


	/**
	 * 
	 * @param variable au format date
	 * @return L'age (entier)
	 * @author Michel Hardy
	 */
	public int getAge(Date dating) {
		int age = 0;
		if (dating != null) {
			Calendar dob = Calendar.getInstance();
			dob.setTime(dating);
			Calendar today = Calendar.getInstance();
			age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
			if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
				age--;
			} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
					&& today.get(Calendar.DAY_OF_MONTH) < dob
							.get(Calendar.DAY_OF_MONTH)) {
				age--;
			}
		}
		return age;
	}
	
	/**
	 * 
	 * @param message
	 */
	public static void arret(String message) {
		System.err.println(message);
		System.exit(99);
	}

}

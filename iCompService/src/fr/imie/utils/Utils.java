package fr.imie.utils;

import java.sql.Date;
import java.util.Calendar;

/**
 * Converter Utils
 * 
 * @author imie
 * @version 1.0
 */
public class Utils {

	private static Utils instance;

	/**
	 * ConvertUtils Constructor based on Singleton Pattern
	 */
	private Utils() {

	}

	/**
	 * Get ConvertUtils instance
	 * 
	 * @return instance of ConvertUtils
	 */
	public static synchronized Utils getInstance() {

		if (instance == null) {
			instance = new Utils();
		}

		return instance;

	}

	/**
	 * Convert birth date to age
	 * 
	 * @param date
	 *            birth date to set to age
	 * @return age
	 */
	public int dateNToAge(Date d) {

		Calendar curr = Calendar.getInstance();
		Calendar birth = Calendar.getInstance();
		birth.setTime(d);
		int yeardiff = curr.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
		curr.add(Calendar.YEAR, -yeardiff);
		if (birth.after(curr)) {
			yeardiff = yeardiff - 1;
		}
		return yeardiff;

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
	
}

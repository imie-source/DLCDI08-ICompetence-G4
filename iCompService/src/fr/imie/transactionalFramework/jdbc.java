package fr.imie.transactionalFramework;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class jdbc {
	private static final String BUNDLE_NAME = "fr.imie.transactionalFramework.jdbc"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private jdbc() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

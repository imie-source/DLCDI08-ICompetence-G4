package org.imie.servlet.filters;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class env {
	private static final String BUNDLE_NAME = "org.imie.servlet.filters.env"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private env() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}

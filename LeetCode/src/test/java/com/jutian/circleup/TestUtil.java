package com.jutian.circleup;

import java.net.URL;

/**
 * testing utilities.
 */
public enum TestUtil {

	/**
	 * singleton.
	 */
	SINGLETON;

	public String getFullPath(final String fileOnClassPath) {
		URL url = this.getClass().getResource(fileOnClassPath);
		if (url == null) {
			throw new RuntimeException("Cannot find resource on classpath: '"
					+ fileOnClassPath + "'");
		}
		return url.getFile();
	}
}

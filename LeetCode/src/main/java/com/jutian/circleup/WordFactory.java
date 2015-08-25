package com.jutian.circleup;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * create words.
 */
public enum WordFactory {

	SINGLETON;

	public List<String> getWords(final String fileFullPath) throws IOException {
		List<String> words = new ArrayList<String>();
		Scanner scan = null;
		String str = null;

		try {
			scan = new Scanner(new File(fileFullPath));
			while (scan.hasNextLine()) {
				str = scan.nextLine();
				words.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		return words;
	}
}

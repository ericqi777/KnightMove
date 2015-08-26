package com.jutian.circleup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum MatrixFactory {

	/**
	 * singleton.
	 */
	SINGLETON;

	public String[][] buildMatrix(final String fileFullPath) {
		Scanner scan = null;
		int column = 0;
		int row = 0;
		String str = "";
		boolean first = true;
		try {
			scan = new Scanner(new File(fileFullPath));
			while (scan.hasNextLine()) {
				str = str + scan.nextLine();
				if (first == true) {
					column = str.length();
					first = false;
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
		String[][] matrix = new String[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = String.valueOf(str.charAt( i * column + j));
						//.substring(i * column + j, i * column + j + 1);
			}
		}
		return matrix;
	}
}

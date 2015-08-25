package com.jutian.circleup;

import java.util.HashSet;
import java.util.Set;

public class WordFinderWithDFS extends AbstractWordFinder {

	public WordFinderWithDFS(final int maxPath) {
		super(maxPath);
	}
	private void generateWords(Set<String> allPossibleWords, String[][] matrix,
			String str, int currX, int currY, int step, int maxLength) {
		int[][] move = { { -1, -2 }, { -2, -1 }, { -1, 2 }, { -2, 1 },
				{ 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };
		int row = matrix.length;
		int column = matrix[0].length;
		while (step <= maxLength) {
			int next = 0;
			while (next < move.length) {
				boolean x = currX + move[next][0] < 0
						|| currX + move[next][0] >= column;
				boolean y = currY + move[next][1] < 0
						|| currX + move[next][1] >= row;
				while (x || y) {
					next++;
					x = currX + move[next][0] < 0
							|| currX + move[next][0] >= column;
					y = currY + move[next][1] < 0
							|| currY + move[next][1] >= row;
				}
				currX += move[next][0];
				currY += move[next][1];
				str += matrix[currY][currX];
				allPossibleWords.add(str);
				if (step < maxLength) {
					generateWords(allPossibleWords, matrix, str, currX, currY,
							step + 1, maxLength);
				}
				str = str.substring(0, str.length() - 1);
			}
		}
	}

	private String findFirst(String pre, String curr) {
		String first = null;
		int rst = 0;
		int index = 0;
		while (rst == 0 && index < pre.length()) {
			rst = pre.charAt(index) - curr.charAt(index);
			if (rst != 0) {
				if (rst > 0)
					first = curr;
				else
					first = pre;
			}
		}
		return first;
	}

	private String findLast(String pre, String curr) {
		String last = null;
		int rst = 0;
		int index = 0;
		while (rst == 0 && index < pre.length()) {
			rst = pre.charAt(index) - curr.charAt(index);
			if (rst != 0) {
				if (rst > 0)
					last = pre;
				else
					last = curr;
			}
		}
		return last;
	}

	protected Set<String> getAllPossibleWords(final String[][] matrix) {
		int row = matrix.length;
		int column = matrix.length;
		Set<String> allPossibleWords = new HashSet<String>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				generateWords(allPossibleWords, matrix, matrix[i][j], i, j, 1,
						maxLength);
			}
		}
		return allPossibleWords;
	}
}

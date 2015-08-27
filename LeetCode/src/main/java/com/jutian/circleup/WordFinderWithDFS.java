package com.jutian.circleup;

import java.util.HashSet;
import java.util.Set;

public class WordFinderWithDFS extends AbstractWordFinder {

	public WordFinderWithDFS(final int maxPath) {
		super(maxPath);
	}
	private void generateWords(Set<String> allPossibleWords, String[][] matrix,
			String str, int currX, int currY, int step, int maxLength, int next) {
		int[][] move = { { -1, -2 }, { 1, 2 }, { -2, -1 }, { 2, 1 }, { -1, 2 },
				{ 1, -2 }, { -2, 1 }, { 2, -1 } };
		int row = matrix.length;
		int column = matrix[0].length;
		
		
		if(!allPossibleWords.contains(str)){
			allPossibleWords.add(str);
		}
		
		if(step >= maxLength ){
			return;
		}
		if(next == 7)
			next = 0;
		
		while(str.length() < maxLength && next != move.length - 1){
			for(int i = 0; i < move.length; i++){
				next = i;
				if(str.length() < maxLength){
					int nextX = currX + move[i][0];
					int nextY = currY + move[i][1];
					
					if((nextX >= 0 && nextX < column) && (nextY >= 0 && nextY < row)){
						str += matrix[nextY][nextX];
						
						step++;
						generateWords (allPossibleWords, matrix, str, nextX, nextY, step, maxLength, next);
						str = str.substring(0, str.length()-1);
						step--;

					}
				}
				
/*				if((str.length() < maxLength) && (currX + move[i][0] >= 0 && currX + move[i][0] < column)&&
						(currY + move[i][1] >= 0 && currY + move[i][1] <row)){
					currX += move[i][0];
					currY += move[i][1];
					str += matrix[currY][currX];
					step++;
					allPossibleWords.add(str);
					generateWords (allPossibleWords, matrix, str, currX, currY, step, maxLength, next + 1);
				}*/
				
			}
		}
		
		
	}

	protected Set<String> getAllPossibleWords(final String[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		Set<String> allPossibleWords = new HashSet<String>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				allPossibleWords.add(matrix[i][j]);
				generateWords(allPossibleWords, matrix, matrix[i][j], j, i, 1,
						4, 0);
			}
		}
		return allPossibleWords;
	}
}

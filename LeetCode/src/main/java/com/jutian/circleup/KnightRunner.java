package com.jutian.circleup;

import java.util.Collection;
import com.jutian.circleup.WordFinderFactory.MoveStrategy;

/**
 *  entry point to run the logic.
 *  
 * @author Jutian
 *
 */
public class KnightRunner {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("need 2 arguments");
			return;
		}
		String wordFileClassPath = args[0];
		String metrixClassPath = args[1];
		Collection<String> words = WordFactory.SINGLETON.getWords(wordFileClassPath);
		int maxLength = getMaxLength(words);
		String[][] metrix = MatrixFactory.SINGLETON.buildMatrix(metrixClassPath);
		WordFinder wordFinder = WordFinderFactory.SINGLETON.getWordFinder(MoveStrategy.KNIGHT, maxLength);
		Collection<Result> results = wordFinder.run(words, metrix);
		//printResult(results);
		new QuestionOneAnswer().answer(results);
		//new QuestionTwoAnswer().answer(results);
	}

	private static int getMaxLength(Collection<String> words) {
		int maxLength = 0;
		for(String word :words){
			if(word.length() >= maxLength){
				maxLength = word.length();
			}
		}		
		return maxLength;
	}

//	private static void printResult(Collection<Result> results) {
//		for (Result result : results) {
//			if (result.isFound()) {
//				System.out.println(result.getWord() + " is found!");
//			} else {
//				System.out.println(result.getWord() + " is NOT found!");
//			}
//		}
//		
//	}
}

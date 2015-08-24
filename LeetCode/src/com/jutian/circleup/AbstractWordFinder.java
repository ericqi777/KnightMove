package com.jutian.circleup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * algorithm:¡¡
 * get all the possible words from different paths in the matrix.
 * then loops through the input list and check if the word exists in
 * the possible words.
 * 
 * @author Jutian
 *
 */
public abstract class AbstractWordFinder implements WordFinder {

	final int maxLength;

	protected AbstractWordFinder(final int maxLength) {
		this.maxLength = maxLength;
	}

	@Override
	public List<Result> run(Collection<String> words, String[][] metrix) {
		Set<String> allPossibleWords = this.getAllPossibleWords(metrix);
		List<Result> results = new ArrayList<Result>();

		for (String word : words) {
			if (allPossibleWords.contains(word)) {
				results.add(new Result(word, true));
			} else {
				results.add(new Result(word, false));
			}
		}
		return results;
	}

	protected abstract Set<String> getAllPossibleWords(String[][] metrix);
}

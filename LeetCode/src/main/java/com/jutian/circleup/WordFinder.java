package com.jutian.circleup;

import java.util.Collection;

/**
 * check if words can be found by walking through a matrix.
 */
public interface WordFinder {

	/**
	 * @param words words to be found.
	 * @param matrix matrix containg letters.
	 * @return {@link Result}s.
	 */
	Collection<Result> run(Collection<String> words, String[][] matrix);
} 

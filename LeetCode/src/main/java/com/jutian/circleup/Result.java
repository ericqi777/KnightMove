package com.jutian.circleup;

import java.util.Comparator;

/**
 * matching result.
 */
public class Result {

	private String word;
	private boolean isFound;

	/**
	 * constructor.
	 * @param word  the word to be matched.
	 * @param isFound true if found.  false otherwise.
	 */
	public Result(final String word, final boolean isFound) {
		this.word = word;
		this.isFound = isFound;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isFound ? 1231 : 1237);
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (isFound != other.isFound)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	/**
	 * @return the word.
	 */
	public String getWord() {
		return word;
	}

	/**
	 * @return true if found.  false if not.
	 */
	public boolean isFound() {
		return isFound;
	}

	/**
	 * compare 2 results.
	 */
	public static class ResultComparator implements Comparator<Result> {

		public int compare(Result arg0, Result arg1) {
			return arg0.getWord().compareTo(arg1.getWord());
		}

	}
}

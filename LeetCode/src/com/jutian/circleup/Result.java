package com.jutian.circleup;

import java.util.Comparator;

public class Result {

	private String word;
	private boolean isFound;
	
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

	public String getWord() {
		return word;
	}
	public boolean isFound() {
		return isFound;
	}
	
	public static class ResultComparator implements Comparator<Result> {

		@Override
		public int compare(Result arg0, Result arg1) {
			return arg0.getWord().compareTo(arg1.getWord());
		}
		
	}
}

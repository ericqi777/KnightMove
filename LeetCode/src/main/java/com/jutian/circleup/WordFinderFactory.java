package com.jutian.circleup;

public enum WordFinderFactory {

	SINGLETON;
	
	/**
	 * only supports {@link MoveStrategy#KNIGHT}.
	 * @param moveStrategy
	 * @return an instance of {@link WordFinder} that can handle the <code>moveStrategy</code>.
	 */
	public WordFinder getWordFinder(final MoveStrategy moveStrategy, final int maxPath) {
		if (null == moveStrategy) {
			throw new RuntimeException("moveStrategy can't be null/empty");
		}
		
		switch (moveStrategy) {
			case KNIGHT :
			default :
				return new WordFinderWithDFS(maxPath);
		}
	}
	
	public static enum MoveStrategy {
		KNIGHT;
	}
}

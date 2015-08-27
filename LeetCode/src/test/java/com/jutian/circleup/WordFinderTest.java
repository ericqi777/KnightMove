package com.jutian.circleup;

import java.io.IOException;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.jutian.circleup.WordFinderFactory.MoveStrategy;
import com.jutian.circleup.test.util.TestUtil;

/**
 * Tests {@link WordFinder}.
 */
public class WordFinderTest {

	@Test
	public void testSimple() throws IOException {
		String wordsFileOnClassPath = "/word/words.4.simple.matrix.txt";
		String wordsFileFullPath = TestUtil.SINGLETON.getFullPath(wordsFileOnClassPath);
		
		String matrixFileOnClasspath = "/matrix/simple.matrix.txt";
		String matrixFileFullPath = TestUtil.SINGLETON.getFullPath(matrixFileOnClasspath);
		
		Collection<String> words = WordFactory.SINGLETON.getWords(wordsFileFullPath);
		
		int maxLength = KnightRunner.getMaxLength(words);
		String[][] metrix = MatrixFactory.SINGLETON.buildMatrix(matrixFileFullPath);
		
		WordFinder wordFinder = WordFinderFactory.SINGLETON.getWordFinder(MoveStrategy.KNIGHT, maxLength);
		Collection<Result> results = wordFinder.run(words, metrix);
		Assert.assertEquals(2, results.size());

		boolean isACFound = false;
		boolean isACDFound = false;
		for (Result result : results) {
			Assert.assertTrue(result.isFound());
			if (result.getWord().equals("AC")) {
				isACFound = true;
			}
			if (result.getWord().equals("ACD")) {
				isACDFound = true;
			}
		}
		Assert.assertTrue(isACFound && isACDFound);
	}
}

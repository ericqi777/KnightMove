package com.jutian.circleup;

import org.junit.Assert;
import org.junit.Test;

/**
 * tests {@link Result}.
 */
public class ResultTest {

	@Test
	public void testConstructor() {
		String word = "ericqi";
		boolean isFound = true;
		
		Result result = new Result(word, isFound);
		
		Assert.assertEquals(word, result.getWord());
		Assert.assertTrue(result.isFound());
	}
}

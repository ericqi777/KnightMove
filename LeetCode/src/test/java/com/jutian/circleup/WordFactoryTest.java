package com.jutian.circleup;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.jutian.circleup.test.util.TestUtil;

/**
 * tests {@link WordFactory}.
 *
 */
public class WordFactoryTest {

	@Test
	public void testBuildMatrix() throws IOException {
		String fileOnClassPath = "/word/words.txt";
		String fullPath = TestUtil.SINGLETON.getFullPath(fileOnClassPath);
		Assert.assertNotNull(fullPath);
		
		List<String> words = WordFactory.SINGLETON.getWords(fullPath);
		
		Assert.assertNotNull(words);
		Assert.assertEquals(3,  words.size());
		Assert.assertEquals("eric", words.get(0));
		Assert.assertEquals("qi", words.get(1));
		Assert.assertEquals("hello", words.get(2));
	}
}

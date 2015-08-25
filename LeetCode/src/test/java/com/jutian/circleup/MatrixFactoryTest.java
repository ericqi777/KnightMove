package com.jutian.circleup;

import org.junit.Assert;
import org.junit.Test;

import com.jutian.circleup.test.util.TestUtil;

/**
 * tests {@link MatrixFactory}.
 *
 */
public class MatrixFactoryTest {

	private final String[] toBeVerified = new String[] { "A", "B", "C", "D", "E"};
	
	@Test
	public void testCreateMatrix() {
		String fileOnClassPath = "/matrix/simple.matrix.txt";
		String fullPath = TestUtil.SINGLETON.getFullPath(fileOnClassPath);
		Assert.assertNotNull(fullPath);
		
		String[][] matrix = MatrixFactory.SINGLETON.buildMatrix(fullPath);
		Assert.assertNotNull(matrix);
		
		Assert.assertEquals(5, matrix.length);
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(5, matrix[i].length);
			for (int j = 0; j < 5; j++) {
				Assert.assertEquals(toBeVerified[i], matrix[i][j]);
			}
		}
	}
}

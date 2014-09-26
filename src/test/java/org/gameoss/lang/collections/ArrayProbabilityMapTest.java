package org.gameoss.lang.collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the {@link ArrayProbabilityMap}
 * 
 * @author elvir.bahtijaragic
 */
public class ArrayProbabilityMapTest {
	@Test
	public void testNormalScenarioWithTwo() {
		ArrayProbabilityMap<Integer> probabilityMap = new ArrayProbabilityMap<Integer>();
		
		probabilityMap.put(0.5f, 1);
		probabilityMap.put(0.5f, 2);
		
		Assert.assertEquals(1, (int)probabilityMap.get(0.2f));
		Assert.assertEquals(2, (int)probabilityMap.get(0.5f));
		Assert.assertEquals(2, (int)probabilityMap.get(0.7f));
	}
	

	@Test
	public void testNormalScenarioWithTen() {
		ArrayProbabilityMap<Integer> probabilityMap = new ArrayProbabilityMap<Integer>();
		
		probabilityMap.put(0.1f, 1);
		probabilityMap.put(0.3f, 2);
		probabilityMap.put(0.05f, 3);
		probabilityMap.put(0.15f, 4);
		probabilityMap.put(0.01f, 5);
		probabilityMap.put(0.05f, 6);
		probabilityMap.put(0.04f, 7);
		probabilityMap.put(0.1f, 8);
		probabilityMap.put(0.05f, 9);
		probabilityMap.put(0.15f, 10);
		
		Assert.assertEquals(1, (int)probabilityMap.get(0.05f));
		Assert.assertEquals(2, (int)probabilityMap.get(0.32f));
		Assert.assertEquals(5, (int)probabilityMap.get(0.6f));
		Assert.assertEquals(8, (int)probabilityMap.get(0.7f));
		Assert.assertEquals(10, (int)probabilityMap.get(0.9f));
		Assert.assertEquals(10, (int)probabilityMap.get(1f));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPutWithInvalidProbabilityRange_Low() {
		ArrayProbabilityMap<Integer> probabilityMap = new ArrayProbabilityMap<Integer>();
		
		probabilityMap.put(-0.5f, 1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetWithInvalidProbabilityRange_Low() {
		ArrayProbabilityMap<Integer> probabilityMap = new ArrayProbabilityMap<Integer>();

		probabilityMap.put(0.5f, 1);
		probabilityMap.put(0.5f, 2);
		
		probabilityMap.get(-0.5f);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetWithInvalidProbabilityRange_High() {
		ArrayProbabilityMap<Integer> probabilityMap = new ArrayProbabilityMap<Integer>();

		probabilityMap.put(0.5f, 1);
		probabilityMap.put(0.5f, 2);
		
		probabilityMap.get(1.5f);
	}
}

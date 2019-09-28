package com.junit.JUnitExample;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest2 {

	
	@Test
	public void testEven()
	{
		assertTrue(new App().isEven(6));
	}
}

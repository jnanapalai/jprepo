package com.junit.JUnitExample;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class AppTest 
    
{
	@Test
	public void testHello()
	{
		assertEquals("Hello",new App().getHello());
	}
}

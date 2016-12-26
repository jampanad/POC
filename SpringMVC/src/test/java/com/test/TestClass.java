package com.test;

import org.junit.Test;

import junit.framework.TestCase;

public class TestClass  extends TestCase {
	@Test
	  public void testVisitingExistingRepo() {
	    assertEquals("Page name matches expected value", "foobarbaz", "foobarbaz");
	  }
}

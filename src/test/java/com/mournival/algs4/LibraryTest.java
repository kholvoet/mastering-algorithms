package com.mournival.algs4;

import org.junit.Test;

import edu.princeton.cs.algs4.BinarySearch;

import static org.junit.Assert.*;

public class LibraryTest {
	@Test
	public void testSomeLibraryMethod() {
		Library classUnderTest = new Library();
		assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
	}

	@Test
	public void testBinarySearch() {
		assertTrue(1 == BinarySearch.indexOf(new int[] { 1, 3, 4, 7 }, 3));
	}
}

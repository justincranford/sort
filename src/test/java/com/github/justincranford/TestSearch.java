package com.github.justincranford;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public class TestSearch {
	@Test public void testSearch() throws Exception {
		Assertions.assertThrows(Exception.class, () -> {
			SearchUtil.findSmallest(null, 1);
		});
		Assertions.assertThrows(Exception.class, () -> {
			TestSearch.testSearchHelper(0, 1);
		});
		Assertions.assertThrows(Exception.class, () -> {
			TestSearch.testSearchHelper(1, 0);
		});
		TestSearch.testSearchHelper(1, 1);
		Assertions.assertThrows(Exception.class, () -> {
			TestSearch.testSearchHelper(99, 100);
		});
		TestSearch.testSearchHelper(100,    100);
		TestSearch.testSearchHelper(101,    100);
		TestSearch.testSearchHelper(100000, 100);
	}

	private static void testSearchHelper(int N, int k) throws Exception {
		final Collection<Integer> data  = RandomUtil.createcollection(N, Integer.MAX_VALUE);
		final Collection<Integer> found = SearchUtil.findSmallest(data, k);
		AssertionUtil.verifySmallestFound(data, found, k);
	}
}
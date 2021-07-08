package com.github.justincranford;

import java.util.Collection;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;

public class AssertionUtil {
	public static void verifySorted(final int[] arr) {
		for (int i=1; i<arr.length; i++) {
			Assertions.assertTrue(arr[i-1] <= arr[i], "Expected " + arr[i-1] + " <= " + arr[i]);
		}
	}

	public static void verifySorted(final char[] arr) {
		for (int i=1; i<arr.length; i++) {
			Assertions.assertTrue(arr[i-1] <= arr[i], "Expected " + arr[i-1] + " <= " + arr[i]);
		}
	}

	public static void verifySmallestFound(final Collection<Integer> data, final Collection<Integer> found, final int k) {
		Assertions.assertEquals(k, found.size());
		final Integer largestFound = new TreeSet<>(found).last();
		data.removeAll(found);
		for (final Integer element : data) {
			Assertions.assertTrue(element >= largestFound);	// all remaining must be >= to the largest found
		}
	}
}
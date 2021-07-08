package com.github.justincranford;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public class TestQuickSortUtil {
	@Test public void testQuickSort() {
		TestQuickSortUtil.testQuickSortHelper(0,  99); // length=0,  maxElement=99
		TestQuickSortUtil.testQuickSortHelper(1,  99); // length=1,  maxElement=99
		TestQuickSortUtil.testQuickSortHelper(2,  99); // length=2,  maxElement=99
		TestQuickSortUtil.testQuickSortHelper(50, 99); // length=50, maxElement=99
	}

	private static void testQuickSortHelper(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		QuickSortUtil.recursiveQuickSort(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}
}
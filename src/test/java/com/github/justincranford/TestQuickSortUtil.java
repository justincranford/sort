package com.github.justincranford;

import org.junit.jupiter.api.Test;

public class TestQuickSortUtil {
	private static final int MAX_ELEMENT_VALUE = 99;
//	private static final int MAX_ELEMENT_VALUE = Integer.MAX_VALUE;

	@Test public void testQuickSortPartition2Way() {
		TestQuickSortUtil.testQuickSortHelperPartition2Way(0,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition2Way(1,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition2Way(2,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition2Way(99999, MAX_ELEMENT_VALUE); // CAVEAT: Too much recursion => Stack memory overflow
	}

	@Test public void testQuickSortPartition3Way() {
		TestQuickSortUtil.testQuickSortHelperPartition3Way(0,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition3Way(1,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition3Way(2,     MAX_ELEMENT_VALUE);
		TestQuickSortUtil.testQuickSortHelperPartition3Way(99999, MAX_ELEMENT_VALUE); // CAVEAT: Too much recursion => Stack memory overflow
	}

	private static void testQuickSortHelperPartition2Way(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		QuickSortUtil.recursiveQuickSortPartition2Way(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}

	private static void testQuickSortHelperPartition3Way(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		QuickSortUtil.recursiveQuickSortPartition3Way(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}
}
package com.github.justincranford;

import org.junit.jupiter.api.Test;

public class TestInsertionSortUtil {
	private static final int MAX_ELEMENT_VALUE = 99;
//	private static final int MAX_ELEMENT_VALUE = Integer.MAX_VALUE;

	@Test public void testIterativeInsertionSort() {
		TestInsertionSortUtil.testIterativeInsertionSortHelper(0,     MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testIterativeInsertionSortHelper(1,     MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testIterativeInsertionSortHelper(2,     MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testIterativeInsertionSortHelper(99999, MAX_ELEMENT_VALUE);
	}

	@Test public void testPreRecursiveInsertionSort() {
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(0,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(1,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(2,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(999, MAX_ELEMENT_VALUE); // CAVEAT: Too much recursion => Stack memory overflow
	}

	@Test public void testRecursiveInsertionSort2() {
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(0,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(1,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(2,   MAX_ELEMENT_VALUE);
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(999, MAX_ELEMENT_VALUE); // CAVEAT: Too much recursion => Stack memory overflow
	}

	private static void testIterativeInsertionSortHelper(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		InsertionSortUtil.iterativeInsertionSort(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}

	private static void testPreRecursiveInsertionSortHelper(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		InsertionSortUtil.preRecursiveInsertionSort(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}

	private static void testPostRecursiveInsertionSortHelper(int length, int maxelementvalue) {
		final int[] data = RandomUtil.createarray(length, maxelementvalue);
		InsertionSortUtil.postRecursiveInsertionSort(data);
		PrintUtil.print(null, data);
		AssertionUtil.verifySorted(data);
	}
}
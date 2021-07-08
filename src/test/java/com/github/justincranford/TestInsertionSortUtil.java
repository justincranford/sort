package com.github.justincranford;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public class TestInsertionSortUtil {
	@Test public void testIterativeInsertionSort() {
		TestInsertionSortUtil.testIterativeInsertionSortHelper(0,  99); // length=0,  maxElement=99
		TestInsertionSortUtil.testIterativeInsertionSortHelper(1,  99); // length=1,  maxElement=99
		TestInsertionSortUtil.testIterativeInsertionSortHelper(2,  99); // length=2,  maxElement=99
		TestInsertionSortUtil.testIterativeInsertionSortHelper(50, 99); // length=50, maxElement=99
	}

	@Test public void testPreRecursiveInsertionSort() {
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(0,  99); // length=0,  maxElement=99
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(1,  99); // length=1,  maxElement=99
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(2,  99); // length=2,  maxElement=99
		TestInsertionSortUtil.testPreRecursiveInsertionSortHelper(50, 99); // length=50, maxElement=99
	}

	@Test public void testRecursiveInsertionSort2() {
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(0,  99); // length=0,  maxElement=99
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(1,  99); // length=1,  maxElement=99
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(2,  99); // length=2,  maxElement=99
		TestInsertionSortUtil.testPostRecursiveInsertionSortHelper(50, 99); // length=50, maxElement=99
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
package com.github.justincranford;

public class SortUtil {
	private SortUtil() {};

	public static void swap(final int[] a, int i, int j) {
		int swapTemp = a[i];
		a[i] = a[j];
		a[j] = swapTemp;
	}
}
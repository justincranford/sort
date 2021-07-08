package com.github.justincranford;

public class InsertionSortUtil {
	private InsertionSortUtil() {}

	public static void iterativeInsertionSort(final int[] arr) {
		for (int unsortedIndex=1; unsortedIndex<arr.length; unsortedIndex++) {
			int unsortedValue = arr[unsortedIndex];
			int shiftIndex    = unsortedIndex - 1;
			while ( (shiftIndex >= 0) && (arr[shiftIndex] > unsortedValue) ) {
				arr[shiftIndex+1] = arr[shiftIndex];
				shiftIndex--;
			}
			arr[shiftIndex+1] = unsortedValue;
        }
	}

	public static void preRecursiveInsertionSort(final int[] arr) {
		InsertionSortUtil.preRecursiveInsertionSort(arr, arr.length);
	}
	public static void postRecursiveInsertionSort(final int[] arr) {
		postRecursiveInsertionSort(arr, 1);
	}

	private static void preRecursiveInsertionSort(final int[] arr, final int n) {
		if (n > 1) {
			InsertionSortUtil.preRecursiveInsertionSort(arr, n-1); // sort first n-1 elements
			int unsortedValue = arr[n-1]; // last element
			int shiftIndex    = n - 2;
			while ( (shiftIndex >= 0) && (arr[shiftIndex] > unsortedValue)) {
				arr[shiftIndex+1] = arr[shiftIndex];
				shiftIndex--;
			}
			arr[shiftIndex+1] = unsortedValue;
		}
	}

	private static void postRecursiveInsertionSort(final int[] arr, final int unsortedIndex) {
		if (unsortedIndex < arr.length) {
			int unsortedValue = arr[unsortedIndex];
			int sortedIndex   = unsortedIndex - 1;
			while ( (sortedIndex >= 0) && (arr[sortedIndex] > unsortedValue) ) {
				arr[sortedIndex+1] = arr[sortedIndex];
				sortedIndex--;
			}
			arr[sortedIndex+1] = unsortedValue;
			InsertionSortUtil.postRecursiveInsertionSort(arr, unsortedIndex+1);
		}
	}
}
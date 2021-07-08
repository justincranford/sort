package com.github.justincranford;

public class QuickSortUtil {
	public static void recursiveQuickSort(final int arr[]) {
		QuickSortUtil.recursiveQuickSort(arr, 0, arr.length-1);
	}
	public static void recursiveQuickSort(final int arr[], final int lo, final int hi) {
		PrintUtil.print(null, arr);
		System.out.println("lo=" + lo + ", hi=" + hi);
		if (lo < hi) {
			final int partitionIndex = QuickSortUtil.partition(arr, lo, hi);
			QuickSortUtil.recursiveQuickSort(arr, lo, partitionIndex-1);
			QuickSortUtil.recursiveQuickSort(arr, partitionIndex+1, hi);
		}
	}
	private static int partition(final int arr[], final int lo, final int hi) {
		final int pivot = arr[hi]; // choose last element as pivot
		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (arr[j] < pivot) {
				QuickSortUtil.swap(arr, i, j); // move j to end of sublist
				i++;
			}
		}
		QuickSortUtil.swap(arr, i, hi);
		return i;
	}

	public static void swap(final int[] arr, int i, int j) {
		int swapTemp = arr[i];
		arr[i] = arr[j];
		arr[j] = swapTemp;
	}
}
package com.github.justincranford;

public class QuickSortUtil {
	private QuickSortUtil() {}

	public static void recursiveQuickSortPartition2Way(final int a[]) {
		QuickSortUtil.recursiveQuickSortPartition2Way(a, 0, a.length-1);
	}
	public static void recursiveQuickSortPartition3Way(final int a[]) {
		QuickSortUtil.recursiveQuickSortPartition3Way(a, 0, a.length-1);
	}

	private static void recursiveQuickSortPartition3Way(final int a[], final int lo, final int hi) {
		if (hi <= lo) return;
		final int pivot = a[lo]; // choose first element as pivot
		int lt = lo;
		int gt = hi;
		int i  = lo + 1;
		while (i <= gt) {
			     if (a[i] < pivot) SortUtil.swap(a, lt++, i++);
			else if (a[i] > pivot) SortUtil.swap(a, i, gt--);
			else i++;
		}
		QuickSortUtil.recursiveQuickSortPartition3Way(a, lo, lt-1);
		QuickSortUtil.recursiveQuickSortPartition3Way(a, gt+1, hi);
	}

	private static void recursiveQuickSortPartition2Way(final int a[], final int lo, final int hi) {
		if (hi <= lo) return;
		final int pivotIndex = QuickSortUtil.partition2Way(a, lo, hi);
		QuickSortUtil.recursiveQuickSortPartition2Way(a, lo, pivotIndex-1);
		QuickSortUtil.recursiveQuickSortPartition2Way(a, pivotIndex+1, hi);
	}
	private static int partition2Way(final int a[], final int lo, final int hi) {
		final int pivot = a[lo]; // choose first element as pivot
		int lt = lo;
		int gt = hi + 1;
		while (true) {
			while ((a[++lt] < pivot) && (lt < hi)); // find lower  than pivot
			while ((a[--gt] > pivot) && (gt > lo)); // find higher than pivot
			if (lt >= gt) break;
			SortUtil.swap(a, lt, gt); // swap them and continue
		}
		SortUtil.swap(a, lo, gt); // pivot not covered by loop, move pivot into position
		return gt;
	}
}
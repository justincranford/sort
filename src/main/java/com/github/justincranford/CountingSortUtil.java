package com.github.justincranford;

public class CountingSortUtil {
	public static void countingSort(final char unsortedArray[]) {
		final int n = unsortedArray.length;

		// The output character array that will have sorted charArray
		final char sortedArray[] = new char[n];

		final int positions[] = new int[256];
		for (int i = 0; i <= 255; ++i) {
			positions[i] = 0; // INITIALIZE COUNTER
		}
		for (int i = 0; i <= n-1; ++i) {
			final char charValue = unsortedArray[i];
			final int  charCount = ++positions[charValue]; // INCREMENT COUNTER
			System.out.format("Counting:     c[%c] = c[%3d] = %d%n", charValue, (int)charValue, charCount);
		}
		PrintUtil.print("Counted:     ", positions);

		// Convert initial counts to character positions in the output array
		for (int i = 1; i <= 255; ++i) {
			positions[i] += positions[i - 1];
			System.out.format("Positioning: p[%3d] = %d%n", i, positions[i]);
		}
		PrintUtil.print("Positions:   ", positions);

		// Copy input characters to output positions. Reverse loop makes stable sort.
		for (int i = n - 1; i >= 0; i--) {
			final char charValue    = unsortedArray[i]; // s,k,e,e,g,r,o,f,s,k,e,e,g
			final int  charPosition = positions[charValue] - 1; // 12=s, 8=k, 3=e, 2=e, 6=g, 10=r, 9=o, 4=f, 1=s1, 7=k, 1=e, 0=e, 5=g
			System.out.format("Sorting:     s[%2d] = %c%n", charPosition, charValue);
			sortedArray[charPosition] = charValue;
			positions[charValue]--;
		}
		PrintUtil.print("Sorted:      ", sortedArray); // e,e,e,e,f,g,g,k,k,o,r,s,s

		// Overwrite unsorted array with contents of sorted array.
		for (int i = 0; i < n; ++i) {
			unsortedArray[i] = sortedArray[i];
		}
	}
}
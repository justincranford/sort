package com.github.justincranford;

public class PrintUtil {
	private PrintUtil() {};

	public static void print(final String message, final int[] arr) {
		if (null != message) {
			System.out.println(message);
		}
		if (0 == arr.length) {
			System.out.println("<Empty>");
		} else {
			System.out.print(arr[0]);
			for (int i=1; i<arr.length; i++) {
				System.out.print("," + arr[i]);
			}
			System.out.print("\n");
		}
	}

	public static void print(final String message, final char[] arr) {
		if (null != message) {
			System.out.println(message);
		}
		if (0 == arr.length) {
			System.out.println("<Empty>");
		} else {
			System.out.print(arr[0]);
			for (int i=1; i<arr.length; i++) {
				System.out.print("," + arr[i]);
			}
			System.out.print("\n");
		}
	}
}
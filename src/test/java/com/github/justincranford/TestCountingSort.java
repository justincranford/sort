package com.github.justincranford;

import org.junit.jupiter.api.Test;

@SuppressWarnings("static-method")
public class TestCountingSort {
	@Test public void testCountingSort() {
		char charArray[] = { 'j', 'u', 's', 't', 'i', 'n', 'c', 'r', 'a', 'n', 'f', 'o', 'r', 'd' };
		CountingSortUtil.countingSort(charArray);
		PrintUtil.print(null, charArray);
		AssertionUtil.verifySorted(charArray);
	}
}
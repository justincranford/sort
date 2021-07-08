package com.github.justincranford;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;

public class RandomUtil {
	private static SecureRandom SECURE_RANDOM = new SecureRandom();
	static {
		RandomUtil.createarray(1, 1);
	}

	private RandomUtil() {}

	public static Collection<Integer> createcollection(final int length, final int maxelementvalue) {
		final Collection<Integer> data = new ArrayList<>(length);
		for (int i=0; i<length; i++) {
			data.add(RandomUtil.SECURE_RANDOM.nextInt(maxelementvalue));
		}
		return data;
	}

	public static int[] createarray(final int length, final int maxelementvalue) {
		final int[] data = new int[length];
		for (int i=0; i<length; i++) {
			data[i] = RandomUtil.SECURE_RANDOM.nextInt(maxelementvalue);
		}
		return data;
	}
}
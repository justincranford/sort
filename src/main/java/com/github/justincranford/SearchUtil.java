package com.github.justincranford;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SearchUtil {
	private SearchUtil() {}

	/**
	 * Single pass of an unsorted array N to find the smallest k elements.
	 * @param N Large unsorted array.
	 * @param k Number of smallest elements to find.
	 * @return Collection of the smallest elements found.
	 * @throws Exception Invalid parameters.
	 */
	public static Collection<Integer> findSmallest(final Collection<Integer> N, final int k) throws Exception {
		if ((null == N) || (N.size() < 1) || (k < 1) || (N.size() < k)) {	// Total O(1)
			throw new Exception("Invalid parameters");						// Total O(1)
		}
		if (N.size() == k) {												// Total O(1)
			return N;														// Total O(1)
		}
		boolean doOneTimeSort = true;
		final SortedList<Integer> smallestIntegers = new SortedList<>();	// Total O(1)
		for (final Integer n : N) {											// Total O(N)
			if (smallestIntegers.size() < k) {								// Total O(N)
				smallestIntegers.addNoSort(n);								// Total O(N) => Delay sort until after initially filling up
			} else {														// Total O(N)
				if (doOneTimeSort) {										// Total O(N)
					smallestIntegers.sort();								// Total O(k * log k) => Do the delayed sort now, but only once
					doOneTimeSort = false;									// Total O(1)
				}
				final Integer largestFound = smallestIntegers.last();		// Total O(N)
				if (n < largestFound) {										// Total O(N)
					smallestIntegers.set(smallestIntegers.size()-1, n);		// Total O(N * k * log k)
				}
			}
		}
		return smallestIntegers;
	}

	public static class SortedList<E> extends AbstractList<E> {
	    private final ArrayList<E> list = new ArrayList<E>();
	    @Override public int size() {
	        return list.size();
	    }
	    @Override public E get(int i) {
	        return list.get(i);
	    }
	    @Override public void add(int position, E e) {
	        list.add(e);
	        Collections.sort(list, null);
	    }
	    @Override public E set(int position, E e) {
	    	final E current = list.set(position, e);
	        Collections.sort(list, null);
	    	return current;
	    }
	    public E last() {
	    	return list.get(list.size()-1);
	    }
	    public void addNoSort(E e) {
	        list.add(e);
	    }
	    public void sort() {
	        Collections.sort(list, null);
	    }
	}
}
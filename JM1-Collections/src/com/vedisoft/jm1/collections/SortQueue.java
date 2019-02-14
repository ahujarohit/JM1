package com.vedisoft.jm1.collections;

import java.util.*;

public class SortQueue implements Comparator<Integer> {
	public int compare(Integer first, Integer second) {
		return second - first;
	}
}

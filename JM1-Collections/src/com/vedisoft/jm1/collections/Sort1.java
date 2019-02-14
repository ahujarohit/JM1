package com.vedisoft.jm1.collections;

import java.util.*;

class Sort1 {

	public static void main(String args[]) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("222");
		a.add("91");
		a.add("32");
		a.add("123");
		a.add("140");
		System.out.println("Before Sorting : " + a);
		Collections.sort(a);
		System.out.println("After Sorting : " + a);
	}
}

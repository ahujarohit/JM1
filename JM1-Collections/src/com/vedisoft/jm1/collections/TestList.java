package com.vedisoft.jm1.collections;

import java.util.*;

class TestList {
	public static void main(String args[]) {
		List<String> coll = new ArrayList<String>();
		System.out.println("Empty : " + coll.isEmpty());
		coll.add("Red");
		coll.add("Red");
		coll.add("Green");
		coll.add("Blue");
		coll.add("Cyan");
		System.out.println(coll.get(0));
		System.out.println(coll.set(1, "Yellow"));
		System.out.println(coll);
		System.out.println(coll.indexOf("Cyan"));
		System.out.println(coll.lastIndexOf("Red"));
		ListIterator<String> ls = coll.listIterator();
		while (ls.hasNext()) {
			System.out.println(ls.next());
		}

		ls.forEachRemaining(System.out::println);
	}
}

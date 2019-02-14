package com.vedisoft.jm1.collections;

import java.util.*;

class TestSet {
	public static void main(String args[]) {
		Set<String> coll = new HashSet<String>();
		System.out.println("Empty : " + coll.isEmpty());
		coll.add("Red");
		coll.add("Red");
		coll.add("Green");
		coll.add("Blue");
		coll.add("Blue");
		coll.add("Cyan");
		System.out.println("Size  : " + coll.size());
		System.out.println("Contains : " + coll.contains("yellow"));
		System.out.println("Contains : " + coll.contains("Blue"));
		System.out.println(coll);
		coll.remove("Cyan");
		System.out.println(coll);
		Object[] str = coll.toArray();
		for (Object s : str)
			System.out.println((String) s);
		Iterator<String> its = coll.iterator();
		while (its.hasNext()) {
			String s = its.next();
			System.out.println(s);
		}

		coll.forEach(System.out::println);
		coll.clear();
		System.out.println(coll);

	}
}

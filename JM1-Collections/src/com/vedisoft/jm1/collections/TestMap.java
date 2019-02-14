package com.vedisoft.jm1.collections;

import java.util.*;

class TestMap {
	public static void main(String args[]) {
		Map<Integer, String> myMap = new HashMap<Integer, String>();
		myMap.put(2, "Ritesh");
		myMap.put(4, "Saba");
		myMap.put(1, "Manish");
		myMap.put(5, "Akash");
		myMap.put(2, "Rahul");
		myMap.put(3, "Saroj");
		System.out.println(myMap.size());
		System.out.println(myMap.get(2));
		System.out.println(myMap.containsKey(7));
		System.out.println(myMap.containsValue("Saba"));
		Set<Integer> ms = myMap.keySet();
		System.out.println(ms);
		Collection<String> al = myMap.values();
		System.out.println(al);
		for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
			System.out.println(entry);
		}

		myMap.forEach((key, value) -> {
			System.out.println("Key : " + key + " Value : " + value);
		});

	}
}

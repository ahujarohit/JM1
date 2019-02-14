package com.vedisoft.jm1.collections;

import java.util.*;

class TestQueue {
	public static void main(String args[]) {
		Queue<String> coll = new LinkedList<String>();
		System.out.println("Empty : " + coll.isEmpty());
		coll.add("Red");
		coll.add("Green");
		coll.add("Blue");
		coll.add("Cyan");
		System.out.println("Size  : " + coll.size());
		System.out.println(coll);
		System.out.println(coll.poll());
		System.out.println(coll.peek());
		System.out.println(coll.poll());
		System.out.println("Size  : " + coll.size());

	}
}

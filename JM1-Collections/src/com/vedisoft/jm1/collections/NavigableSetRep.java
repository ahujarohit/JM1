package com.vedisoft.jm1.collections;
/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */

import java.util.*;

public class NavigableSetRep {
	public static void main(String[] args) {
		TreeSet<Integer> NavigSet = new TreeSet<Integer>();
		NavigSet.add(10);
		NavigSet.add(20);
		NavigSet.add(50);
		NavigSet.add(30);
		NavigSet.add(100);
		NavigSet.add(80);
		Iterator<Integer> it = NavigSet.iterator();
		System.out.println("Ascending order navigable set : ");
		while (it.hasNext()) {
			System.out.println(it.next() + " ");
		}
		System.out.println();
		System.out.println("Descending order navigable set : " + NavigSet.descendingSet() + "\n");
		System.out
				.println("Least element in Navigable set  greater then or equal to 30 : " + NavigSet.lower(30) + "\n");
		System.out.println(
				"Greatest element in Navigable set  less then or equal to 30 : " + NavigSet.ceiling(31) + "\n");
		System.out.println(
				"Navigable set whose elements are greater then or equal to '80' : " + NavigSet.subSet(20, 80) + "\n");
		System.out.println("Remove element : " + NavigSet.pollFirst());
		System.out.println("Now navigable set : " + NavigSet.descendingSet() + "\n");
		System.out.println("Remove element : " + NavigSet.pollLast());
		System.out.println("Descending order navigable set : " + NavigSet.descendingSet() + "\n");
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
package com.vedisoft.jm1.collections;

import java.util.*;

public class NavigableMapRep {
	public static void main(String[] args) {
		TreeMap<Integer, String> NavMap = new TreeMap<Integer, String>();
		NavMap.put(1, "Sunday");
		NavMap.put(2, "Monday");
		NavMap.put(3, "Tuesday");
		NavMap.put(4, "Wednesday");
		NavMap.put(5, "Thrusday");
		NavMap.put(6, "Friday");
		NavMap.put(7, "Saturday");
		System.out.println("Data in the navigable map : " + NavMap.descendingMap() + "\n");
		System.out.println("First data : " + NavMap.firstEntry() + "\n");
		System.out.println("Last data : " + NavMap.lastEntry() + "\n");
		System.out.println("Nearest less then or equal to the given key : " + NavMap.floorEntry(2) + "\n");
		System.out.println("Retrieving the geatest key strictly less then the given key : " + NavMap.lowerEntry(4));
		System.out.println(
				"Retrieving data from navigable  map greter than the given key : " + NavMap.higherEntry(3) + "\n");
		System.out.println("Removing First : " + NavMap.pollFirstEntry());
		System.out.println("Removing Last : " + NavMap.pollLastEntry() + "\n");
		System.out.println("Now data : " + NavMap.descendingMap());
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
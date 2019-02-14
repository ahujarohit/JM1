package com.vedisoft.jm1.collections;

import java.util.*;

public class SubMapRep {
	public static void main(String[] args) {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		tmap.put(1, "Monday");
		tmap.put(2, "Tuesday");
		tmap.put(4, "Thrusday");
		tmap.put(6, "Saturday");
		SortedMap<Integer, String> Tsubmap;
		Tsubmap = tmap.subMap(3, 7);
		System.out.println(tmap + " " + Tsubmap);
		tmap.put(3, "Wednesday");
		Tsubmap.put(5, "Friday");
		tmap.put(7, "Sunday");
		System.out.println(tmap + " " + Tsubmap);
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
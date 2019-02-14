package com.vedisoft.jm1.collections;

import java.util.*;

public class MySearchColl {
	public static void main(String[] args) {
		ArrayList<String> e = new ArrayList<String>();
		e.add("Suchita");
		e.add("Vikash");
		e.add("Charu");
		e.add("Deepak");
		e.add("Mehtab");
		Collections.sort(e);
		System.out.println("Searching Collection : " + Collections.binarySearch(e, "Suchita"));
		System.out.println("Searching Collection : " + Collections.binarySearch(e, "Rahul"));
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
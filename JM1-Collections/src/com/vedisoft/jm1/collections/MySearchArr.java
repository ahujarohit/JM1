package com.vedisoft.jm1.collections;
/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */

import java.util.*;

public class MySearchArr {
	public static void main(String[] args) {
		String[] names = { "Suchita", "Vikash", "Charu", "Deepak", "Mehtab" };
		Arrays.sort(names);
		System.out.println("Searching Collection : " + Arrays.binarySearch(names, "Suchita"));
		System.out.println("Searching Collection : " + Arrays.binarySearch(names, "Zeba"));
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
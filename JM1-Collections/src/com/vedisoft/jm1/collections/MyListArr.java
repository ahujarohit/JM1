package com.vedisoft.jm1.collections;

import java.util.*;

public class MyListArr {
	public static void main(String[] args) {
		List<String> e = new ArrayList<String>();
		e.add("Suchita");
		e.add("Vikash");
		e.add("Deepak");
		e.add("Charu");
		e.add("Preeti");
		String[] str = new String[2];
		str = e.toArray(str);
		for (String s : str) {
			System.out.println(s);
		}
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
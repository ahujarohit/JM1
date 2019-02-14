package com.vedisoft.jm1.collections;

import java.util.*;

public class TreeSetRep {
	public static void main(String[] args) {
		Set<Integer> treeset = new TreeSet<Integer>();
		boolean[] rv = new boolean[6];
		rv[0] = treeset.add(80);
		rv[1] = treeset.add(20);
		rv[2] = treeset.add(30);
		rv[3] = treeset.add(10);
		rv[4] = treeset.add(10);
		rv[5] = treeset.add(40);
		for (int i = 0; i < rv.length; i++) {
			System.out.println(rv[i] + " ");
		}
		for (Object obj : treeset) {
			System.out.println(obj + " ");
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
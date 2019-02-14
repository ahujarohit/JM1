package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead3 {

	public static void main(String[] args) {
		File searchFile1 = new File("Company");
		System.out.println("The existence of company directory is : " + searchFile1.isDirectory());
		File searchFile2 = new File("D://Data");
		System.out.println("The existence of Kogent directory is : " + searchFile2.isDirectory());
		String files[] = searchFile2.list();
		// create the list
		for (String fnd : files) {
			System.out.println("File : " + fnd);
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
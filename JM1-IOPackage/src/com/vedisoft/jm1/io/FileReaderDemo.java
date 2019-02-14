package com.vedisoft.jm1.io;

import java.io.*;

class FileReaderDemo {

	public static void main(String args[]) {

		try (FileReader fr = new FileReader("Welcome.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String s;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException io) {
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

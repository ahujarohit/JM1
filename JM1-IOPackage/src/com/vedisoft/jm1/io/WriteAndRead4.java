package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead4 {

	public static void main(String[] args) {

		String str = "This is a book on SCJP 7." + "\nI am preparing for java certification.";
		try (FileWriter fw = new FileWriter("filereadwrite.txt")) {
			for (int i = 0; i < str.length(); i++) {
				fw.write(str.charAt(i));
			}
			fw.flush();
		} catch (IOException e) {
			System.out.println("IOException : " + e.toString());
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
package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead5 {

	public static void main(String[] args) {
		int ch;
		try (FileReader fr = new FileReader("filereadwrite.txt")) {
			while ((ch = fr.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (FileNotFoundException fe) {
			System.out.println("File not found : " + fe.toString());
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
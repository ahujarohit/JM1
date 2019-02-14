package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead6 {

	public static void main(String[] args) {
		char[] in = new char[50];
		int size = 0;
		File file = new File("MyFile2.txt");
		try (FileWriter fw = new FileWriter(file)) {
			fw.write("Line 1:123456789\nLine 2:abcdefghijk\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
		}
		try (FileReader fr = new FileReader(file)) {
			size = fr.read(in);
			System.out.print(size + " ");
			for (int i = 0; i < size; i++) {
				System.out.print(in[i]);
			}
		} catch (IOException e) {
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
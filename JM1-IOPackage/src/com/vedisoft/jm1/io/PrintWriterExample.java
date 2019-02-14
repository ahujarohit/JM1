package com.vedisoft.jm1.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class PrintWriterExample {

	final static String FILE_NAME = "File.txt";

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("Vedisoft: Java Module 1 - Desktop Technologies");
		int i = 5;
		double k = 10.0;
		pw.printf("i = %d and k = %f", i, k);
		pw.flush();

		System.out.println("\n---------------------------------------");

		PrintWriter pwFile = null;
		Date date = new Date();
		try {
			pwFile = new PrintWriter(FILE_NAME);
			i++;
			pwFile.println(date);
			pwFile.write("Write something in a line. i = " + i);
			System.out.println("Write to the file successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			if (pwFile != null) {
				pwFile.close();
			}
		}

		PrintWriter pwFile1 = null;
		Object obj = System.getProperty("line.separator") + "A new object";
		try {
			FileWriter fl = new FileWriter(FILE_NAME, true);
			BufferedWriter br = new BufferedWriter(fl);
			pwFile1 = new PrintWriter(br);

			pwFile1.println(obj);
			pwFile1.write("!!!Vedisoft Test!!!", 3, 8);
			System.out.println("Add new lines to the file successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pwFile1 != null) {
				pwFile1.close();
			}
		}
	}

}
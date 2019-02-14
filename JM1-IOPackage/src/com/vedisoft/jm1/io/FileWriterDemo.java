package com.vedisoft.jm1.io;

import java.io.*;

class FileWriterDemo {

	public static void main(String args[]) {
		String source = "Now is the time for all good men\r\n" + " to come to the aid of their country\r\n"
				+ " and pay their due taxes.";

		char buffer[] = new char[source.length()];
		source.getChars(0, source.length(), buffer, 0);

		try (FileWriter f0 = new FileWriter("file1.txt")) {
			for (int i = 0; i < buffer.length; i++) {
				f0.write(buffer[i]); // char by char
			}
			f0.flush();
		} catch (IOException io) {
		}

		try (FileWriter f1 = new FileWriter("file2.txt")) {
			f1.write(buffer); // entire array
			f1.flush();
		} catch (IOException io) {
		}

		try (FileWriter f2 = new FileWriter("file3.txt")) {
			f2.write(buffer, buffer.length / 4, buffer.length / 4);
			// array, stindex, num
			f2.flush();
		} catch (IOException io) {
		}

	}
}

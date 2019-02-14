package com.vedisoft.jm1.io;

import java.io.*;

public class WriteTextFileExample {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			String text = "This is a text file";
			File file = new File("write.txt");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(text);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

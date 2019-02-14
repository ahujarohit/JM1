package com.vedisoft.jm1.io;

import java.io.*;

public class MyConsole1 {

	public static void main(String[] args) {
		try {
			Console cns = System.console();
			BufferedReader br = new BufferedReader(cns.reader());
			cns.format("\nEnter Your Name : ");
			String str = br.readLine();
			PrintWriter out = cns.writer();
			out.println("Name is : " + str);
		} catch (Exception e) {
		}
	}
}

package com.vedisoft.jm1.io;

import java.io.*;

public class MyConsole {

	public static void main(String[] args) {
		Console cns = System.console();
		cns.format("\nUsing readLine() method");
		String name;
		name = cns.readLine("Enter your name : ");
		cns.format("Your name is : %s\n", name);
		char pw[];
		cns.format("Using readPassword() method");
		pw = cns.readPassword("Enter your Password %s: ", name);
		cns.format("\n%s your password is : ", name);
		for (char c : pw) {
			cns.format("%c", c);
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
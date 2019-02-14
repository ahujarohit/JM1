package com.vedisoft.jm1.io;

import java.io.*;

class TestInput {

	public static void main(String args[]) {

		String str = new String();
		int num1 = 0, num2 = 0;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Enter String : ");
			str = br.readLine();
			System.out.println("Enter Enter Number 1 : ");
			num1 = Integer.parseInt(br.readLine());
			System.out.println("Enter Enter Number 2 : ");
			num2 = Integer.parseInt(br.readLine());
			System.out.println("String : " + str);
			System.out.println("Sum : " + (num1 + num2));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}

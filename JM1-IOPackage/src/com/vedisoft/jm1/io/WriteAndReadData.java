package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndReadData {

	public static void main(String[] args) {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream("DataIO.txt"))) {

			float price1 = 3.14f;
			int unit1 = 10;
			out.writeFloat(price1);
			out.writeChar('\t');
			out.writeInt(unit1);
			out.writeChar('\t');
			out.flush();
		} catch (IOException io) {
		}

		try (DataInputStream in = new DataInputStream(new FileInputStream("DataIO.txt"))) {
			float price2;
			int unit2;
			float total;

			while (true) {
				price2 = in.readFloat();
				in.readChar();
				System.out.println("Price : " + price2);
				unit2 = in.readInt();
				in.readChar();
				System.out.println("Unit : " + unit2);
				total = unit2 * price2;
				System.out.println("Total : " + total);
			}
		} catch (EOFException eof) {
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

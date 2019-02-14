package com.vedisoft.jm1.networking;

import java.net.*;
import java.util.Scanner;

public class DatagramServer {

	public static void main(String args[]) {
		DatagramSocket ds;
		int clientport = 1111, serverport = 2222;
		byte buffer[] = new byte[100];
		try {
			ds = new DatagramSocket(serverport);
			Scanner in = new Scanner(System.in);
			System.out.println(" Server Waiting For Input ");
			InetAddress ia = InetAddress.getLocalHost();
			while (true) {
				String str = in.nextLine();
				if ((str == null || str.equals("end"))) {
					break;
				}
				buffer = str.getBytes();
				DatagramPacket dp = new DatagramPacket(buffer, str.length(), ia, clientport);
				ds.send(dp);
			}
		} catch (Exception io) {
			System.out.println("Error in program");
		}
	}
}
/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */

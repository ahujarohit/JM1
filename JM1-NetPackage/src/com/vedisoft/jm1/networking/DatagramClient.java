package com.vedisoft.jm1.networking;

import java.net.*;

class DatagramClient {

	public static void main(String args[]) throws Exception {
		DatagramSocket ds;
		byte buffer[] = new byte[100];
		int clientport = 1111;
		ds = new DatagramSocket(clientport);
		System.out.println("Client Is Waiting For Server To Get Data ");
		while (true) {
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			ds.receive(p);
			String psx = new String(p.getData(), 0, p.getLength());
			System.out.println(psx);
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
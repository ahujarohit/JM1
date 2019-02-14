package com.vedisoft.jm1.networking;

import java.net.*;
import java.util.*;

class CheckIp {

	public static void main(String args[]) {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println(ia);
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			Scanner in = new Scanner(System.in);
			System.out.println("Enter DNS : ");
			String str = in.nextLine();
			InetAddress ia1 = InetAddress.getByName(str);
			System.out.println(ia1);
			System.out.println(ia1.getHostName());
			System.out.println(ia1.getHostAddress());
			InetAddress ia2[] = InetAddress.getAllByName("www.yahoo.com");
			for (int i = 0; i < ia2.length; i++)
				System.out.println(ia2[i]);
		} catch (UnknownHostException un) {
			un.printStackTrace();
		}
	}
}
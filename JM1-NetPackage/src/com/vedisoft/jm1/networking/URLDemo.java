package com.vedisoft.jm1.networking;

import java.net.*;

class URLDemo {
	public static void main(String args[]) throws MalformedURLException {
		URL vs = new URL("http://www.vedisoft.com/index.html");
		System.out.println("Protocol: " + vs.getProtocol());
		System.out.println("Port: " + vs.getPort());
		System.out.println("Host: " + vs.getHost());
		System.out.println("File: " + vs.getFile());
		System.out.println("Ext:" + vs.toExternalForm());
	}
}
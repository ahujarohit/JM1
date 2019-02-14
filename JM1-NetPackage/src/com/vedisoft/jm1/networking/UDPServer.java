package com.vedisoft.jm1.networking;

/**
 * @author Rohit Ahuja
 * rohitahuja@email.com
 * 9893075987
 */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UDPServer extends javax.swing.JPanel implements Runnable {

	private DatagramPacket sendPacket, receivePacket;
	private DatagramSocket socket;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;

	public UDPServer() {
		createUI();
		try {
			socket = new DatagramSocket(5000);
		} catch (SocketException se) {
			socket.close();
			se.printStackTrace();
			System.exit(1);
		}

	}

	public void run() {
		while (true) {
			try {
				byte data[] = new byte[100];
				receivePacket = new DatagramPacket(data, data.length);
				socket.receive(receivePacket);
				jTextArea1.append("\nPacket received:" + "\nFrom host: " + receivePacket.getAddress() + "\nHost port: "
						+ receivePacket.getPort() + "\nLength: " + receivePacket.getLength() + "\nContaining:\n\t"
						+ new String(receivePacket.getData(), 0, receivePacket.getLength()));
				jTextArea1.append("\n\nEcho data to client...");
				sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),
						receivePacket.getAddress(), receivePacket.getPort());
				socket.send(sendPacket);
				jTextArea1.append("Packet sent\n");
				jTextArea1.setCaretPosition(jTextArea1.getText().length());
			} catch (IOException io) {
				System.out.println("Here");
				jTextArea1.append(io.toString() + "\n");
				io.printStackTrace();
			}
		}
	}

	private void createUI() {
		setLayout(new BorderLayout());
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		add(jScrollPane1, java.awt.BorderLayout.CENTER);

	}

	public static void main(String args[]) {
		UDPServer u = new UDPServer();
		JFrame f = new JFrame("Vedisoft:Java Desktop Technologies: UDP Server");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(u);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		Thread t = new Thread(u);
		t.start();

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
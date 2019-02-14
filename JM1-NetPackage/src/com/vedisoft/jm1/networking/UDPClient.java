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

public class UDPClient extends javax.swing.JPanel implements Runnable {
	private DatagramPacket sendPacket, receivePacket;
	private DatagramSocket socket;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JTextField jTextField1;

	public UDPClient() {
		createUI();
		try {
			socket = new DatagramSocket();
		} catch (SocketException se) {
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
				jTextArea1.setCaretPosition(jTextArea1.getText().length());
			} catch (IOException exception) {
				jTextArea1.append(exception.toString() + "\n");
				exception.printStackTrace();
			}
		}
	}

	private void createUI() {

		setLayout(new BorderLayout());
		jTextField1 = new JTextField();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();

		jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendData(evt);
			}
		});
		add(jTextField1, java.awt.BorderLayout.NORTH);
		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);
		add(jScrollPane1, java.awt.BorderLayout.CENTER);
	}

	private void sendData(java.awt.event.ActionEvent evt) {
		try {
			jTextArea1.append("\nSending packet containing: " + jTextField1.getText() + "\n");
			String s = jTextField1.getText();
			byte data[] = s.getBytes();
			sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 5000);
			socket.send(sendPacket);

			jTextArea1.append("Packet sent\n");
			jTextArea1.setCaretPosition(jTextArea1.getText().length());
		} catch (IOException exception) {
			jTextArea1.append(exception.toString() + "\n");
			exception.printStackTrace();
		}

	}

	public static void main(String args[]) {
		UDPClient u = new UDPClient();
		JFrame f = new JFrame("Vedisoft:Java Desktop Technologies:  UDP Client");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(u);
		f.pack();
		f.setResizable(false);
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
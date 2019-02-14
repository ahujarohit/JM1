package com.vedisoft.jm1.networking;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TCPClient extends JPanel implements Runnable {

	ObjectOutputStream output;
	ObjectInputStream input;
	JButton jButton1;
	JPanel jPanel1;
	JScrollPane jScrollPane1;
	JTextArea jTextArea1;
	JTextField jTextField1;

	public TCPClient() {
		createUI();
	}

	public void run() {
		Socket client;
		try {
			String message = new String();
			jTextArea1.setText("Attempting connection\n");
			client = new Socket(InetAddress.getByName("127.0.0.1"), 5110);
			jTextArea1.append("Connected to: " + client.getInetAddress().getHostName());
			output = new ObjectOutputStream(client.getOutputStream());
			output.flush();
			input = new ObjectInputStream(client.getInputStream());
			jTextArea1.append("\nGot I/O streams\n");
			jTextField1.setEnabled(true);
			do {
				try {
					message = (String) input.readObject();
					jTextArea1.append("\n" + message);
					jTextArea1.setCaretPosition(jTextArea1.getText().length());
				} catch (ClassNotFoundException cnfex) {
					jTextArea1.append("\nUnknown object type received");
				}
			} while (!message.equals("SERVER>>> TERMINATE"));
			jTextArea1.append("Closing connection.\n");
			output.close();
			input.close();
			client.close();
		} catch (EOFException eof) {
			System.out.println("Server terminated connection");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createUI() {
		setLayout(new BorderLayout());
		jPanel1 = new JPanel();
		jButton1 = new JButton();
		jTextField1 = new JTextField();
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();

		jPanel1.setLayout(new BorderLayout());

		jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jButton1.setText("Send");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendData(evt);
			}
		});
		jPanel1.add(jButton1, java.awt.BorderLayout.EAST);

		jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendData(evt);
			}
		});
		jPanel1.add(jTextField1, java.awt.BorderLayout.CENTER);

		add(jPanel1, java.awt.BorderLayout.NORTH);

		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 24));
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		add(jScrollPane1, java.awt.BorderLayout.CENTER);
	}

	private void sendData(java.awt.event.ActionEvent evt) {
		try {
			output.writeObject("CLIENT>>> " + jTextField1.getText());
			output.flush();
			jTextArea1.append("\nCLIENT>>>" + jTextField1.getText());
			jTextField1.setText("");
		} catch (IOException cnfex) {
			jTextArea1.append("\nError writing object");
		}
	}

	public static void main(String args[]) {
		TCPClient tc = new TCPClient();
		Thread t = new Thread(tc);
		t.start();
		JFrame f = new JFrame("Vedisoft:Java Desktop Technologies: TCP Client");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(tc);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);

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
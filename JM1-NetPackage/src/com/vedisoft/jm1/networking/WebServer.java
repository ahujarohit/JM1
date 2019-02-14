package com.vedisoft.jm1.networking;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WebServer extends JPanel implements Runnable {

	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;

	public WebServer() {
		createUI();
	}

	public void run() {
		jTextArea1.append("Server Ready For Processing Request.\n");
		while (true) {
			ServerSocket serverSocket = null;
			Socket clientSocket = null;
			try {
				serverSocket = new ServerSocket(80);
				clientSocket = serverSocket.accept();
				InetAddress ia = clientSocket.getInetAddress();
				jTextArea1.append("Connected to : " + ia + "\n");
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				//String s = (String) JOptionPane.showInputDialog(this, "Enter File Name : ");
				String s = "SomeFile.html";
				File f = new File(s);
				if (f.exists()) {
					out.println("http/1.1 200 ok\r");
					out.println("Mime version 1.1");
					out.println("Content-Type: text/html\r");
					out.println("Content-Length: " + f.length() + "\r");
					out.println("\r");
					BufferedReader d = new BufferedReader(new FileReader(s));
					String line = " ", a;
					while ((a = d.readLine()) != null) {
						line = line + a;
					}
					out.write(line);
					out.flush();
					jTextArea1.append("File Delivered.\n");
					d.close();
				}
				out.close();
				clientSocket.close();
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("Accept failed." + e);
				System.exit(1);
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
		WebServer ws = new WebServer();
		JFrame f = new JFrame("Vedisoft:Java Desktop Technologies:  WebServer");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(ws);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		Thread t = new Thread(ws);
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

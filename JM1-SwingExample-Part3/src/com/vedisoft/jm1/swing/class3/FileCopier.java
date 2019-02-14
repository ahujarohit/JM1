package com.vedisoft.jm1.swing.class3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FileCopier extends JPanel implements ActionListener {

	JTextField txtSource, txtDestination;
	JButton btnSource, btnDestination, btnCopy;

	public FileCopier() {
		setLayout(new FlowLayout());
		txtSource = new JTextField(50);
		txtSource.setEditable(false);
		btnSource = new JButton("Browse");
		btnSource.setActionCommand("Source");
		btnSource.addActionListener(this);
		txtDestination = new JTextField(50);
		txtDestination.setEditable(false);
		btnDestination = new JButton("Browse");
		btnDestination.setActionCommand("Destination");
		btnDestination.addActionListener(this);
		btnCopy = new JButton("Copy");
		btnCopy.addActionListener(this);
		add(new JLabel("Source File "));
		add(txtSource);
		add(btnSource);
		add(new JLabel("Destination File "));
		add(txtDestination);
		add(btnDestination);
		add(btnCopy);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Source")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("."));
			int result = jFileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				txtSource.setText(selectedFile.getAbsolutePath());
			}
		} else if (str.equals("Destination")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("."));
			int result = jFileChooser.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jFileChooser.getSelectedFile();
				txtDestination.setText(selectedFile.getAbsolutePath());
			}
		} else if (str.equals("Copy")) {
			String source = txtSource.getText();
			String destination = txtDestination.getText();
			if (copyFile(source, destination)) {
				JOptionPane.showMessageDialog(this, "File Successfully Copied.");
			}
		}
	}

	public boolean copyFile(String source, String destination) {
		File sourceFile = new File(source);
		File destFile = new File(destination);
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Unable to Copy");
				return false;
			}
		}

		InputStream input = null;
		OutputStream output = null;

		try {

			input = new FileInputStream(sourceFile);
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Source File Not Found.");
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Unable to Copy.");
			return false;
		}

		finally {
			try {
				if (null != input) {
					input.close();
				}
				if (null != output) {
					output.close();
				}

			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Unable to Close.");
				return false;
			}
		}
		return true;
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("File Copier");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new FileCopier());
		f.setMinimumSize(new Dimension(800, 150));
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}

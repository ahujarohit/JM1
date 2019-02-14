package com.vedisoft.jm1.swing.class3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class AlphabetCounter extends JPanel implements ActionListener {

	JTextField txtSource;
	JButton btnSource, btnCount;
	JTextArea txtDestination;

	public AlphabetCounter() {
		setLayout(new BorderLayout());
		JPanel panel1 = new JPanel(new FlowLayout());
		txtSource = new JTextField(50);
		txtSource.setEditable(false);
		btnSource = new JButton("Browse");
		btnSource.setActionCommand("Source");
		btnSource.addActionListener(this);
		btnCount = new JButton("Count");
		btnCount.addActionListener(this);
		txtDestination = new JTextArea();
		txtDestination.setEditable(false);
		panel1.add(new JLabel("Source File "));
		panel1.add(txtSource);
		panel1.add(btnSource);
		panel1.add(btnCount);
		add(panel1, BorderLayout.NORTH);
		add(new JScrollPane(txtDestination), BorderLayout.CENTER);
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
		} else if (str.equals("Count")) {
			String source = txtSource.getText();
			countAlpbabets(source);
		}
	}

	public void countAlpbabets(String source) {
		File sourceFile = new File(source);
		FileReader fr = null;
		String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int counts[] = new int[alphabets.length()];

		try {
			fr = new FileReader(sourceFile);
			int byteRead;
			while ((byteRead = fr.read()) > 0) {
				char c = (char) byteRead;
				char c1 = Character.toUpperCase(c);
				for (int i = 0; i < alphabets.length(); i++) {
					if (alphabets.charAt(i) == c1)
						counts[i]++;
				}
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "Source File Not Found.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Unable to Count.");
		}

		finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Unable to Close.");
			}
		}
		txtDestination.setText("");
		for (int i = 0; i < counts.length; i++) {
			txtDestination.append(alphabets.charAt(i) + " : " + counts[i] + "\n");
		}
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("Alphabet Counter");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new AlphabetCounter());
		f.setMinimumSize(new Dimension(800, 450));
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}

}

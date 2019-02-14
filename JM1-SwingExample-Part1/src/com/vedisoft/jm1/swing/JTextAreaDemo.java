package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTextAreaDemo extends JPanel implements ActionListener {

	JTextField jtfInput;
	JTextArea jtAreaOutput;
	String newline = "\n";

	public JTextAreaDemo() {
		jtfInput = new JTextField(20);
		jtfInput.addActionListener(this);
		jtAreaOutput = new JTextArea(5, 20);
		jtAreaOutput.setCaretPosition(jtAreaOutput.getDocument().getLength());
		jtAreaOutput.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(jtAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(jtfInput, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent evt) {
		String text = jtfInput.getText();
		jtAreaOutput.append(text + newline);
		jtfInput.selectAll();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JTextArea Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JTextAreaDemo());
		frame.pack();
		frame.setVisible(true);
	}
}
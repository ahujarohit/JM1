package com.vedisoft.jm1.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTAbsolutePositionExample extends Frame implements ActionListener {

	Label label1, label2, label3;
	Button button1, button2;
	TextField textField1, textField2, textField3;

	public AWTAbsolutePositionExample() {
		setLayout(null);
		label1 = new Label("Number 1 ");
		label2 = new Label("Number 2 ");
		label3 = new Label("Result ");
		textField1 = new TextField();
		textField2 = new TextField();
		textField3 = new TextField();
		button1 = new Button("Sum");
		button2 = new Button("Subtract");

		label1.setBounds(50, 50, 100, 25);
		textField1.setBounds(200, 50, 100, 25);
		label2.setBounds(50, 100, 100, 25);
		textField2.setBounds(200, 100, 100, 25);
		button1.setBounds(50, 150, 100, 25);
		button2.setBounds(200, 150, 100, 25);
		label3.setBounds(50, 200, 100, 25);
		textField3.setBounds(200, 200, 100, 25);

		button1.addActionListener(this);
		button2.addActionListener(this);

		add(label1);
		add(textField1);
		add(label2);
		add(textField2);
		add(button1);
		add(button2);
		add(label3);
		add(textField3);

		setTitle("AWT Abosolute Position Example");
		setSize(350, 250);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int num1 = Integer.parseInt(textField1.getText().trim());
		int num2 = Integer.parseInt(textField2.getText().trim());
		int result = 0;
		String str = arg0.getActionCommand();
		if (str.equals("Sum"))
			result = num1 + num2;
		else
			result = num1 - num2;
		textField3.setText(result + "");
	}

	public static void main(String args[]) {
		new AWTAbsolutePositionExample();
	}
}

package com.vedisoft.jm1.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class JButtonGraphics extends JPanel {

	JButton button1, button2;

	public JButtonGraphics() {
		setLayout(new FlowLayout());

		//setBackground(Color.white);
		button1 = new JButton();
		Icon defaultIcon = new ImageIcon(getClass().getResource("/images/p1.jpg"));
		Icon pressedIcon = new ImageIcon(getClass().getResource("/images/p3.jpg"));
		Icon rollOverIcon = new ImageIcon(getClass().getResource("/images/p2.jpg"));
		button1.setRolloverEnabled(true);
		button1.setIcon(defaultIcon);
		button1.setPressedIcon(pressedIcon);
		button1.setRolloverIcon(rollOverIcon);
		button1.setToolTipText("This is JButton with Icon");
		add(button1);

		button2 = new JButton();
		button2.setRolloverEnabled(true);
		button2.setIcon(defaultIcon);
		button2.setPressedIcon(pressedIcon);
		button2.setRolloverIcon(rollOverIcon);
		button2.setBorderPainted(false);
		button2.setFocusPainted(false);
		button2.setContentAreaFilled(false);

		button2.setToolTipText("This is JButton with Icon");
		add(button2);
	}

	public static void main(String args[]) {
		JFrame f = new JFrame("JButon Graphics Demo Example ");
		f.setContentPane(new JButtonGraphics());
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

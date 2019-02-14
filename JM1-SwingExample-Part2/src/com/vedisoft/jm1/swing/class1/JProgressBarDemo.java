package com.vedisoft.jm1.swing.class1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JProgressBarDemo extends JPanel {

	JProgressBar jp;
	Timer t;
	int i = 0;

	public JProgressBarDemo() {
		setLayout(new GridLayout());
		setVisible(true);
		jp = new JProgressBar();
		jp.setStringPainted(true);
		jp.setPreferredSize(new Dimension(500, 30));
		jp.setMinimum(0);
		jp.setMaximum(1000);
		t = new Timer(2, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (i == 1000)
					i = 0;
				jp.setValue(i++);
			}
		});
		t.start();
		add(jp);
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("JProgressBar Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JProgressBarDemo());
		frame.pack();
		frame.setVisible(true);
	}
}

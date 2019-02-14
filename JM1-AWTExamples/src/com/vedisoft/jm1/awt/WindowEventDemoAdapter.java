package com.vedisoft.jm1.awt;

import java.awt.*;
import java.awt.event.*;

public class WindowEventDemoAdapter extends Frame {
	private TextField tfCount;
	private Button btnCount;
	private int count = 0;

	public WindowEventDemoAdapter() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false);
		add(tfCount);

		btnCount = new Button("Count");
		add(btnCount);
		btnCount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				++count;
				tfCount.setText(count + "");
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});

		setTitle("WindowEvent Demo");
		setSize(250, 100);
		setVisible(true);
	}

	/** The entry main method */
	public static void main(String[] args) {
		new WindowEventDemoAdapter(); // Let the constructor do the job
	}
}

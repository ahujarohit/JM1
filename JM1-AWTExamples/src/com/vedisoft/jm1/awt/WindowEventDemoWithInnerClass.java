package com.vedisoft.jm1.awt;

import java.awt.*;
import java.awt.event.*;

public class WindowEventDemoWithInnerClass extends Frame {
	private TextField tfCount;
	private Button btnCount;
	private int count = 0;

	public WindowEventDemoWithInnerClass() {
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

		addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent evt) {
			}

			@Override
			public void windowClosed(WindowEvent evt) {
			}

			@Override
			public void windowIconified(WindowEvent evt) {
			}

			@Override
			public void windowDeiconified(WindowEvent evt) {
			}

			@Override
			public void windowActivated(WindowEvent evt) {
			}

			@Override
			public void windowDeactivated(WindowEvent evt) {
			}
		});

		setTitle("WindowEvent Demo");
		setSize(250, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowEventDemoWithInnerClass();
	}
}

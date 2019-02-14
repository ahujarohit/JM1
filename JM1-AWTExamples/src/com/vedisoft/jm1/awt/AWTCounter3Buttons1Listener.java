package com.vedisoft.jm1.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTCounter3Buttons1Listener extends Frame {
	private TextField tfCount;
	private Button btnCountUp, btnCountDown, btnReset;
	private int count = 0;

	public AWTCounter3Buttons1Listener() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false);
		add(tfCount);

		btnCountUp = new Button("Count Up");
		add(btnCountUp);
		btnCountDown = new Button("Count Down");
		add(btnCountDown);
		btnReset = new Button("Reset");
		add(btnReset);

		BtnListener listener = new BtnListener();
		btnCountUp.addActionListener(listener);
		btnCountDown.addActionListener(listener);
		btnReset.addActionListener(listener);

		setTitle("AWT Counter");
		setSize(400, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AWTCounter3Buttons1Listener();
	}

	private class BtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String btnLabel = evt.getActionCommand();
			if (btnLabel.equals("Count Up")) {
				++count;
			} else if (btnLabel.equals("Count Down")) {
				--count;
			} else {
				count = 0;
			}
			tfCount.setText(count + "");
		}
	}
}

package com.vedisoft.jm1.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTPanelDemo extends Frame {
	private Button[] btnNumbers;
	private Button btnHash, btnStar;
	private TextField tfDisplay;

	public AWTPanelDemo() {
		Panel panelDisplay = new Panel(new FlowLayout());
		tfDisplay = new TextField("0", 20);
		panelDisplay.add(tfDisplay);

		Panel panelButtons = new Panel(new GridLayout(4, 3));
		btnNumbers = new Button[10];
		btnNumbers[1] = new Button("1");
		panelButtons.add(btnNumbers[1]);
		btnNumbers[2] = new Button("2");
		panelButtons.add(btnNumbers[2]);
		btnNumbers[3] = new Button("3");
		panelButtons.add(btnNumbers[3]);
		btnNumbers[4] = new Button("4");
		panelButtons.add(btnNumbers[4]);
		btnNumbers[5] = new Button("5");
		panelButtons.add(btnNumbers[5]);
		btnNumbers[6] = new Button("6");
		panelButtons.add(btnNumbers[6]);
		btnNumbers[7] = new Button("7");
		panelButtons.add(btnNumbers[7]);
		btnNumbers[8] = new Button("8");
		panelButtons.add(btnNumbers[8]);
		btnNumbers[9] = new Button("9");
		panelButtons.add(btnNumbers[9]);
		btnStar = new Button("*");
		panelButtons.add(btnStar);
		btnNumbers[0] = new Button("0");
		panelButtons.add(btnNumbers[0]);
		btnHash = new Button("#");
		panelButtons.add(btnHash);

		setLayout(new BorderLayout());
		add(panelDisplay, BorderLayout.NORTH);
		add(panelButtons, BorderLayout.CENTER);

		setTitle("BorderLayout Demo");
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AWTPanelDemo();
	}
}
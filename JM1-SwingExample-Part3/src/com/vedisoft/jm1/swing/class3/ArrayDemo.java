package com.vedisoft.jm1.swing.class3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrayDemo extends JPanel implements ActionListener {

	JPanel northPanel, centerPanel;
	JFormattedTextField textFieldRows, textFieldColumns;
	JButton goButton;
	JFormattedTextField textFields[][];
	int rows, columns;

	public ArrayDemo() {
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		centerPanel = new JPanel(new FlowLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);

		northPanel.add(new JLabel("Rows"));
		textFieldRows = new JFormattedTextField(java.text.NumberFormat.getInstance());
		textFieldRows.setColumns(5);
		textFieldRows.setValue(new Integer(4));
		northPanel.add(textFieldRows);
		northPanel.add(new JLabel("Columns"));
		textFieldColumns = new JFormattedTextField(java.text.NumberFormat.getInstance());
		textFieldColumns.setColumns(5);
		textFieldColumns.setValue(new Integer(4));
		northPanel.add(textFieldColumns);
		goButton = new JButton("Go");
		goButton.setMnemonic('G');
		goButton.addActionListener(this);
		northPanel.add(goButton);
	}

	public void actionPerformed(ActionEvent ae) {
		goButton.setEnabled(false);
		rows = Integer.parseInt(textFieldRows.getValue().toString()) + 1;
		columns = Integer.parseInt(textFieldColumns.getValue().toString()) + 1;
		textFields = new JFormattedTextField[rows][columns];
		centerPanel.setLayout(new GridLayout(rows, columns, 5, 5));
		int i, j;
		TextFieldEventListener tlistener = new TextFieldEventListener();
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				textFields[i][j] = new JFormattedTextField(java.text.NumberFormat.getInstance());
				textFields[i][j].setValue(new Integer(0));
				textFields[i][j].addActionListener(tlistener);
				centerPanel.add(textFields[i][j]);
			}
			textFields[i][j - 1].setEditable(false);
		}
		for (j = 0; j < columns; j++) {
			textFields[i - 1][j].setEditable(false);
		}
		centerPanel.invalidate();
		centerPanel.updateUI();
	}

	class TextFieldEventListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			int num[][] = new int[rows - 1][columns - 1];
			int rsum[] = new int[rows - 1];
			int csum[] = new int[columns - 1];
			int sum = 0;
			int i, j;
			for (i = 0; i < num.length; i++) {
				for (j = 0; j < num[i].length; j++) {
					num[i][j] = Integer.parseInt(textFields[i][j].getValue().toString());
					sum += num[i][j];
					rsum[i] += num[i][j];
					csum[j] += num[i][j];
				}
			}
			for (i = 0; i < num.length; i++) {
				textFields[i][num[i].length].setValue(rsum[i]);
			}

			for (i = 0; i < num[0].length; i++) {
				textFields[num.length][i].setValue(csum[i]);
			}

			textFields[rows - 1][columns - 1].setValue(sum);
		}
	}

	public static void main(String args[]) {
		JFrame f = new JFrame("Array Demo Example ");
		f.setContentPane(new ArrayDemo());
		f.setBounds(10, 10, 400, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

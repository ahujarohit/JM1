package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JListDemo extends JPanel {

	JLabel headerLabel;
	JLabel statusLabel;
	JPanel controlPanel;
	DefaultListModel<String> fruitsName;
	JList<String> fruitList;
	DefaultListModel<String> vegName;
	JList<String> vegList;
	JButton showButton;

	public JListDemo() {

		setLayout(new BorderLayout(0, 10));
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		add(headerLabel,BorderLayout.NORTH);
		add(controlPanel,BorderLayout.CENTER);
		add(statusLabel,BorderLayout.SOUTH);

		headerLabel.setText("Control in action: JList");

		fruitsName = new DefaultListModel<String>();

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Peer");

		fruitList = new JList<String>(fruitsName);
		fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fruitList.setSelectedIndex(0);
		fruitList.setVisibleRowCount(3);

		JScrollPane fruitListScrollPane = new JScrollPane(fruitList);

		vegName = new DefaultListModel<String>();

		vegName.addElement("Lady Finger");
		vegName.addElement("Onion");
		vegName.addElement("Potato");
		vegName.addElement("Tomato");

		vegList = new JList<String>(vegName);
		vegList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		vegList.setSelectedIndex(0);
		vegList.setVisibleRowCount(3);

		JScrollPane vegListScrollPane = new JScrollPane(vegList);

		showButton = new JButton("Show");

		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (fruitList.getSelectedIndex() != -1) {
					data = "Fruits Selected: " + fruitList.getSelectedValue();
					statusLabel.setText(data);
				}
				if (vegList.getSelectedIndex() != -1) {
					data += " Vegetables selected: ";
					for (Object vegetable : vegList.getSelectedValues()) {
						data += vegetable + " ";
					}
				}
				statusLabel.setText(data);
			}
		});

		controlPanel.add(fruitListScrollPane);
		controlPanel.add(vegListScrollPane);
		controlPanel.add(showButton);

	}

	public static void main(String args[]) {
		JFrame f = new JFrame("JListDemo Example");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JListDemo());
		f.setBounds(10,10,600,180);
		f.setVisible(true);
	}
}

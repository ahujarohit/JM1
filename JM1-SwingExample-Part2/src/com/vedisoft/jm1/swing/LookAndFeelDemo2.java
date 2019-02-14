package com.vedisoft.jm1.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class LookAndFeelDemo2 extends JPanel implements ActionListener {

	JPanel northPanel, centerPanel;
	JComboBox<String> lookAndFeelList;
	UIManager.LookAndFeelInfo laf[];

	public LookAndFeelDemo2() {
		setLayout(new BorderLayout());
		northPanel = new JPanel(new FlowLayout());
		centerPanel = new JPanel(new FlowLayout());
		Vector<String> strList = new Vector<String>();
		laf = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < laf.length; i++) {
			strList.add(laf[i].getName());
		}

		lookAndFeelList = new JComboBox<String>(strList);
		lookAndFeelList.addActionListener(this);
		northPanel.add(lookAndFeelList);

		centerPanel.add(new JLabel("This is a Test JLabel"));
		centerPanel.add(new JButton("This is a Test JButton"));
		centerPanel.add(new JCheckBox("This is a Test JCheckBox"));
		centerPanel.add(new JScrollPane(new JList<String>(strList), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		int index = lookAndFeelList.getSelectedIndex();
		try {
			UIManager.setLookAndFeel(laf[index].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("LookAndFeel Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new LookAndFeelDemo2());
		frame.setBounds(100, 100, 400, 300);
		frame.setVisible(true);
	}
}

package com.vedisoft.jm1.swing;

import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSpinnerDemo extends JPanel implements ChangeListener {

	JSpinner spinner1, spinner2, spinner3;
	JLabel label1;

	public JSpinnerDemo() {
		setLayout(new FlowLayout());
		SpinnerNumberModel sp1 = new SpinnerNumberModel(0, 0, 100, 10);
		spinner1 = new JSpinner(sp1);
		SpinnerDateModel sp2 = new SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_MONTH);
		spinner2 = new JSpinner(sp2);
		String colors[] = { "Red", "Green", "Blue", "Cyan" };
		SpinnerListModel sp3 = new SpinnerListModel(colors);
		spinner3 = new JSpinner(sp3);
		label1 = new JLabel("Value  : ");
		spinner1.addChangeListener(this);
		spinner2.addChangeListener(this);
		spinner3.addChangeListener(this);
		add(spinner1);
		add(spinner2);
		add(spinner3);
		add(label1);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		JSpinner sp = (JSpinner) arg0.getSource();
		label1.setText("Value : " + sp.getValue());
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("JSpinner Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JSpinnerDemo());
		frame.setBounds(10,10,500,80);
		frame.setVisible(true);
	}
}

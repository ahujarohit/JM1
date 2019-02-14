package com.vedisoft.jm1.swing;

import java.awt.BorderLayout;
import javax.swing.*;
import com.vedisoft.jm1.swing.class1.*;

public class JTabbedPaneDemo extends JPanel {
	
	JTabbedPane jTabbedPane;
	public JTabbedPaneDemo() {
		setLayout(new BorderLayout());
		jTabbedPane = new JTabbedPane();
		jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
		jTabbedPane.addTab("JLabel Demo", new JLabelDemo());
		jTabbedPane.addTab("JButton Demo", new JButtonDemo());
		jTabbedPane.addTab("JRadioButton Demo", new JRadioButtonDemo());
		jTabbedPane.addTab("JCheckBox Demo", new JCheckBoxDemo());
		jTabbedPane.addTab("JTextArea Demo", new JTextAreaDemo());
		jTabbedPane.addTab("JList Demo", new JListDemo());
		jTabbedPane.addTab("JComboBox Demo", new JComboBoxDemo());
		jTabbedPane.addTab("JSlider Demo", new JSliderDemo());
		jTabbedPane.addTab("JSpinner Demo", new JSpinnerDemo());
		
		
		add(jTabbedPane, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("JJTabbedPane Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JTabbedPaneDemo());
		frame.setBounds( 10,10,800,600 );
		frame.setVisible(true);
	}
}

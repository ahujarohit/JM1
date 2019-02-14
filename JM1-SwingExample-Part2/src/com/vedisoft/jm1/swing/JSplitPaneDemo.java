package com.vedisoft.jm1.swing;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import com.vedisoft.jm1.swing.class1.JLabelDemo;
import com.vedisoft.jm1.swing.class1.JButtonDemo;
import com.vedisoft.jm1.swing.class1.JCheckBoxDemo;
import com.vedisoft.jm1.swing.class1.JComboBoxDemo;

public class JSplitPaneDemo extends JPanel {

	JSplitPane jSplitPane1, jSplitPane2;

	public JSplitPaneDemo() {
		setLayout(new BorderLayout());
		jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		jSplitPane2.setTopComponent(new JLabelDemo());
		jSplitPane2.setBottomComponent(new JButtonDemo());
		
		jSplitPane1.setLeftComponent(jSplitPane2);
		jSplitPane1.setRightComponent(new JComboBoxDemo());
		
		add(jSplitPane1, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("JSplitPane Demo Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new JSplitPaneDemo());
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}

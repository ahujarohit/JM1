package com.vedisoft.jm1.swing;

import javax.swing.UIManager;

public class LookAndFeelDemo1 {
	public static void main(String args[]) {
		UIManager.LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < laf.length; i++) {
			System.out.print("LAF Name: " + laf[i].getName() + " \t");
			System.out.println("LAF Class Name: " + laf[i].getClassName());
		}
		try {
			System.out.println("System Look And Feel Class Name: " + UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

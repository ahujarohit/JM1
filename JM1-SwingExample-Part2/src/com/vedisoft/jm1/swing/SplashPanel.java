package com.vedisoft.jm1.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SplashPanel extends JPanel {

	JProgressBar progressBar;

	public SplashPanel() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(new Color(0, 0, 128), 10));
		Icon icon = new ImageIcon(getClass().getResource("/images/vedisoft.jpg"));
		add(new JLabel(icon), BorderLayout.CENTER);
		progressBar = new JProgressBar(1, 100);
		progressBar.setForeground(new Color(215, 245, 10));
		add(progressBar, BorderLayout.SOUTH);
	}

	public void setProgress(int progress) {
		progressBar.setValue(progress);
	}

	public static void main(String args[]) {
		SplashPanel sp = new SplashPanel();
		JWindow win = new JWindow();
		win.setContentPane(sp);
		win.pack();
		win.setLocationRelativeTo(null);
		win.setVisible(true);
		try {
			for (int i = 1; i <= 100; i++) {
				Thread.sleep(50);
				sp.setProgress(i);
			}
		} catch (Exception e) {
		}
		win.setVisible(false);
		win.dispose();
	}
}

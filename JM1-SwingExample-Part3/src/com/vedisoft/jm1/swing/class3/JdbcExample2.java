package com.vedisoft.jm1.swing.class3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.vedisoft.jdbc.daos.CourseDao;

public class JdbcExample2 extends JPanel implements ActionListener {

	JComboBox<String> cmbCourseName;
	ArrayList<Integer> ids;
	ArrayList<String> courses;
	JTable table;

	public JdbcExample2() {
		setLayout(new BorderLayout());
		CourseDao cDao = new CourseDao();
		ids = cDao.findAllIds();
		courses = cDao.findAllCourses();

		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel("Courses"));
		String s[] = new String[0];
		s = courses.toArray(s);
		cmbCourseName = new JComboBox<String>(s);
		cmbCourseName.addActionListener(this);
		northPanel.add(cmbCourseName);
		northPanel.setLayout(new FlowLayout());
		northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(northPanel, BorderLayout.NORTH);

		StudentTableModel st = new StudentTableModel(ids.get(0));
		table = new JTable(st);
		table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int x = cmbCourseName.getSelectedIndex();
		int id = ids.get(x);
		StudentTableModel st = new StudentTableModel(id);
		table.setModel(st);
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("JDBC Example 2");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JdbcExample2());
		f.setMinimumSize(new Dimension(800, 450));
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}

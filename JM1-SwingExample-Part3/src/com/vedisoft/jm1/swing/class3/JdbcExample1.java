package com.vedisoft.jm1.swing.class3;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import com.vedisoft.jdbc.pojos.Course;
import com.vedisoft.jdbc.daos.CourseDao;

public class JdbcExample1 extends JPanel implements ActionListener {

	JLabel lblCourseName, lblCourseType, statusLabel;
	JTextField txtCourseName, txtCourseType;
	Course course;
	CourseDao courseDao;
	int currentRow, totalRow;
	ArrayList<Integer> ids;

	public JdbcExample1() {
		setLayout(new BorderLayout());

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(null);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

		lblCourseName = new JLabel("Course Name ");
		txtCourseName = new JTextField();
		lblCourseType = new JLabel("Course Type ");
		txtCourseType = new JTextField();
		lblCourseName.setBounds(50, 50, 100, 25);
		txtCourseName.setBounds(200, 50, 200, 25);
		lblCourseType.setBounds(50, 100, 100, 25);
		txtCourseType.setBounds(200, 100, 200, 25);
		centerPanel.add(lblCourseName);
		centerPanel.add(txtCourseName);
		centerPanel.add(lblCourseType);
		centerPanel.add(txtCourseType);

		createToolBar();
		statusLabel = new JLabel(" Row 1 of 1");
		statusLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(centerPanel, BorderLayout.CENTER);
		add(statusLabel, BorderLayout.SOUTH);

		course = new Course();
		courseDao = new CourseDao();
		ids = courseDao.findAllIds();
		if (ids.size() > 0) {
			currentRow = 1;
			totalRow = ids.size();
			course = courseDao.find(ids.get(currentRow - 1));
		}
		updateCourse();
	}

	public void fetchCourse() {
		course.setCourseName(txtCourseName.getText());
		course.setCourseType(txtCourseType.getText());
	}

	public void updateCourse() {
		txtCourseName.setText(course.getCourseName());
		txtCourseType.setText(course.getCourseType());
		statusLabel.setText("Row " + currentRow + " of " + totalRow);
	}

	public void createToolBar() {
		JToolBar jToolBar = new JToolBar();
		JButton btn1 = new JButton(new ImageIcon(getClass().getResource("/icons/First.png")));
		btn1.setActionCommand("First");
		btn1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn1.setToolTipText("First Row");
		btn1.addActionListener(this);
		jToolBar.add(btn1);

		JButton btn2 = new JButton(new ImageIcon(getClass().getResource("/icons/Back.png")));
		btn2.setActionCommand("Previous");
		btn2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn2.setToolTipText("Previous Row");
		btn2.addActionListener(this);
		jToolBar.add(btn2);

		JButton btn3 = new JButton(new ImageIcon(getClass().getResource("/icons/Forward.png")));
		btn3.setActionCommand("Next");
		btn3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn3.setToolTipText("Next Row");
		btn3.addActionListener(this);
		jToolBar.add(btn3);

		JButton btn4 = new JButton(new ImageIcon(getClass().getResource("/icons/Last.png")));
		btn4.setActionCommand("Last");
		btn4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn4.setToolTipText("Last Row");
		btn4.addActionListener(this);
		jToolBar.add(btn4);

		jToolBar.addSeparator();

		JButton btn5 = new JButton(new ImageIcon(getClass().getResource("/icons/update.png")));
		btn5.setActionCommand("Save");
		btn5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn5.setToolTipText("Save Row");
		btn5.addActionListener(this);
		jToolBar.add(btn5);

		JButton btn6 = new JButton(new ImageIcon(getClass().getResource("/icons/delete.png")));
		btn6.setActionCommand("Delete");
		btn6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn6.setToolTipText("Delete Row");
		btn6.addActionListener(this);
		jToolBar.add(btn6);

		JButton btn7 = new JButton(new ImageIcon(getClass().getResource("/icons/add.png")));
		btn7.setActionCommand("New");
		btn7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btn7.setToolTipText("New Row");
		btn7.addActionListener(this);
		jToolBar.add(btn7);

		add(jToolBar, BorderLayout.NORTH);
	}

	@Override

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("First")) {
			if (currentRow != 1) {
				currentRow = 1;
				course = courseDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Previous")) {
			if (currentRow != 1) {
				currentRow = currentRow - 1;
				course = courseDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Next")) {
			if (currentRow != totalRow) {
				currentRow = currentRow + 1;
				course = courseDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Last")) {
			if (currentRow != totalRow) {
				currentRow = totalRow;
				course = courseDao.find(ids.get(currentRow - 1));
				updateCourse();
			}
		} else if (str.equals("Save")) {
			fetchCourse();
			courseDao.editCourse(course);
		} else if (str.equals("New")) {
			course = new Course();
			courseDao.createCourse(course);
			ids = courseDao.findAllIds();
			currentRow = ids.size();
			totalRow = ids.size();
			course = courseDao.find(ids.get(currentRow - 1));
			updateCourse();
		} else if (str.equals("Delete")) {
			if (currentRow != 0) {
				int x = JOptionPane.showConfirmDialog(this, "Are you Sure, you want to delete it !", "Delete",
						JOptionPane.YES_NO_OPTION);
				if (x == JOptionPane.YES_OPTION) {
					boolean answer = courseDao.removeCourse(course.getCourseId());
					if (!answer) {
						JOptionPane.showMessageDialog(this, "Unable to Delete Course !", "Delete",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					ids = courseDao.findAllIds();
					totalRow = ids.size();
					currentRow = currentRow - 1;
					if (currentRow == 0 && totalRow >= 1) {
						currentRow = totalRow;
						course = courseDao.find(ids.get(currentRow - 1));
						updateCourse();
					} else if (currentRow != 0) {
						course = courseDao.find(ids.get(currentRow - 1));
						updateCourse();
					} else {
						txtCourseName.setText("");
						txtCourseType.setText("");
					}
				}
			}
		}
	}

	public static void main(String argv[]) {
		JFrame f = new JFrame("JDBC Example 1");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new JdbcExample1());
		f.setMinimumSize(new Dimension(500, 250));
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
	}
}

package com.vedisoft.jm1.swing.class3;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.vedisoft.jdbc.daos.StudentDao;
import com.vedisoft.jdbc.pojos.Student;

public class StudentTableModel extends AbstractTableModel {

	ArrayList<Student> listStudents;
	String columns[] = { "Student Id", "Student Name", "Course Id", "Registration Date" };

	public StudentTableModel(int courseId) {
		StudentDao sDao = new StudentDao();
		listStudents = sDao.findAllByCourse(courseId);
	}

	public String getColumnName(int col) {
		return columns[col];
	}

	public Class getColumnClass(int c) {
        return columns[c].getClass();
    }
         
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return listStudents.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Student s = listStudents.get(arg0);
		if (arg1 == 0)
			return s.getStudentId();
		else if (arg1 == 1)
			return s.getStudentName();
		else if (arg1 == 2)
			return s.getCourseId();
		else if (arg1 == 3)
			return s.getRegDate();
		return null;
	}

}

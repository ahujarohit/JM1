package com.vedisoft.jm1.collections;

import java.util.*;

class Student implements Comparable<Student> {
	String name;
	String cl;
	String sec;

	public Student() {
		name = new String();
		cl = new String();
		sec = new String();
	}

	public Student(String name, String cl, String section) {
		this.name = name;
		this.cl = cl;
		this.sec = section;
	}

	public String toString() {
		return "\nStudent[" + name + "," + cl + "," + sec + "]";
	}

	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
}

class ClassCriteria implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.cl.compareTo(s2.cl);
	}
}

class SectionCriteria implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		return s1.sec.compareTo(s2.sec);
	}
}

class ClassAndSectionCriteria implements Comparator<Student> {
	public int compare(Student s1, Student s2) {
		int x = s1.cl.compareTo(s2.cl);
		if (x == 0) {
			return s1.sec.compareTo(s2.sec);
		}
		return x;
	}
}

class TestSort {
	public static void main(String args[]) {
		ArrayList<Student> as = new ArrayList<Student>();

		as.add(new Student("Sanjay", "First", "A"));
		as.add(new Student("Shweta", "Second", "B"));
		as.add(new Student("Charu", "First", "C"));
		as.add(new Student("Manish", "Second", "A"));
		as.add(new Student("Nimit", "Third", "B"));
		as.add(new Student("Rahul", "Third", "C"));
		Collections.sort(as);
		System.out.println(as);
		Collections.sort(as, new ClassAndSectionCriteria());
		System.out.println(as);
	}
}

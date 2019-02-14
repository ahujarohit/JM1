package com.vedisoft.jm1.collections;

import java.util.*;

class Employee implements Comparable<Employee> {
	String name;

	public Employee(String name) {
		this.name = name;
	}

	public int compareTo(Employee e1) {
		return name.compareTo(e1.name);
	}
}

class Sort2 {

	public static void main(String args[]) {
		ArrayList<Employee> a = new ArrayList<Employee>();
		Employee e1 = new Employee("Suchita");
		Employee e2 = new Employee("Manish");
		Employee e3 = new Employee("Sanjay");
		Employee e4 = new Employee("Charu");
		Employee e5 = new Employee("Akash");
		a.add(e1);
		a.add(e2);
		a.add(e3);
		a.add(e4);
		a.add(e5);
		Collections.sort(a);
		Iterator<Employee> i = a.iterator();
		while (i.hasNext()) {
			Employee x = i.next();
			System.out.println("After Sorting : " + x.name);
		}

	}
}

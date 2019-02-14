package com.vedisoft.jm1.collections;

import java.util.*;

class MyComp implements Comparator<Employee1> {
	public int compare(Employee1 e1, Employee1 e2) {
		if (e1.age > e2.age)
			return 1;
		else if (e1.age < e2.age)
			return -1;
		else
			return 0;
	}
}

class Employee1 implements Comparable<Employee1> {
	String name;
	int age;

	public Employee1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Employee1 e1) {
		return name.compareTo(e1.name);
	}
}

class Sort3 {
	public static void main(String args[]) {
		ArrayList<Employee1> a = new ArrayList<Employee1>();
		Employee1 e1 = new Employee1("Suchita", 12);
		Employee1 e2 = new Employee1("Manish", 16);
		Employee1 e3 = new Employee1("Sanjay", 10);
		Employee1 e4 = new Employee1("Charu", 11);
		Employee1 e5 = new Employee1("Akash", 12);
		a.add(e1);
		a.add(e2);
		a.add(e3);
		a.add(e4);
		a.add(e5);
		Collections.sort(a);
		Iterator<Employee1> i = a.iterator();
		while (i.hasNext()) {
			Employee1 x = i.next();
			System.out.println("Sorting (Name) : " + x.name + " Age :  " + x.age);
		}
		MyComp c = new MyComp();
		Collections.sort(a, c);
		Iterator<Employee1> i1 = a.iterator();
		while (i1.hasNext()) {
			Employee1 x = i1.next();
			System.out.println("Sorting (Age) : " + x.name + " Age :  " + x.age);
		}
	}
}

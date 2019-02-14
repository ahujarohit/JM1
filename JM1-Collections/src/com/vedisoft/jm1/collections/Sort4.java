package com.vedisoft.jm1.collections;

import java.util.*;

class Sort4 {
	public static void main(String args[]) {
		Employee1 e[] = { new Employee1("Sanjay", 25), new Employee1("Rahul", 21), new Employee1("Akash", 23) };
		Arrays.sort(e);
		for (Employee1 e1 : e)
			System.out.println("Name : " + e1.name + " Age " + e1.age);

		MyComp c = new MyComp();
		Arrays.sort(e, c);
		for (Employee1 e1 : e)
			System.out.println("Name : " + e1.name + " Age " + e1.age);

	}
}
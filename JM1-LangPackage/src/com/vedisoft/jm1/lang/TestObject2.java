package com.vedisoft.jm1.lang;

class Employee1 {
	int code;
	String name;

	public Employee1(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String toString() {
		return "Employee [" + code + "," + name + "]";
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof Employee1) {
			Employee1 e = (Employee1) o;
			if (code == e.code && name.equals(e.name))
				return true;
		}
		return false;
	}
}

public class TestObject2 {

	public static void main(String args[]) {
		Employee1 e = new Employee1(1, "Manish");
		Employee1 e1 = new Employee1(1, "Manish");
		Employee1 e2 = e1;

		System.out.println(e == e1);
		System.out.println(e1 == e2);
		System.out.println(e == e2);

		System.out.println(e);
	}
}







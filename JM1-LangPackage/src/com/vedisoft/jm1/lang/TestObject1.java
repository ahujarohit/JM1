package com.vedisoft.jm1.lang;

class Employee {
	int code;
	String name;

	public Employee(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof Employee) {
			Employee e = (Employee) o;
			if (code == e.code && name.equals(e.name))
				return true;
		}
		return false;
	}

	public String toString() {
		return "Employee :[" + code + "," + name + "]";
	}

}

public class TestObject1 {

	public static void main(String args[]) {
		Employee e = new Employee(1, "Manish");
		Employee e1 = new Employee(1, "Manish");
		Employee e2 = e1;

		System.out.println(e.equals(e1));
		System.out.println(e1.equals(e2));
		System.out.println(e.equals(e2));

		System.out.println(e);
	}

}






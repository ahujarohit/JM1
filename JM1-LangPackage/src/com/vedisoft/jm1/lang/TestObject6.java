package com.vedisoft.jm1.lang;

class Employee2 {
	int code;
	String name;

	public Employee2(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String toString() {
		return "Employee2 [" + code + "," + name + "]";
	}

	public boolean equals(Object o) {
		if (o != null && o instanceof Employee2) {
			Employee2 e = (Employee2) o;
			if (code == e.code && name.equals(e.name))
				return true;
		}
		return false;
	}


	public int hashCode() {
		return (code % 10 + name.length());
		// return ( code %10 );
		// returm name.length();
	}
}

class TestObject6 {

	public static void main(String args[]) {
		Employee2 e = new Employee2(1, "Manish");
		System.out.println(e);
	}
}





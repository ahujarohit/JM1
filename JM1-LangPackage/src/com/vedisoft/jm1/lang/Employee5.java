package com.vedisoft.jm1.lang;

public class Employee5 {
	protected int code;
	protected String name;

	public Employee5(int code, String name) {
		this.code = code;
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Employee5 [code=" + code + ", name=" + name + "]";
	}


	public static void main(String args[]) {
		String str = new String();
		System.out.println(str.getClass());
		Employee5 e = new Employee5(1,"Rahul");
		System.out.println(e);
	}

}













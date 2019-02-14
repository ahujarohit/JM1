package com.vedisoft.jm1.io.serialize;

//If derive class implements Serializable and base class does not implement Serializable. 
//No Exception will be generated, but base class data will be as per the default constructor

import java.io.*;

class Employee1 {
	int code;
	String name;

	public Employee1() {
		code = 1;
		name = "No Name";
	}

	public Employee1(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String toString() {
		return "Employee1 [ " + code + " , " + name + "]";
	}

	public static void main(String args[]) {
		PEmployee1 e = new PEmployee1(100, "Rahul", "Sales", "Mgr", 10000f);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Emp.dat"));
			out.writeObject(e);
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Emp.dat"))) {
			PEmployee1 e1 = (PEmployee1) in.readObject();
			System.out.println(e1);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

class PEmployee1 extends Employee1 implements Serializable {
	String dept;
	String desig;
	float basic;

	public PEmployee1() {
		dept = "No Dept";
		desig = "No Desig";
		basic = 1000;
	}

	public PEmployee1(int code, String name, String dept, String desig, float basic) {
		super(code, name);
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}

	public String toString() {
		return "Permanent Employee1 [ " + code + " , " + name + " , " + dept + " , " + desig + " , " + basic + "]";
	}

}

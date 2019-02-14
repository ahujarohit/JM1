package com.vedisoft.jm1.io.serialize;

//If base class implements Serializable derive class automatically implements Serializable

import java.io.*;

class Employee implements Serializable {
	int code;
	String name;

	public Employee() {
		code = 1;
		name = "No Name";
	}

	public Employee(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String toString() {
		return "Employee [ " + code + " , " + name + "]";
	}

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Emp.dat"))) {
			PEmployee e = new PEmployee(100, "Rahul", "Sales", "Mgr", 10000f);
			out.writeObject(e);
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Emp.dat"))) {
			Employee e1 = (Employee) in.readObject();
			in.close();
			System.out.println(e1);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class PEmployee extends Employee {
	String dept;
	String desig;
	float basic;

	public PEmployee() {
		dept = "No Dept";
		desig = "No Desig";
		basic = 1000;
	}

	public PEmployee(int code, String name, String dept, String desig, float basic) {
		super(code, name);
		this.dept = dept;
		this.desig = desig;
		this.basic = basic;
	}

	public String toString() {
		return "Permanent Employee [ " + code + " , " + name + " , " + dept + " , " + desig + " , " + basic + "]";
	}

}

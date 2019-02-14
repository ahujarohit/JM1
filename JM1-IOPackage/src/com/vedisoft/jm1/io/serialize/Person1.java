package com.vedisoft.jm1.io.serialize;

//Not only class, but all its instance variables needs to Serialized

import java.io.*;

class Name1 implements Serializable {
	String fName1;
	String lName1;

	public Name1() {
		fName1 = "First Name1";
		lName1 = "Last Name1";
	}

	public Name1(String fName1, String lName1) {
		this.fName1 = fName1;
		this.lName1 = lName1;
	}
}

class Person1 implements Serializable {
	Name1 name1;
	int age;

	public Person1() {
		name1 = new Name1();
		age = 10;
	}

	public Person1(Name1 name1, int age) {
		this.name1 = name1;
		this.age = age;
	}

	public String toString() {
		return "Name1 : " + name1.fName1 + " " + name1.lName1 + " Age : " + age;
	}

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Person1.dat"))) {
			Name1 n = new Name1("Manish", "Jain");
			Person1 p = new Person1(n, 20);
			out.writeObject(p);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person1.dat"))) {
			Person1 p = (Person1) in.readObject();
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

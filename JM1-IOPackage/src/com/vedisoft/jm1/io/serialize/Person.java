package com.vedisoft.jm1.io.serialize;

//Not only class, but all its instance variables needs to Serialized

import java.io.*;

class Name {
	String fname;
	String lname;

	public Name() {
		fname = "First Name";
		lname = "Last Name";
	}

	public Name(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
}

class Person implements Serializable {
	Name name;
	int age;

	public Person() {
		name = new Name();
		age = 10;
	}

	public Person(Name name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Name : " + name.fname + " " + name.lname + " Age : " + age;
	}

	public static void main(String args[]) {

		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
			Name n = new Name("Manish", "Jain");
			Person p = new Person(n, 20);
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
			Person p = (Person) in.readObject();
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

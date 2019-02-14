package com.vedisoft.jm1.io.serialize;

//Class Does not implement Serializable and will generate NotSeriableException

import java.io.*;

class Book1 {
	int code;
	String name;
	String aname;
	float price;

	public Book1() {
		code = 1;
		name = "Book1 Name";
		aname = "Author Name";
		price = 10.0f;
	}

	public Book1(int code, String name, String aname, float price) {
		this.code = code;
		this.name = name;
		this.aname = aname;
		this.price = price;
	}

	public String toString() {
		return "Book1 [" + code + "," + name + "," + aname + "," + price + "]";
	}

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Book1s.dat"))) {
			Book1 b = new Book1(123, "Java Certification", "Kathy Sierra", 350f);
			out.writeObject(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Book1s.dat"))) {
			Book1 b1 = (Book1) in.readObject();
			System.out.println(b1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
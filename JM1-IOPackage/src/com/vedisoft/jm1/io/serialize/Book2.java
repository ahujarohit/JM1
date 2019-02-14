package com.vedisoft.jm1.io.serialize;

//transient cannot be serialized, incase of serializable it will hold default values 
//numeric by 0, boolean by false, character by space and objects by null

import java.io.*;

class Book2 implements Serializable {
	int code;
	String name;
	transient String aname;
	transient float price;

	public Book2() {
		code = 1;
		name = "Book2 Name";
		aname = "Author Name";
		price = 10.0f;
	}

	public Book2(int code, String name, String aname, float price) {
		this.code = code;
		this.name = name;
		this.aname = aname;
		this.price = price;
	}

	public String toString() {
		return "Book2 [" + code + "," + name + "," + aname + "," + price + "]";
	}

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Book2s.dat"))) {
			Book2 b = new Book2(123, "Java Certification", "Kathy Sierra", 350f);
			out.writeObject(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Book2s.dat"))) {
			Book2 b1 = (Book2) in.readObject();
			System.out.println(b1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

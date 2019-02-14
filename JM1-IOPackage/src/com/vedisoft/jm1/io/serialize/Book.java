package com.vedisoft.jm1.io.serialize;

import java.io.*;

class Book implements Serializable {
	int code;
	String name;
	String aname;
	float price;

	public Book() {
		code = 1;
		name = "Book Name";
		aname = "Author Name";
		price = 10.0f;
	}

	public Book(int code, String name, String aname, float price) {
		this.code = code;
		this.name = name;
		this.aname = aname;
		this.price = price;
	}

	public String toString() {
		return "Book [" + code + "," + name + "," + aname + "," + price + "]";
	}

	public static void main(String args[]) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
			Book b = new Book(123, "Java Certification", "Kathy Sierra", 350f);
			out.writeObject(b);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("books.dat"))) {
			Book b1 = (Book) in.readObject();
			System.out.println(b1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

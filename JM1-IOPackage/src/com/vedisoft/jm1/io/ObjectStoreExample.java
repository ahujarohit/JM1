package com.vedisoft.jm1.io;

import java.io.*;

public class ObjectStoreExample {

	public static void main(String[] args) {

		try (FileOutputStream fos = new FileOutputStream("books.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			Book book = new Book("0-07-222565-3", "Hacking Exposed J2EE & Java",
					"Art Taylor, Brian Buege, Randy Layman", 125.5f);
			oos.writeObject(book);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("books.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Book book = (Book) ois.readObject();
			System.out.println(book);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

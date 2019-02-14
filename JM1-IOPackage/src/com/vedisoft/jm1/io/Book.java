package com.vedisoft.jm1.io;

import java.io.Serializable;

public class Book implements Serializable {

	private String isbn;
	private String title;
	private String author;
	private float price;

	public Book() {
	}

	public Book(String isbn, String title, String author, float price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String toString() {
		return "[Book: " + isbn + ", " + title + ", " + author + "," + price + "]";
	}
}
/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */

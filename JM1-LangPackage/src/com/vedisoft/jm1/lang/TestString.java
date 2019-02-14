package com.vedisoft.jm1.lang;

public class TestString {
	public static void main(String args[]) {
		String str = new String("Welcome"); // Welcome
		char c[] = { 'W', 'e', 'l', 'c', 'o', 'm', 'e' };
		String str1 = new String(c, 3, 4); // come
		byte b[] = { 65, 66, 67, 68, 69, 70 };
		String str2 = new String(b, 0, 4); // ABCD
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str2);

		String s1 = new String("Welcome");
		int a = s1.indexOf("e"); // 1
		int bb = s1.indexOf("e", a + 1); // 6
		int cc = s1.lastIndexOf("e"); // 6
		int d = s1.lastIndexOf("e", cc - 1); // 1
		int e = s1.indexOf("me"); // 5
		int f = s1.indexOf("zee"); // -1

		char g = s1.charAt(3); // c

		String s2 = s1.toUpperCase(); // WELCOME
		boolean b1 = s1.equals(s2); // false
		boolean b2 = s1.equalsIgnoreCase(s2); // true
		boolean b3 = s1.startsWith("A"); // false
		boolean b4 = s1.endsWith("me"); // true
		int h = s1.compareTo(s2); // 32
		System.out.println(h);

		String s3 = new String("  Hello  World  ");
		System.out.println(s3.length()); // 16
		String s4 = s3.trim();
		System.out.println(s4.length()); // 12
		System.out.println(s4.substring(7)); // World
		System.out.println(s4.substring(0, 5)); // Hello

		String str6 = new String("Welcome to Java");
		String str7[] = str6.split(" ");
		for (String str8 : str7)
			System.out.println(str8);

		String str9[] = str6.split(" ", 2);
		for (String str10 : str9)
			System.out.println(str10);

		System.out.println("hello".concat(" world").concat(" !!!"));
	}
}












package com.vedisoft.jm1.lang;

public class WrapperConstructors {

	public static void main(String args[]) {

		// Byte b1 = new Byte(10); -- Compilation Error

		byte b = 10;
		Byte b1 = new Byte(b);
		System.out.println(b1);

		// Byte b2 = new Byte("128"); -- NumberFormatException

		Byte b2 = new Byte("127");
		System.out.println(b2);

		// Short s1 = new Short(10); -- Compilation Error
		short s = 10;
		Short s1 = new Short(s);
		System.out.println(s1);

		Short s2 = new Short(b);
		System.out.println(s2);

		// Short s3 = new Short("40000"); -- NumberFormatException

		Integer i1 = new Integer(10);
		System.out.println(i1);

		Integer i2 = new Integer(s);
		System.out.println(i2);

		Long l1 = new Long(10);
		System.out.println(l1);

		Float f1 = new Float(10.5);
		System.out.println(f1);
		Float f2 = new Float(10.5f);
		System.out.println(f2);

		Boolean bool1 = new Boolean(true);
		System.out.println(bool1);
		// Boolean bool2 = new Boolean(TRUE); -- Compilation Error
		Boolean bool2 = new Boolean("tRuE");
		System.out.println(bool2);
		Boolean bool3 = new Boolean("Abra Ka Dabra");
		System.out.println(bool3);

		// Character c = new Character(65); -- Compilation Error
		char c = 65;
		Character c1 = new Character(c);
		System.out.println(c1);
		Character c2 = new Character('A');
		System.out.println(c2);

	}
}

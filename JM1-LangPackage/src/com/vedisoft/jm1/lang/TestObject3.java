package com.vedisoft.jm1.lang;

class TestObject3 {

	public static void main(String args[]) {
		String str1 = new String("Welcome");
		String str2 = new String("Welcome");
		String str3 = str1;

		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str3.equals(str1));

		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str3 == str1);

		String str11 = "Welcome";
		String str22 = "Welcome";
		String str33 = str11;

		System.out.println(str11.equals(str22));
		System.out.println(str22.equals(str33));
		System.out.println(str33.equals(str11));

		System.out.println(str11 == str22);
		System.out.println(str22 == str33);
		System.out.println(str33 == str11);

	}
}
package com.vedisoft.jm1.lang;

class TestObject5 {

	public static void main(String args[]) {
		Boolean i1 = false;
		Boolean i2 = false;
		Boolean i3 = i1;
		System.out.println(i1.equals(i2));
		System.out.println(i2.equals(i3));
		System.out.println(i3.equals(i1));
		System.out.println(i1 == i2);
		System.out.println(i2 == i3);
		System.out.println(i3 == i1);
	}
}
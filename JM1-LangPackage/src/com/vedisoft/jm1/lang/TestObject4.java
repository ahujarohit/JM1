package com.vedisoft.jm1.lang;

class TestObject4 {

	public static void main(String args[]) {
		Integer i1 = 127;
		Integer i2 = 127;
		Integer i3 = i1;
		System.out.println(i1.equals(i2));
		System.out.println(i2.equals(i3));
		System.out.println(i3.equals(i1));
		System.out.println(i1 == i2);
		System.out.println(i2 == i3);
		System.out.println(i3 == i1);
	}
}









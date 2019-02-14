package com.vedisoft.jm1.lang;

public class TestStringBuffer {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Welcome");
		sb.append(" to Java");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.delete(7, 10);
		System.out.println(sb);
		sb.insert(7, " to");
		System.out.println(sb);
		StringBuffer sb1 = new StringBuffer("abcdefg");
		System.out.println(sb1.insert(3, "ijkl").reverse().delete(2, 4).toString());
	}
}

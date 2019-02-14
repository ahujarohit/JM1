package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class RSExample2 {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/emp?useSSL=false";
	static final String USER = "root";
	static final String PASS = "vedisoft";

	public static void main(String[] args) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to register the driver.");
		}

		System.out.println("Connecting to database and creating statement...");

		try (
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_UPDATABLE);) {
			String sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("List result set for reference....");
			printRs(rs);

			rs.beforeFirst();
			while (rs.next()) {
				int newAge = rs.getInt("age") + 5;
				rs.updateInt("age", newAge);
				rs.updateRow();
			}
			System.out.println("List result set showing new ages...");
			printRs(rs);
			System.out.println("Inserting a new record...");
			rs.moveToInsertRow();
			rs.updateInt("id", 402);
			rs.updateString("first", "John");
			rs.updateString("last", "Paul");
			rs.updateInt("age", 40);
			rs.insertRow();
			System.out.println("List result set showing new set...");
			printRs(rs);

			rs.absolute(2);
			System.out.println("List the record before deleting...");
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");

			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);

			rs.deleteRow();
			printRs(rs);

			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}

	public static void printRs(ResultSet rs) throws SQLException {
		rs.beforeFirst();
		while (rs.next()) {
			int id = rs.getInt("id");
			int age = rs.getInt("age");
			String first = rs.getString("first");
			String last = rs.getString("last");
			System.out.print("ID: " + id);
			System.out.print(", Age: " + age);
			System.out.print(", First: " + first);
			System.out.println(", Last: " + last);
		}
		System.out.println();
	}
}




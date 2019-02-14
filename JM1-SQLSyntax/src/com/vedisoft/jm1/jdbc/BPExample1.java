package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class BPExample1 {

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

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			conn.setAutoCommit(false);

			printRows(stmt);

			String SQL = "INSERT INTO Employees (id, first, last, age) " + "VALUES(200,'Zia', 'Ali', 30)";
			stmt.addBatch(SQL);

			SQL = "INSERT INTO Employees (id, first, last, age) " + "VALUES(201,'Raj', 'Kumar', 35)";
			stmt.addBatch(SQL);

			SQL = "UPDATE Employees SET age = 35 " + "WHERE id = 100";
			stmt.addBatch(SQL);

			int[] count = stmt.executeBatch();
			for (int x : count)
				System.out.println(x);

			conn.commit();

			printRows(stmt);

			stmt.close();
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}

	public static void printRows(Statement stmt) throws SQLException {
		System.out.println("Displaying available rows...");
		String sql = "SELECT id, first, last, age FROM Employees";
		ResultSet rs = stmt.executeQuery(sql);

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
		rs.close();
	}
}

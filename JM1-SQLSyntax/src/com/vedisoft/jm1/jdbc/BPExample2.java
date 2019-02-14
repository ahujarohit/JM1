package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class BPExample2 {

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
		String SQL = "INSERT INTO Employees(id,first,last,age) " + "VALUES(?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(SQL);) {
			conn.setAutoCommit(false);

			printRows(stmt);

			stmt.setInt(1, 400);
			stmt.setString(2, "Pappu");
			stmt.setString(3, "Singh");
			stmt.setInt(4, 33);
			stmt.addBatch();

			stmt.setInt(1, 401);
			stmt.setString(2, "Pawan");
			stmt.setString(3, "Singh");
			stmt.setInt(4, 31);
			stmt.addBatch();

			int[] count = stmt.executeBatch();

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

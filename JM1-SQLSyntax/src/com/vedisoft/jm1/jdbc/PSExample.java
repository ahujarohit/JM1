package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class PSExample {

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
		String sql = "UPDATE Employees set age=? WHERE id=?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setInt(1, 35); // This would set age
			stmt.setInt(2, 102); // This would set ID

			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows);

			sql = "SELECT id, first, last, age FROM Employees";
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
			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}

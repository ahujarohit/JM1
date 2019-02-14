package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class TSExample1 {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/emp?useSSL=false";
	static final String USER = "root";
	static final String PASS = "vedisoft";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			conn.setAutoCommit(false);

			System.out.println("Creating statement...");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			System.out.println("Inserting one row....");
			String SQL = "INSERT INTO Employees " + "VALUES (208, 20, 'Rita', 'Tez')";
			stmt.executeUpdate(SQL);

			SQL = "INSERT INTO Employees " + "VALUES (207, 22, 'Sita', 'Singh')";
			stmt.executeUpdate(SQL);

			System.out.println("Commiting data here....");
			conn.commit();

			String sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");
			printRs(rs);

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("Rolling back data here....");
			try {
				if (conn != null) {
					conn.rollback();
				}
			} catch (SQLException se2) {
				se2.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
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

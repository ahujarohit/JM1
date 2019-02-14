package com.vedisoft.jm1.jdbc;
import java.sql.*;

public class TSExample2 {

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
			stmt = conn.createStatement();

			String sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("List result set for reference....");
			printRs(rs);

			Savepoint savepoint1 = conn.setSavepoint("ROWS_DELETED_1");
			System.out.println("Deleting row....");
			String SQL = "DELETE FROM Employees " + "WHERE ID = 110";
			stmt.executeUpdate(SQL);
			conn.rollback(savepoint1);

			Savepoint savepoint2 = conn.setSavepoint("ROWS_DELETED_2");
			System.out.println("Deleting row....");
			SQL = "DELETE FROM Employees " + "WHERE ID = 95";
			stmt.executeUpdate(SQL);
			conn.commit();
			sql = "SELECT id, first, last, age FROM Employees";
			rs = stmt.executeQuery(sql);
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

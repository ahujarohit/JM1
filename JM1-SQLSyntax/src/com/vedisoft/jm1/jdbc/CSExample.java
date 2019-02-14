package com.vedisoft.jm1.jdbc;

import java.sql.*;

public class CSExample {

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
		String sql = "{call getEmpName (?, ?)}";
		System.out.println("Connecting to database and creating statement...");
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				CallableStatement stmt = conn.prepareCall(sql);) {

			int empID = 102;
			stmt.setInt(1, empID);
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

			System.out.println("Executing stored procedure...");
			stmt.execute();

			String empName = stmt.getString(2);
			System.out.println("Emp Name with ID:" + empID + " is " + empName);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}

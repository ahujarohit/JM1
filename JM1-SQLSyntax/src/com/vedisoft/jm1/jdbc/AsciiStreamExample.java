package com.vedisoft.jm1.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class AsciiStreamExample {

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
		String SQL = "INSERT INTO ascii_data VALUES (?,?)";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(SQL);) {
			File f = new File("Database.sql");
			FileInputStream fis = new FileInputStream(f);
			long fileLength = f.length();

			pstmt.setInt(1, 100);
			pstmt.setAsciiStream(2, fis, (int) fileLength);
			pstmt.execute();
			fis.close();

			SQL = "SELECT Data FROM ascii_data WHERE id=100";
			ResultSet rs = stmt.executeQuery(SQL);
			if (rs.next()) {
				InputStream xmlInputStream = rs.getAsciiStream(1);
				int c;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				while ((c = xmlInputStream.read()) != -1) {
					bos.write(c);
				}
				System.out.println(bos.toString());
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

package com.vedisoft.jm1.jdbc;

import java.io.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;

public class BinaryStreamExample {

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
		String SQL = "INSERT INTO binary_data VALUES (?,?,?)";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(SQL);) {

			File f = new File("vedisoft.jpg");
			long fileLength = f.length();
			FileInputStream fis = new FileInputStream(f);

			pstmt.setInt(1, 100);
			pstmt.setString(2, f.getName());
			pstmt.setBinaryStream(3, fis, (int) fileLength);
			pstmt.execute();

			fis.close();

			SQL = "SELECT name, image FROM binary_data WHERE id=100";
			ResultSet rs = stmt.executeQuery(SQL);
			if (rs.next()) {
				InputStream xmlInputStream = rs.getBinaryStream("image");
				int c;
				File f1 = new File("C:\\images");
				if (!f1.exists())
					f1.mkdir();
				File f2 = new File(f1, rs.getString("name"));
				FileOutputStream bos = new FileOutputStream(f2);
				while ((c = xmlInputStream.read()) != -1) {
					bos.write(c);
				}
				bos.flush();
				bos.close();
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

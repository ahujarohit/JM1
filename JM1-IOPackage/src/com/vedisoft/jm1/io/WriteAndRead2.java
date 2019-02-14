package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead2 {

	public static void main(String[] args) {
		try {
			File dir1 = new File("Company");
			dir1.mkdir();
			System.out.println("The existence of company directory is : " + dir1.isDirectory());

			File file1 = new File(dir1, "EmployeesDetail.txt");
			file1.createNewFile();
			System.out.println("The existence of EmoloyeesDetail file is : " + file1.isFile());

			File file2 = new File(dir1, "SalaryDetail.txt");
			file2.createNewFile();
			System.out.println("The existence of SalaryDetail file is : " + file2.isFile());

			file2.delete();
			System.out.println("The existence of SalaryDetail file is : " + file2.isFile());
			dir1.delete();
			System.out.println("The existence of company directory is : " + dir1.isDirectory());
			File file1Rename = new File(dir1, "IdentityDetail.txt");
			file1.renameTo(file1Rename);

			System.out.println("The existence of IdentityDetail file is : " + file1Rename.isFile());
			System.out.println("The existence of EmoloyeesDetail file is : " + file1.isFile());
			File dir1Rename = new File("Vedisoft");
			dir1.renameTo(dir1Rename);
			System.out.println("The existence of company directory is : " + dir1.isDirectory());
			System.out.println("The existence of Kogent directory is : " + dir1Rename.isDirectory());
		} catch (IOException e) {
		}
	}
}
/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */
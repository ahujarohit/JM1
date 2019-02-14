package com.vedisoft.jm1.io;

import java.io.*;

public class WriteAndRead1 {

    public static void main(String[] args) {
        try {
            boolean b1 = false;
            File file = new File("MyFile.txt");
            System.out.println(file.exists());
            b1 = file.createNewFile();
            System.out.println(b1);
            System.out.println(file.exists());
        } catch (IOException e) {
        }
    }
}
/**
* Vedisoft : Java - Module 1 "Desktop Technologies"
*
*   Vedisoft Software & Education Services Pvt. Ltd.
*   Plot No. 275, Zone II, M.P. Nagar,
*   Bhopal.
*   Phone : 0755 - 4076207, 4076208
*   Email : contact@vedisoft.com
*   Web : www.vedisoft.com
*/
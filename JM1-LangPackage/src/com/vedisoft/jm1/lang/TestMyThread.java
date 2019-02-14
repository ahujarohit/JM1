package com.vedisoft.jm1.lang;

class MyThread extends Thread {

	public MyThread() {
		super("Using Thread Class");
		System.out.println("Child thread  : " + this);
		start();
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException ie) {
		}
		System.out.println("Exiting Child Thread...");
	}
}

class TestMyThread {

	public static void main(String args[]) {
		MyThread a = new MyThread();
		try {
			for (int k = 5; k > 0; k--) {
				System.out.println("Main Thread " + k);
				Thread.sleep(1000);
			}
		} catch (InterruptedException ie1) {
		}
		System.out.println("Exiting Main Thread...");
	}
}

/**
 * Vedisoft : Java - Module 1 "Desktop Technologies"
 *
 *
 * Vedisoft Software & Education Services Pvt. Ltd. Plot No. 275, Zone II, M.P.
 * Nagar, Bhopal. Phone : 0755 - 4076207, 4076208 Email : contact@vedisoft.com
 * Web : www.vedisoft.com
 */

package com.vedisoft.jm1.lang;

class IntThread implements Runnable {

	Thread t;

	public IntThread() {
		t = new Thread(this, "Test Thread");
		t.setDaemon(true);
		System.out.println("Child thread  : " + t);
		t.start();
	}

	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Child Thread " + i);
				t.sleep(1000);
			}
		} catch (InterruptedException ie) {
		}
		System.out.println("Exiting Child Thread...");
	}

	public static void main(String args[]) {
		IntThread i = new IntThread();
		try {
			for (int j = 5; j > 0; j--) {
				System.out.println("Main Thread " + j);
				Thread.sleep(500);
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
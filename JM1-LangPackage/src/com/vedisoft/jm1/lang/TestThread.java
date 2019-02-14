package com.vedisoft.jm1.lang;

class EvenThread extends Thread {

	boolean running = true;
	int num;

	public void run() {
		while (running) {
			try {
				System.out.println(num);
				num += 2;
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}

	public void stopEven() {
		running = false;
	}
}

class OddThread extends Thread {

	boolean running = true;
	int num;

	public OddThread() {
		num = 1;
	}

	public void run() {
		while (running) {
			try {
				System.out.println(num);
				num += 2;
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}

	public void stopOdd() {
		running = false;
		
	}
}

class TestThread {

	public static void main(String args[]) {
		EvenThread et = new EvenThread();
		OddThread ot = new OddThread();
		try {
			et.start();
			ot.start();
			Thread.sleep(5000);
			et.stopEven();
			ot.stopOdd();
			et.join();
			ot.join();
		} catch (InterruptedException ie) {
		}
		System.out.println("Ending Main.");
	}
}

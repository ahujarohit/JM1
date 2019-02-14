package com.vedisoft.jm1.lang;

class Abc {
	protected int a;

	public Abc(int a) {
		this.a = a;
	}

	public void increment() {
		synchronized (this) {
			a += 10;
		}
	}
}

class MyThread1 extends Thread {
	Abc obj;

	public MyThread1(Abc obj) {
		this.obj = obj;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				obj.increment();
				Thread.sleep(200);
			} catch (InterruptedException ie) {
			}
		}
	}
}

class TestThread1 {
	public static void main(String args[]) {
		Abc obj = new Abc(10);
		MyThread1 mt1 = new MyThread1(obj);
		MyThread1 mt2 = new MyThread1(obj);
		try {
			mt1.start();
			mt2.start();
			mt1.join();
			mt2.join();
		} catch (InterruptedException ie) {
		}
		System.out.println("A : " + obj.a);
	}
}


/*

Dead Lock: 

When two threads or processes are waiting for each other to release the resource or object they holds and so are blocked forever. This situation is called deadlock. For example if one thread is holding the lock on some object that the other thread is waiting for and the other thread is holding lock on some object the first one is waiting for then they both will wait for each other to release the object they need to finish their operation but no one will release the hold object and so they will wait for each other forever.
Example to show DeadLock condition: In this example, there are two thread objects myThread and yourThread. When myThread starts running it holds lock on str1 object. If now yourThread strarts it gets lock on str2. Now when first thread continues and wants lock on str2 then it is not available because second thread already holds lock on str2. Now both thread will wait for each other. myThread waits for str2 to be released by yourThread and yourThread is waiting for str1 to be released by myThread. This program now goes to deadlock condition. Now if you want to break the program then you need to press CTRL and C from keyboard.

DeadLockDemo.java
*/

package com.vedisoft.jm1.lang;

public class DeadLockDemo {
	public static String str1 = "str1";
	public static String str2 = "str2";

	public static void main(String[] a) {
		Thread myThread = new MyThread();
		Thread yourThread = new YourThread();

		myThread.start();
		yourThread.start();
	}

	private static class MyThread extends Thread {
		public void run() {
			synchronized (str1) {
				System.out.println("MyThread Holds lock on object str1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}

				System.out.println("MyThread waiting for lock on object str2");
				synchronized (str2) {
					System.out.println("MyThread Holds lock on objects str1, str2");
				}
			}
		}
	}

	private static class YourThread extends Thread {
		public void run() {
			synchronized (str2) {
				System.out.println("YourThread Holds lock on object str2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				System.out.println("YourThread waiting for lock on object str1");
				synchronized (str1) {
					System.out.println("YourThread Holds lock on objects str1, str2");
				}
			}
		}
	}
}

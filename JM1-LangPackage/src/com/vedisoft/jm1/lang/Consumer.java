package com.vedisoft.jm1.lang;

class Consumer extends Thread {

	Stock stock;
	boolean running;

	public Consumer(Stock stock) {
		this.stock = stock;
		running = true;
	}

	public void run() {
		while (running) {
			try {
				Thread.sleep(200);
				int rStock = (int) (Math.random() * 100);
				stock.getStock(rStock);
			} catch (InterruptedException ie) {
			}
		}
	}

	public void stopConsumer() {
		running = false;
	}
}

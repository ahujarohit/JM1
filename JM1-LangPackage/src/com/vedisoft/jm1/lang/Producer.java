package com.vedisoft.jm1.lang;

class Producer extends Thread {

	Stock stock;
	boolean running;

	public Producer(Stock stock) {
		this.stock = stock;
		running = true;
	}

	public void run() {
		while (running) {
			try {
				Thread.sleep(200);
				int rStock = (int) (Math.random() * 100);
				stock.addStock(rStock);
			} catch (InterruptedException ie) {
			}
		}
	}

	public void stopProducer() {
		running = false;
	}
}




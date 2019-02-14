package com.vedisoft.jm1.lang;

class Stock {

	protected int goods;

	public synchronized void addStock(int stock) {
		goods += stock;
		System.out.println("Stock Added : " + stock);
		System.out.println("Present Stock : " + goods);
		notify();
	}

	public synchronized void getStock(int stock) {
		while (true) {
			if (goods >= stock) {
				goods -= stock;
				System.out.println("Consumer Withdrawn : " + stock);
				System.out.println("Present Stock : " + goods);
				break;
			} else {
				System.out.println("Stock Not Enough....... ");
				System.out.println("Waiting for Stock to Come. ");
				try {
					wait();
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public static void main(String args[]) {
		Stock stock = new Stock();
		Producer producer = new Producer(stock);
		Consumer consumer = new Consumer(stock);
		try {
			producer.start();
			consumer.start();
			Thread.sleep(1000);
			producer.stopProducer();
			consumer.stopConsumer();
			producer.join();
			consumer.join();
		} catch (InterruptedException ie) {
		}
	}
}

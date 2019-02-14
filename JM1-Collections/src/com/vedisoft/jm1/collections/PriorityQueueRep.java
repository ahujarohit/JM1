package com.vedisoft.jm1.collections;

import java.util.*;

public class PriorityQueueRep {
	public static void main(String[] args) {
		int[] intarray = { 2, 5, 3, 8, 6, 9, 1, 4, 7 };
		/*
		 * PriorityQueue<Integer> Pq = new PriorityQueue<Integer>(); for (int i :
		 * intarray) { Pq.offer(i); }
		 * 
		 * for (int i : intarray) { System.out.print(Pq.poll() + " "); }
		 */

		SortQueue Qsort = new SortQueue();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(5, Qsort);
		for (int i : intarray) {
			pq1.offer(i);
		}
		System.out.println("\nSize of the Q = " + pq1.size());
		System.out.println("Peek result = " + pq1.peek());
		pq1.size();
		System.out.println("Poll result = " + pq1.poll());
		System.out.println("Size of the updated Q = " + pq1.size());
		for (int i : intarray) {
			System.out.print(pq1.poll() + " ");
		}
		System.out.println();
	}
}

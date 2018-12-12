package com.kd.concurrent;

import java.util.ArrayList;

/**
 * @author Kumar
 *
 *         Output: aaa Child thread : Thread-0 executing adding in list
 *         Exception in thread "main"
 *         java.util.ConcurrentModificationException...
 *
 *         Definition: (In traditional Collection)If one thread iterating/modifying an object and other
 *         thread is trying to modify same abject then
 *         ConcurrentModificationException occurs.
 *
 */
public class ConcurrentModificationExceptionDemo {

	static ArrayList<String> list = new ArrayList<>();

	static class Task implements Runnable {

		@Override
		public void run() {

			for (String str : list) {
				System.out.println("Child thread : " + Thread.currentThread().getName() + " executing adding in list");
				System.out.println(str);
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				list.add("eee");
			}

			//
		}
	}

	public static void main(String[] args) throws InterruptedException {

		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");

		Thread t1 = new Thread(new Task());
		t1.start();

		for (String str : list) {
			System.out.println(str);
			Thread.sleep(2000);
		}
		
		/*for(int i=0; i < 2; i++) {
			list.add("a");
			Thread.sleep(2000);
		}*/

	}

}

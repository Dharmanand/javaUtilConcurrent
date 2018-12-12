package com.kd.concurrent.chm;
/*
 * @auther Kumar 
 * 
 * ConcurrentHashMap has three extra methods wrt HashMap.
 *		1. putIfAbsent(key, value);
 *		2. remove(key, value);
 *		3. replace(key, oldValue, newValue);
 * Output: 
 * 		{101=A, 102=E, 103=C}
 * 
 */
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapProgram_1 {

	public static void main(String[] args) {

		ConcurrentHashMap<Integer, String> chm = new ConcurrentHashMap<>();
		
		chm.put(101, "A");
		chm.put(102, "B");
		chm.putIfAbsent(103, "C");
		chm.putIfAbsent(101, "D");
		chm.remove(101, "D");
		chm.replace(102, "B", "E");
		
		System.out.println(chm);

	}

}

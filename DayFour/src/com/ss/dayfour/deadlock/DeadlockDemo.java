/**
 * 
 */
package com.ss.dayfour.deadlock;

/**
 * DeadlockDemo.java
 * Class to simulate creating a deadlock condition
 * @author Justin W Walthers
 *
 */
public class DeadlockDemo
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Resource r1 = new Resource();
		Resource r2 = new Resource();
		
		//What is a deadlock exactly?
		//Suppose there are 2 processes, A and B, and 2 resources, 1 and 2
		//Deadlock occurs when Process A has a lock on resource 1, which B is blocked waiting to access
		//Unfortunately, Process b is holding a lock on Resource 2, which Process A needs in order to finish
		//Thus, the two threads are both blocked indefinitely and can never finish
		//The two runnable objects below should simulate this by locking the same resources, but in different orders

		Thread t1 = new Thread(new DeadlockCreator(r1, r2, 1));
		Thread t2 = new Thread(new DeadlockCreator(r2, r1, 2));	
		
		t1.start();
		t2.start();

	}

}

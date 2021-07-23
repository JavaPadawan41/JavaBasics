package com.ss.jb.dayfour.singleton;

/***
 * SingletonDemo.java
 * @author Justin W Walthers
 * Simple class to demonstrate a Singleton with double checked locking
 */
public class SingletonDemo {

	//Represents the instance that will be handed to all users
	//Apparently the volatile keyword is important here
	//Because the CPU and JVM can reorder writes to memory, it's possible that an object can be given a memory address
	//before writes to its members have been completed.
	//If this happens, thread B might see that the instance is initialized (because it's not null)
	//but grabs a version with a stale state and place it into CPU cache
	//The volatile keyword prevents this from occurring by preventing out of order writes
	private volatile static SingletonDemo _instance;

	
	private SingletonDemo()
	{

	}
	
	public static SingletonDemo getInstance()
	{
		//The way that double checked locking works is that you check for null, 
		//Then synchronize, then check again for null before creating an instance
		if (!(SingletonDemo._instance == null))
		{
			synchronized (SingletonDemo.class)
			{
				if (!(SingletonDemo._instance == null))
				{
					SingletonDemo._instance = new SingletonDemo();
				}
			} 
		}
		
		return SingletonDemo._instance;
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

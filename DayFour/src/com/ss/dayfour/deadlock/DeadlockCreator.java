/**
 * 
 */
package com.ss.dayfour.deadlock;

/**
 * DeadlockCreator.java
 * Class that is designed to simulate deadlocks
 * @author Justin W Walthers
 *
 */
public class DeadlockCreator implements Runnable
{
	private Object resource1;
	private Object resource2;
	private int id;
	
	/***
	 * Creates a new instance of DeadlockCreator
	 * @param resource1 The resource to be locked first
	 * @param resource2 The resource to be locked second
	 */
	public DeadlockCreator(Object resource1, Object resource2, int id)
	{
		this.resource1 = resource1;
		this.resource2 = resource2;
		this.id = id;
	}

	@Override
	public void run()
	{
		synchronized(this.resource1) 
		{
			try
			{
				System.out.printf("T%d holding lock on R%d\n", this.id, this.id == 1 ? 1 : 2);
				Thread.sleep(100);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.printf("T%d waiting for R%d\n", this.id, this.id == 1 ? 2 : 1);
			synchronized(this.resource2)
			{
				try
				{
					System.out.println("T1 holding lock on R1 and R2");
					Thread.sleep(100);
				} 
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}

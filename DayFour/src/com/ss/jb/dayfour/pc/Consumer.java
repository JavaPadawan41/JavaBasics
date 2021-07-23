package com.ss.jb.dayfour.pc;


/***
 * Consumer.java
 * Simulates a consumer of a bounded buffer
 * @author Jay
 *
 */
public class Consumer implements Runnable
{
	private BoundedBuffer buffer;
	
	/***
	 * Creates a new instance of Consumer
	 * @param buffer The buffer from which to consume data
	 * @throws NullPointerException if buffer is null
	 */
	public Consumer(BoundedBuffer buffer)
	{
		if (buffer == null)
			throw new NullPointerException("buffer");
		
		this.buffer = buffer;
	}


	@Override
	/***
	 * Initiates the process of consuming values from the buffer until an End of File value (-1) is received
	 */
	public void run()
	{
		//We will need a sentinel value to determine when the producer has finished its work so let's go with -1 for now
		for (int value = buffer.pop(); value > -1; value = buffer.pop())
		{
			System.out.printf("Consumer got value %d\n", value);
			
			try
			{
				Thread.sleep(500);
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Consumer interrupted");
				Thread.currentThread().interrupt();
			}
		}
	}
}

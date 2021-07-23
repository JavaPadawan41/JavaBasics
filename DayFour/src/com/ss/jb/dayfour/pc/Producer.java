package com.ss.jb.dayfour.pc;

import java.util.Collection;
import java.util.List;

public class Producer implements Runnable
{
	private BoundedBuffer buffer;
	private Collection<Integer> data;
	
	/***
	 * Creates a new instance of Producer
	 * @param buffer The buffer into which to insert data
	 * @throws NullPointerException if buffer is null
	 */
	public Producer(BoundedBuffer buffer, List<Integer> data)
	{
		if (buffer == null)
			throw new NullPointerException("buffer");
		
		if (data == null)
			throw new NullPointerException("data");
		
		this.buffer = buffer;
		this.data = data;
	}


	@Override
	/***
	 * Initiates the process of consuming values from the buffer until an End of File value (-1) is received
	 */
	public void run()
	{
		//Remember that -1 is the sentinal value for end of data, so make sure that gets pushed at the end of the stream
		for (Integer value: this.data)
		{
			buffer.push(value);
			System.out.printf("Producer inserted value %d\n", value);
			
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
		
		buffer.push(-1);
	}
}

package com.ss.jb.dayfour.pc;

import java.util.ArrayDeque;

public class BoundedBuffer
{
	private ArrayDeque<Integer> internal;
	private int maxSize;
	
	/***
	 * Creates a new instance of BoundedBuffer
	 * @param size The number of elements the buffer can store
	 */
	public BoundedBuffer(int size)
	{
		internal = new ArrayDeque<Integer>(size);
		maxSize = size;
	}
	
	public synchronized void push(int a)
	{
		//If the buffer is full, then nothing can be pushed into the buffer
		while (this.internal.size() >= this.maxSize)
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				System.out.println("Push thread interrupted");
			}
		}
		
		//Once the buffer has space, push the item into the buffer and notify waiting threads
		this.internal.push(a);
		notify();
	}
	
	/***
	 * pops the item from the top of the buffer and returns it
	 * @return
	 */
	public synchronized int pop()
	{
		int value;
		
		//If the buffer is empty, data cannot be consumed, so wait until that condition changes
		while(this.internal.isEmpty())
		{
			try
			{
				wait();
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				Thread.currentThread().interrupt();
				System.out.println("Pop thread interrupted");
			}
		}
		
		//Buffer should operate in FIFO order
		value = this.internal.removeFirst();
		notify();
		
		return value;
	}
}

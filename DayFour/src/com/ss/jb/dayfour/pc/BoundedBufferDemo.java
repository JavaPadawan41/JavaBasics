/**
 * 
 */
package com.ss.jb.dayfour.pc;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * BoundedBufferDemo.java
 * Simulates a producer/consumer communicating via a buffer
 * @author Justin W Walthers
 *
 */
public class BoundedBufferDemo
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Create a BoundedBuffer with 10 values
		BoundedBuffer b = new BoundedBuffer(10);
		
		//Creates some threads for the producer and consumer and start them up
		Thread producer = new Thread(new Producer(b, IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList())));
		Thread consumer = new Thread(new Consumer(b));
		
		producer.start();
		consumer.start();

	}

}

package com.ss.jb.weekone.Singleton;
import java.sql.Connection;

public class SampleSingleton 
{

	private static Connection conn = null;
	
	//First change to make is to make the instance private, static, volatile
	private volatile static SampleSingleton instance = null;
	
	//Second change that needs to be made is a private default constructor 
	private SampleSingleton()
	{
		
	}
	
	public static SampleSingleton getInstance() 
	{
		//Third, Singletons need to implement double checked locking
		if (SampleSingleton.instance == null)
		{
			synchronized(SampleSingleton.class)
			{
				if (SampleSingleton.instance == null)
					SampleSingleton.instance = new SampleSingleton();
			}
		}
		
		return SampleSingleton.instance;
	}
	
}


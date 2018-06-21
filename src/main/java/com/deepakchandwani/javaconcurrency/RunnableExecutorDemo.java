package com.deepakchandwani.javaconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecutorDemo {
	
	public static void main(String[] args)
	{
		ExecutorService  executor = Executors.newFixedThreadPool(10);
		
		for (int i=0; i<100; i++)
		{
			executor.execute(new TestThreadRunnable(i+0));
		}
		
		executor.shutdown();
	}
	

}

class TestThreadRunnable  implements Runnable
{
	
	private int input;
	
	public TestThreadRunnable (int input )
	{
	this.input = input;	
	}
	public void run()
	{
		System.out.println(input);
	}
}

package com.deepakchandwani.javaconcurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutorDemo2 {
	
	public static void main(String[] args)
	{
		ExecutorService  executor = Executors.newFixedThreadPool(10);
		
		List< Future<Integer>> callableList= new ArrayList<Future<Integer>>();
		
		for (int i=0; i<11; i++)
		{
			Callable<Integer> worker = new TestThread(i+0);
			Future<Integer>returnValue=executor.submit(worker);
			callableList.add(returnValue);
		}
		int sum=0;
		for( Future<Integer> future : callableList)
		{
			try{
				sum+=future.get();
			} catch (Exception e) {}
			
			
		}
		System.out.println(sum);
		executor.shutdown();
		
		
	}
	

}

class TestThread  implements Callable
{
	
	private int input;
	
	public TestThread (int input )
	{
	this.input = input;	
	}
	public Integer call()
	{
		System.out.println(input);
		
		return input;
	}
	 
}

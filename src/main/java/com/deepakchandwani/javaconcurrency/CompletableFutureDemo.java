package com.deepakchandwani.javaconcurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo {
	
	static Function<Integer,CompletableFuture<String>> ft = CompletableFutureDemo::createCompletableFuture;
	
	
	public static void main (String args[]) throws InterruptedException, ExecutionException
	{
		CompletableFuture<String> cf = ft.apply(1);
		
//		System.out.println (cf.thenApply((s)->  s+" modified 2" ).get());
//		
//		createCFWithRunnable(); 
		 
		cf.runAfterBoth(ft.apply(4), 

				()-> {
					System.out.println("secondAction");
				}
				
				);
		
		waitFor(22);
				
		ft.apply(1).runAfterBothAsync(ft.apply(2), new TestThreadRunnable(4));		
			 
				;
				
				waitFor(53);
		 
		
		
		
	}

	static CompletableFuture<String> createCompletableFuture(final Integer value)
	{
		Supplier supplier = ()->{
			String value1 = value*2 + " Modified";
			System.out.println(value1);
			waitFor(1);
			return value1;
		};
		
		CompletableFuture<String> cf = CompletableFuture.supplyAsync(supplier);
		
		
		
		return cf;
	}

	private static void waitFor(int i) {
		try {				Thread.sleep(100*i); } catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	static void createCFWithRunnable()
	{
		Runnable runnable = ()-> {
			System.out.println("createCFWithRunnable");
		};
		
		CompletableFuture cfr = CompletableFuture.runAsync(runnable);
	}
}

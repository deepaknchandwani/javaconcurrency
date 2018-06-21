package com.deepakchandwani.javaconcurrency.threadlocal;

public class SimpleThreadLocalExample {

	public static void main (String args[]) throws InterruptedException
	{
		SimpleTLThread co = new SimpleTLThread();
		
		Thread t1= new Thread(co);
		Thread t2= new Thread(co);
		Thread t3= new Thread(co);
		Thread t4= new Thread(co);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();

		
	}
	
}

class SimpleTLThread implements Runnable
{
	int counter;
	
	ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	
	public void run()
	{
		counter++;

		if (tl.get()==null){
			tl.set(0);
		}
		else{
			tl.set((tl.get().intValue()+1));
		}
		
		System.out.println(counter);
		System.out.println(tl.get());
			
	}
	
	
}
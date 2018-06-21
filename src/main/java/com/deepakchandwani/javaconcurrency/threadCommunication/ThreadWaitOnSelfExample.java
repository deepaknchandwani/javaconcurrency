package com.deepakchandwani.javaconcurrency.threadCommunication;

import java.util.concurrent.TimeUnit;

public class ThreadWaitOnSelfExample {

}

class SomeThread implements Runnable
{
	public Thread t ;
	private String name;
	
	public SomeThread (String name)
	{
		this.name = name;
	}
	public void run()
	{
		try {

			for (int i = 0; i < 5; i++) {
				System.out.println("Thread  " + name + " loop " +i);
				TimeUnit.SECONDS.sleep(1);
				
			}
		} catch (InterruptedException e) {
			System.out.println("Thread InterruptedException " + name );
		}
		
		System.out.println("Thread InterruptedException and exiting" + name );

	}
	
	public void start(){
		
		System.out.println("Starting Thread " + name );

		if (t==null){
		t = new Thread (new SomeThread(name));
		t.start();}
	}
	
	public static void main (String args[])
	{
		SomeThread s1 = new SomeThread("SomeThreadOne");
		s1.start();
		SomeThread s2 = new SomeThread("SomeThreadTwo");
		s2.start();
	}
}

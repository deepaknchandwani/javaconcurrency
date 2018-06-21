package com.deepakchandwani.javaconcurrency.selfSuspendAndResume;

public class SelfSuspendAndResume {

}

class SomeThread implements Runnable
{
	Thread t;
	String name;
	boolean suspended=false;
	
	
	
	public  SomeThread (String name)
	{
		this.name = name;
		
	}
	
	public void run()
	{
		try
		{
			for (int i=0;i<10 ; i++)
			{
				System.out.println("Thread " +  name + " Loop" +i);
				Thread.sleep(300);
				
				synchronized (this )
				{
					
					while(suspended)
					{
						System.out.println("Thread " +  name + " Suspended.");
						wait();
					}
					
				}
				
			}
		}
		catch (InterruptedException e)
		{
			
			 System.out.println("Thread " +  name + " interrupted.");
	      }
	      System.out.println("Thread " +  name + " exiting.");
	}
	
	public void suspended()
	{
		suspended=true;
	}
	
	 public void resume()
	{
		 synchronized (this )
			{
		suspended=false;
		notify();}
	}
	
	public void start()
	{
		t= new Thread(this, name);
		t.start();
	}
	
	public static void main ( String args []) throws Exception
	{
		SomeThread s1 = new SomeThread ("SomeThread");
		s1.start();
		 
		Thread.sleep(800);
		
		s1.suspended();
		Thread.sleep(800);
		
		s1.resume();
		
	}
}

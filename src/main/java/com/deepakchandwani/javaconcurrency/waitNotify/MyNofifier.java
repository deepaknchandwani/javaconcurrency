package com.deepakchandwani.javaconcurrency.waitNotify;

class MyObjectLock{}

public  class MyNofifier {

	MyObjectLock myLock = new MyObjectLock();
	
	public void doWait()
	{
		synchronized(myLock)
		{
			try {myLock.wait();}catch (InterruptedException e) {}
		}
		
	}
	
	public void doNotify()
	{
		synchronized(myLock)
		{
			 myLock.notify(); 

		}
	}
	
}

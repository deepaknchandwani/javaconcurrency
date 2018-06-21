package com.deepakchandwani.javaconcurrency.waitNotify;

class MyObjectLockModifiedToProtectSpuriousWakeUps_UsingWhileLoop{}

public class MyNofifierModifiedToProtectSpuriousWakeUps_UsingWhileLoop {

	MyObjectLockModifiedToProtectSpuriousWakeUps_UsingWhileLoop myLock = new MyObjectLockModifiedToProtectSpuriousWakeUps_UsingWhileLoop();
	boolean wasSignalled=false;
	
	public void doWait()
	{
		synchronized(myLock)
		{
			
			// replaced if with a while
			// as if it wakes up for some xyz reason wasSignalled is still false
			while (!wasSignalled){
			
				try {myLock.wait();}catch (InterruptedException e) {}
				
			}
			wasSignalled=true;
		}
		
	}
	
	public void doNotify()
	{
		synchronized(myLock)
		{
			wasSignalled=true;
			 myLock.notify(); 

		}
	}
	
}

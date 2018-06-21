package com.deepakchandwani.javaconcurrency.waitNotify;

class MyObjectLockModifiedToAvoidMissedNotifications{}

public class MyNofifierModifiedToAvoidMissedNotifications {

	MyObjectLockModifiedToAvoidMissedNotifications myLock = new MyObjectLockModifiedToAvoidMissedNotifications();
	boolean wasSignalled=false;
	
	public void doWait()
	{
		synchronized(myLock)
		{
			if (!wasSignalled){
			
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

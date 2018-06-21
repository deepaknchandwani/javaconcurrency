package com.deepakchandwani.javaconcurrency.interthreadcommunication;

public class InterthreadCommunicationDemo {

	
	public static void main(String [] args)
	{
		CommonObject co = new CommonObject();
		Thread t1 = new Thread(new qR(co));
		
		Thread t2 = new Thread(new aR(co));
		
		t1.start();
		t2.start();
	}
}

class CommonObject
{
	boolean flag = false;
	public  synchronized void question (String msg)
	{
		if (flag)
		{
			try{
				
				wait();
			}
			
			catch(InterruptedException e){
				
				System.out.println("InterruptedException");

				
			}
			
			
		}
		System.out.println(msg);
		flag=true;
		notify();
	}
	
	public  synchronized void answer (String msg)
	{
		if (!flag)
		{
try{
				
				wait();
			}
			
			catch(InterruptedException e){
				
				System.out.println("InterruptedException");

			}
		}
		
		System.out.println(msg);
		flag=false;
		notify();

	}
}


class qR implements Runnable
{
	CommonObject co;
 public qR(CommonObject co)
 {
	this.co=co;
 }

	String [] s1 = {"q1","q2"};
	public void run()
	{
		for (int i=0; i< s1.length; i++) co.question(s1[i]);
	}
}

class aR implements Runnable
{
	CommonObject co;
 public aR(CommonObject co)
 {
	this.co=co;
 }

	String [] s1 = {"a1","a2"};
	public void run()
	{
		for (int i=0; i< s1.length; i++) co.answer(s1[i]);
	}
}

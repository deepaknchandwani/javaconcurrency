package com.deepakchandwani.javaconcurrency;

public class BasicThreadDemo {
	
	public static void main ( String[] args)
	{
		startDemoCorrect();
		runDemoWhichIsCorrectButNoThreadsareSpaned();
		/*int j=0;
		for (int i = 0; i < 100; i++) {
			j = j + 0x61c88647;
			System.out.println(j);
		}
*/
	}

	private static void startDemoCorrect() {
		System.out.println("Main Thread Id "+Thread.currentThread().getId());

		Thread t1 = new SimpleThread("SimpleThread");
		t1.start();
		
		Thread t2 = new Thread
		(
				new SimpleRunnableThread(),
				"SimpleRunnableThread"
		)
			;
		
		t2.start();
		try{
			t1.join();
			t2.join();} catch(Exception e){}
		
		System.out.println("Main Thread Id "+Thread.currentThread().getId());
	}
	
	private static void runDemoWhichIsCorrectButNoThreadsareSpaned() {
		System.out.println("Main Thread Id "+Thread.currentThread().getId());

		Thread t1 = new SimpleThread("SimpleThread");
		t1.run();
		
		Thread t2 = new Thread
		(
				new SimpleRunnableThread(),
				"SimpleRunnableThread"
		)
			;
		
		t2.run();
		try{
			t1.join();
			t2.join();} catch(Exception e){}
		
		System.out.println("Main Thread Id "+Thread.currentThread().getId());
	}
	
	
}

class SimpleThread extends Thread
{
	public SimpleThread(String name)
	{
		super(name);
	}
	public void run()
	{
		long id = Thread.currentThread().getId();
		System.out.println("BasicThreadDemo spaning SimpleThread Thread id " + id  );
		System.out.println("BasicThreadDemo spaning SimpleThread Thread Name " +Thread.currentThread().getName() );
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		
	}
}

class SimpleRunnableThread implements Runnable
{
	public void run() throws RuntimeException
	{
		long id = Thread.currentThread().getId();
		System.out.println("BasicThreadDemo spaning SimpleRunnableThread Thread id " + id  ); 
		System.out.println("BasicThreadDemo spaning SimpleRunnableThread Thread Name " +Thread.currentThread().getName() );

		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
}

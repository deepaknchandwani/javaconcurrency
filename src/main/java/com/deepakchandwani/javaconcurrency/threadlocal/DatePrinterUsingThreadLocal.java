package com.deepakchandwani.javaconcurrency.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatePrinterUsingThreadLocal implements Runnable
{
	private String name;
	
	public DatePrinterUsingThreadLocal(String name) {
		this.name = name;
	}
	
	public void run() {
		if (name.equals("Formatter 1")) {
			System.out.println(name + " is setting the formatting pattern");
			DateFormatterExampleThreadLocal.dateFormatterVar.get().applyPattern("hh:mm:ss");
		}
		
		while (true) {
			try
			{
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e)
			{
				// Can ignore
			}
			
			Date now = new Date();
			
			System.out.println(name + ": " + DateFormatterExampleThreadLocal.dateFormatterVar.get().format(now));
		}
	}
}

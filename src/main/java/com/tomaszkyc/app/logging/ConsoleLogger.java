package com.tomaszkyc.app.logging;

public class ConsoleLogger implements Logger {

	public void debug(String msg) {
		
		System.out.println("INFO: " + msg);
		
	}

	public void error(String msg, Exception e) {
		
		System.err.println("ERROR: " + msg + ";" + e);
		
	}
	
	
	
}

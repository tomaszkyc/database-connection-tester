package com.tomaszkyc.app.logging;

public interface Logger {
	
	public void info(String msg);
	
	public void debug(String msg);
	
	public void error(String msg, Exception e);
	
	public void print(String msg);
}

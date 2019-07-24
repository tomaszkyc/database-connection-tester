package com.tomaszkyc.app.logging;

public interface Logger {
	
	public void debug(String msg);
	
	public void error(String msg, Exception e);
}

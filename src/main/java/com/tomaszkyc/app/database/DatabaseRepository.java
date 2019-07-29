package com.tomaszkyc.app.database;

import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class DatabaseRepository {

	private static Logger log = new ConsoleLogger();

	private DatabaseConfig config;

	public DatabaseConfig getConfig() {
		return config;
	}

	public void setConfig(DatabaseConfig config) {
		this.config = config;
	}

	public DatabaseRepository(DatabaseConfig config) {
		this.config = config;
	}
	
	public boolean canConnect() { 
		//TODO: do implementacji
		return true;
	}
	

}

package com.tomaszkyc.app.database;

public interface DatabaseConfig {
	
	public String getTestQuery();

	public String getDriverName();
	
	public String getUrl();

	public String getUsername();

	public String getPassword();

}

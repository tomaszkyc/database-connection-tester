package com.tomaszkyc.app.database;

import java.util.Properties;

public class FileDatabaseConfig implements DatabaseConfig {

	private Properties properties;

	public FileDatabaseConfig(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return properties.getProperty("url");
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return properties.getProperty("username");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return properties.getProperty("password");
	}

	@Override
	public String getDriverName() {
		// TODO Auto-generated method stub
		return properties.getProperty("drivername");
	}

	@Override
	public String getTestQuery() {
		// TODO Auto-generated method stub
		return properties.getProperty("testquery");
	}

}

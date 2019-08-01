package com.tomaszkyc.app.config;

import java.util.Properties;

public class DatabaseConfigImpl implements DatabaseConfig {

	private Properties properties;

	public DatabaseConfigImpl(Properties properties) {
		super();
		this.properties = properties;
	}

	public Properties getProperties() {
		return this.properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public void setUrl(String url) {
		this.properties.setProperty("url", url);
	}

	@Override
	public void setDrivername(String drivername) {
		this.properties.setProperty("drivername", drivername);
	}

	@Override
	public void setUsername(String username) {
		this.properties.setProperty("username", username);
	}

	@Override
	public void setPassword(String password) {
		this.properties.setProperty("password", password);
	}

	@Override
	public void setTestquery(String testquery) {
		this.properties.setProperty("testquery", testquery);
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return this.properties.getProperty("url");
	}

	@Override
	public String getDrivername() {
		// TODO Auto-generated method stub
		return this.properties.getProperty("drivername");
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.properties.getProperty("username");
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.properties.getProperty("password");
	}

	@Override
	public String getTestQuery() {
		// TODO Auto-generated method stub
		return this.properties.getProperty("testquery");
	}

}

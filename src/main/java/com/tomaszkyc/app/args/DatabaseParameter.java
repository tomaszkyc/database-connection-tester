package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class DatabaseParameter implements ArgParameter {

	@Parameter(names = { "-dbtype", "-t" }, description = "Database type (ex. mssql, mysql, oracle)", required = true)
	private String databaseType;

	@Parameter(names = { "-host", "-h" }, description = "Database hostname (DNS or IP address)", required = true)
	private String databaseHostname;

	@Parameter(names = { "-port" }, description = "Database port (ex. 3306 for mssql)", required = true)
	private String databasePort;

	@Parameter(names = { "-name", "-n" }, description = "Database name (ex. mySimpleDatabase)", required = true)
	private String databaseName;

	public DatabaseParameter() {
		super();
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getDatabaseHostname() {
		return databaseHostname;
	}

	public String getDatabasePort() {
		return databasePort;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	@Override
	public ArgParameter getParameter() {
		// TODO Auto-generated method stub
		return this;
	}

}

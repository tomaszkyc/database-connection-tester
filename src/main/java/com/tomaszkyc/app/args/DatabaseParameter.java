package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class DatabaseParameter implements ArgParameter {

	@Parameter(names = { "-dbtype", "-t" }, description = "Database type (ex. mssql, mysql, oracle)")
	private String databaseType;

	@Parameter(names = { "-host", "-h" }, description = "Database hostname (DNS or IP address)")
	private String databaseHostname;

	@Parameter(names = { "-port" }, description = "Database port (ex. 3306 for mssql)")
	private String databasePort;

	@Parameter(names = { "-name", "-n" }, description = "Database name (ex. mySimpleDatabase)")
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

	@Override
	public ArgType getArgType() {
		// TODO Auto-generated method stub
		return ArgType.DATABASE_PARAM;
	}

}

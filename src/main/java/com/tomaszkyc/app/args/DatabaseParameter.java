package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class DatabaseParameter implements ArgParameter {

	@Parameter(names = { "-dbtype", "-t" }, description = "Database type (ex. mssql, mysql, oracle)")
	private String databaseType;

	@Parameter(names = { "-host", "-h" }, description = "Database hostname (DNS or IP address)")
	private String databaseHostname;

	@Parameter(names = { "-port", "-p" }, description = "Database port (ex. 3306 for mssql)")
	private String databasePort;

	public DatabaseParameter() {
		super();
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

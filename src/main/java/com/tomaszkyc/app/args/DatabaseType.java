package com.tomaszkyc.app.args;

public enum DatabaseType {

	MSSQL("mssql"), 
	ORACLE("oracle"), 
	MYSQL("mysql");

	public String databaseName;

	DatabaseType(String databaseName) {

		this.databaseName = databaseName;

	}
	

}

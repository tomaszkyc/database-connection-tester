package com.tomaszkyc.app.args;

public enum DatabaseType {



	MSSQL("mssql"), 
	ORACLE("oracle"), 
	MYSQL("mysql");

	public String databaseName;

	public String getDatabaseName() {
		return this.databaseName;
	}

	DatabaseType(String databaseName) {

		this.databaseName = databaseName;

	}

	public static DatabaseType parse(String name) {

		if ( name.trim().toLowerCase().equals( DatabaseType.MYSQL.getDatabaseName() ) ) {
			return DatabaseType.MYSQL;
		}
		else if ( name.trim().toLowerCase().equals( DatabaseType.MSSQL.getDatabaseName() ) ) {
			return DatabaseType.MSSQL;
		}
		else if ( name.trim().toLowerCase().equals( DatabaseType.ORACLE.getDatabaseName() ) ) {
			return DatabaseType.ORACLE;
		}
		else {
			return null;
		}
	}
	

}

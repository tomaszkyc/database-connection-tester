package com.tomaszkyc.app.config;

public interface DatabaseConfig {

	void setUrl( String url );

	void setDrivername( String drivername );

	void setUsername( String username );

	void setPassword( String password );

	void setTestquery( String testquery );
	void setDatabaseType( String databaseType );

	String getDatabaseType();

	String getUrl();

	String getDrivername();

	String getUsername();

	String getPassword();
	
	String getTestQuery();

}

package com.tomaszkyc.app.database;

import java.util.Properties;

import com.tomaszkyc.app.args.DatabaseType;

public class DatabaseService {

	private Properties databaseConfig;
	
	private DatabaseConfigExtractor configExtractor;
	
	private DatabaseType databaseType;
	
	public DatabaseService(DatabaseConfigExtractor configExtractor, DatabaseType databaseType) { 
		this.databaseType = databaseType;
		this.configExtractor = configExtractor;
	}
	
	private void extractConfig() throws Exception { 
		
		this.databaseConfig = this.configExtractor.extractConfigForDatabaseType(databaseType);
		
	}
	
	public boolean testConnection() throws Exception { 
		
		boolean canConnectToDatabase = false;
		
		
		extractConfig();
		
		
		
		
		return canConnectToDatabase;
	}
	
	
	
	
	
}

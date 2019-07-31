package com.tomaszkyc.app.config;

import java.util.List;
import java.util.Properties;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.DatabaseType;

public class DatabaseConfigFactory {

	public static DatabaseConfig build(DatabaseType type, PropertiesLoader loader, List<ArgParameter> inputParameters) throws Exception { 
		
		//load properties about db
		Properties propertiesFromLoader = loader.load();
		
		DatabaseConfig databaseConfig = DatabaseConfigExtractor.
												extractFromProperties(propertiesFromLoader, databaseType);
		
		//Properties propertiesFromExtraction = 
		
		
		
		return null;
	}
	
	
}

package com.tomaszkyc.app.config;

import java.util.Properties;

import com.tomaszkyc.app.args.DatabaseType;

public class DatabaseConfigExtractor {

	public static DatabaseConfig extractFromProperties( Properties properties
													  , DatabaseType databaseType ) { 
		
		Properties propertiesForExactDatabase = new Properties( properties );
		
		String dbPrefix = databaseType.name().toLowerCase();
		
		//get info about driver
		propertiesForExactDatabase.setProperty("drivername", properties.getProperty( dbPrefix + ".drivername" ));
		propertiesForExactDatabase.setProperty("url", properties.getProperty( dbPrefix + ".drivername" ));
		propertiesForExactDatabase.setProperty("testquery", properties.getProperty( dbPrefix + ".drivername" ));
		
		
		return new DatabaseConfigImpl(propertiesForExactDatabase);
	}
	
	
}

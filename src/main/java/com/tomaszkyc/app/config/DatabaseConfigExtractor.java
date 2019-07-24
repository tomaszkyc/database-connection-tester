package com.tomaszkyc.app.config;

import com.tomaszkyc.app.args.DatabaseType;

import java.util.Properties;

public class DatabaseConfigExtractor {

	public static DatabaseConfig extractFromProperties( Properties properties
													  , DatabaseType databaseType ) {

		String dbPrefix = databaseType.getDatabaseName().toLowerCase();

		Properties propertiesForExactDatabase = new Properties( properties );
		propertiesForExactDatabase.setProperty("databasetype", databaseType.name().toLowerCase());
		propertiesForExactDatabase.setProperty("drivername", properties.getProperty( dbPrefix + ".drivername" ));
		propertiesForExactDatabase.setProperty("url", properties.getProperty( dbPrefix + ".url" ));
		propertiesForExactDatabase.setProperty("testquery", properties.getProperty( dbPrefix + ".testquery" ));
		
		return new DatabaseConfigImpl(propertiesForExactDatabase);
	}
	
	
}

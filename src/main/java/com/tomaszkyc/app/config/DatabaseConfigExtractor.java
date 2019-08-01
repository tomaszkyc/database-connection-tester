package com.tomaszkyc.app.config;

import java.util.Properties;

import com.tomaszkyc.app.args.DatabaseType;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class DatabaseConfigExtractor {

	private static Logger log = new ConsoleLogger();

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

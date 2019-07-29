package com.tomaszkyc.app.database;

import java.util.Properties;

import com.tomaszkyc.app.args.DatabaseType;

public interface DatabaseConfigExtractor {

	public Properties extractConfigForDatabaseType(DatabaseType databaseType) throws Exception;
	
}

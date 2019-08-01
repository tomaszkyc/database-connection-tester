package com.tomaszkyc.app.config;

import java.util.List;
import java.util.Properties;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgType;
import com.tomaszkyc.app.args.DatabaseParameter;
import com.tomaszkyc.app.args.DatabaseType;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

import static com.tomaszkyc.app.config.DatabaseConfigJoiner.getArgByType;

public class DatabaseConfigFactory {

	private static Logger log = new ConsoleLogger();

	public static DatabaseConfig build(PropertiesLoader loader, List<ArgParameter> inputParameters) throws Exception {

		log.debug("Started building database config.");
		//load properties about db
		Properties propertiesFromLoader = loader.load();

		//get database parameters from input
		DatabaseParameter databaseParameter = (DatabaseParameter) getArgByType(inputParameters, ArgType.DATABASE_PARAM);

		DatabaseConfig baseConfig;
		DatabaseType databaseType = DatabaseType.parse(databaseParameter.getDatabaseType());
		baseConfig = DatabaseConfigExtractor.extractFromProperties(propertiesFromLoader, databaseType);

		//join base config and input arguments
		DatabaseConfigJoiner.join( baseConfig, inputParameters );


		//return results
		log.debug("Finished building database config with success.");
		return baseConfig;
	}
	
	
}

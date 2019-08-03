package com.tomaszkyc.app.config;

import com.tomaszkyc.app.args.*;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.util.List;
import java.util.Properties;

import static com.tomaszkyc.app.config.DatabaseConfigJoiner.getArgByType;

public class DatabaseConfigFactory {

	private static Logger log;

	public static DatabaseConfig build(PropertiesLoader loader, List<ArgParameter> inputParameters) throws Exception {

		log = LoggerFactory.getLogger(InformationParameter.isDebug( inputParameters ));

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

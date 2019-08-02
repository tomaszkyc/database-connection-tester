package com.tomaszkyc.app.main;

import java.net.URISyntaxException;
import java.sql.Connection;

import com.beust.jcommander.JCommander;
import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgParameterSerializer;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.args.validator.ValidatorService;
import com.tomaszkyc.app.builder.AppBuilder;
import com.tomaszkyc.app.config.DatabaseConfig;
import com.tomaszkyc.app.config.DatabaseConfigFactory;
import com.tomaszkyc.app.config.FilePropertiesLoader;
import com.tomaszkyc.app.config.PropertiesLoader;
import com.tomaszkyc.app.database.ConnectionFactory;
import com.tomaszkyc.app.database.ConnectionTester;
import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class AppRunner {

	private static Logger log = new ConsoleLogger();

	private String[] inputArgs;

	private AppBuilder appBuilder;
	
	private ValidatorService validatorService;

	private JCommander jcommander;

	private FileRepository fileRepository;

	private InformationService informationService;

	public AppRunner(String[] inputArgs) {
		
		this.fileRepository = new FileRepository();
		this.inputArgs = inputArgs;
		this.informationService = new InformationService(fileRepository);
		this.appBuilder = new AppBuilder();
	}

	public void run() throws Exception {
		
		informationService.showStartupMessage();
		jcommander = appBuilder.build();
		setProgramName(jcommander);
		jcommander.parseWithoutValidation(inputArgs);
		
		//for tests only
		appBuilder.getParameters().forEach(parameter -> {

			log.debug(ArgParameterSerializer.serialize(parameter));

		});
		


		// checking if should show usage message
		if ( shouldShowUsageMessage() ) { 
			jcommander.usage();
			return;
		}
		
		//in this place we need to validate input args
		validatorService = new ValidatorService(appBuilder.getParameters());
		validatorService.validate();

		log.debug("Before database config build");

		//load properties
		PropertiesLoader propertiesLoader = new FilePropertiesLoader(this.fileRepository);
		DatabaseConfig databaseConfig = DatabaseConfigFactory.build( propertiesLoader, appBuilder.getParameters() );

		log.debug("database config after build: " + databaseConfig.toString());

		//connection to database
		Connection connection = ConnectionFactory.build( databaseConfig );
		ConnectionTester.test( connection, databaseConfig );

		log.debug("Finished testing connection");

	}
	
	private boolean shouldShowUsageMessage() { 
		
		boolean shouldShowUsageMessage = false;
		
		//for no input arguments given
		if ( inputArgs.length == 0 ) { 
			return true;
		}
		
		for(ArgParameter parameter : appBuilder.getParameters()) { 
			
			if ( parameter instanceof InformationParameter ) { 
				
				InformationParameter infoParameter = (InformationParameter) parameter;
				shouldShowUsageMessage = infoParameter.isHelpRequired();
				break;
			}
		}

		return shouldShowUsageMessage;
	}
	
	public void setProgramName(JCommander jcommander) throws URISyntaxException { 
		
		String programName = informationService.getProgramName();
		jcommander.setProgramName( programName );
		
	}
	

}

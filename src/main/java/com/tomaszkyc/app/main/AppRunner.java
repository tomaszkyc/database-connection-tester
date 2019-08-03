package com.tomaszkyc.app.main;

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
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;
import com.tomaszkyc.app.logging.ProgressBar;

import java.net.URISyntaxException;
import java.sql.Connection;

public class AppRunner {

	private static final String PROGRESS_BAR_INFO = "Database connection test";

	private Logger log;

	private String[] inputArgs;

	private AppBuilder appBuilder;
	
	private ValidatorService validatorService;

	private JCommander jcommander;

	private ProgressBar progressBar = new ProgressBar(100);


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

		//init logger
		log = LoggerFactory.getLogger( InformationParameter.isDebug( appBuilder.getParameters() ) );
		//for tests only
		appBuilder.getParameters().forEach(parameter -> {

			log.debug(ArgParameterSerializer.serialize(parameter));

		});



		// checking if should show usage message
		if ( shouldShowUsageMessage() ) { 
			jcommander.usage();
			return;
		}




		progressBar.update(0);
		//in this place we need to validate input args
		validatorService = new ValidatorService(appBuilder.getParameters());
		validatorService.validate();


		log.debug("Before database config build");

		//load properties
		PropertiesLoader propertiesLoader = new FilePropertiesLoader(this.fileRepository, appBuilder.getParameters());
		progressBar.update(25);
		DatabaseConfig databaseConfig = DatabaseConfigFactory.build( propertiesLoader, appBuilder.getParameters() );
		progressBar.update(50);
		log.debug("database config after build: " + databaseConfig.toString());
		//connection to database
		Connection connection = ConnectionFactory.build( databaseConfig, appBuilder.getParameters());
		progressBar.update(75);
		boolean isConnectionToDb = ConnectionTester.test( connection, databaseConfig , appBuilder.getParameters());
		progressBar.update(100);
		log.info("Finished testing connection. Can connect to database? " + String.valueOf( isConnectionToDb ));

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

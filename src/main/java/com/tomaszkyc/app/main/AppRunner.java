package com.tomaszkyc.app.main;

import java.net.URISyntaxException;

import com.beust.jcommander.JCommander;
import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgParameterSerializer;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.args.validator.ValidatorService;
import com.tomaszkyc.app.builder.AppBuilder;
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
		
		log.debug("Before validation");
		//in this place we need to validate input args
		validatorService = new ValidatorService(appBuilder.getParameters());
		validatorService.validate();
		
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

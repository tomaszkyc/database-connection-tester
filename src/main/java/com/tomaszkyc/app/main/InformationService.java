package com.tomaszkyc.app.main;

import java.net.URISyntaxException;

import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class InformationService {
	
	public static final String APP_NAME = "database-connection-tester.jar";

	private static Logger log = new ConsoleLogger();
	
	private FileRepository fileRepository;

	public InformationService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	
	void showStartupMessage() { 
		
		String startupMessage = fileRepository.getTextFromResourceFile("/ascii_logo.txt");
		log.print(startupMessage);
		
		
	}
	
	public String getProgramName() throws URISyntaxException { 
		
		
		return APP_NAME;
	}
	
	
	
	
	
}

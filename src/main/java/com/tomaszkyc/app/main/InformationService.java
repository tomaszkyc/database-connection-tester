package com.tomaszkyc.app.main;

import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.net.URISyntaxException;

public class InformationService {
	
	public static final String APP_NAME = "database-connection-tester.jar";

	private static Logger log = LoggerFactory.getLogger(true);
	
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

package com.tomaszkyc.app.config;

import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class FilePropertiesLoader implements PropertiesLoader {
	
	private static Logger log = new ConsoleLogger();

	private Properties properties;
	
	private static final String PROPERTIES_FILENAME = "app_properties.xml";
	
	private FileRepository fileRepository;
	
	
	public FilePropertiesLoader( FileRepository fileRepository ) { 
		this.fileRepository = fileRepository;
	}
	
	@Override
	public Properties load() throws Exception {
		
		log.debug("Started loading resources from file: " + PROPERTIES_FILENAME);
		
		this.properties = new Properties();
		this.properties.loadFromXML( fileRepository.getResourceInputStream(PROPERTIES_FILENAME) );
		
		log.debug("Properties loaded successfully!");
		return this.properties;
	}
	
	

}

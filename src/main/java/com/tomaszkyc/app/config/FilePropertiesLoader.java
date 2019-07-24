package com.tomaszkyc.app.config;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.util.List;
import java.util.Properties;

public class FilePropertiesLoader implements PropertiesLoader {
	
	private static Logger log;

	private Properties properties;
	
	private static final String PROPERTIES_FILENAME = "/app_properties.xml";
	
	private FileRepository fileRepository;
	
	
	public FilePropertiesLoader(FileRepository fileRepository, List<ArgParameter> parameters) throws Exception {
		this.fileRepository = fileRepository;
		log = LoggerFactory.getLogger(InformationParameter.isDebug( parameters ));
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

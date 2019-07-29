package com.tomaszkyc.app.database;

import java.io.FileInputStream;
import java.util.Properties;

import com.tomaszkyc.app.args.DatabaseType;
import com.tomaszkyc.app.files.FileRepository;

public class FileDatabaseConfigExtractor implements DatabaseConfigExtractor {

	private String configFilename;
	private FileRepository fileRepository;
	
	public FileDatabaseConfigExtractor(FileRepository fileRepository, String configFilename) { 
		this.configFilename = configFilename;
		this.fileRepository = fileRepository;
	}
	
	@Override
	public Properties extractConfigForDatabaseType(DatabaseType databaseType) throws Exception {
		// TODO Auto-generated method stub
		String rootPath = this.fileRepository.getMainResourcePath();
		String configFullPath = rootPath + this.configFilename;
		Properties config = new Properties();
		config.loadFromXML(new FileInputStream(configFullPath));
		return config;
	}

}

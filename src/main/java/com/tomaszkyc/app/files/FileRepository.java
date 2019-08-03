package com.tomaszkyc.app.files;

import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;
import com.tomaszkyc.app.main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileRepository {

	private static Logger log = LoggerFactory.getLogger(true);
	
	public String getMainResourcePath() { 
		return Thread.currentThread().getContextClassLoader().getResource("").getPath();
	}
	
	public InputStream getResourceInputStream(String resourceName) { 

		InputStream inputStream = null;
		try {
			inputStream = Main.class.getResourceAsStream(resourceName);


		}
		catch( Exception exception ) {
			log.error("getResourceInputStream: Error on getting input stream for resource: "
							+ resourceName, exception);
		}
		return inputStream;
	}

	public String getTextFromResourceFile(String resourceName) {

		StringBuilder textFromFile = new StringBuilder();

		String line = null;
		try (
			 InputStream input = Main.class.getResourceAsStream(resourceName);
			 BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			) {
			while ((line = reader.readLine()) != null) {

				textFromFile.append(line);
				textFromFile.append(System.lineSeparator());

			}
		} catch (IOException e) {
			log.error("Error on reading resource: " + resourceName, e);
		}

		return textFromFile.toString();
	}

}

package com.tomaszkyc.app.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.main.Main;

public class FileRepository {

	private static Logger log = new ConsoleLogger();

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

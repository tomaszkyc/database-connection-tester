package com.tomaszkyc.app.main;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class Main {

	@Parameter(names = "-password", description = "Connection password", password = true, echoInput = false)
	private String password;

	private static Logger log;
	
	private FileRepository fileRepository;

	public static void main(String[] args) throws IOException {

		Main main = new Main();

		JCommander.newBuilder().addObject(main).build().parse(args);

		log = new ConsoleLogger();

		main.run();
	}

	public void run() {
	
		this.fileRepository = new FileRepository();
		String text = this.fileRepository.getTextFromResourceFile("/ascii_logo.txt");
	
		log.debug(text);
	}

}

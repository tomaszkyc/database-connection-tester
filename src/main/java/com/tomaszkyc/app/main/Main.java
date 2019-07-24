package com.tomaszkyc.app.main;

import java.io.IOException;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.JCommander.Builder;
import com.beust.jcommander.Parameter;
import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgParameterFactory;
import com.tomaszkyc.app.files.FileRepository;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class Main {

	@Parameter(names = "-password", description = "Connection password", password = true, echoInput = false)
	private String password;

	private static Logger log = new ConsoleLogger();
	
	private static FileRepository fileRepository = new FileRepository();

	public static void main(String[] args) throws IOException {

		Builder builder = JCommander.newBuilder();
		buildParameterList( builder );
		
		JCommander jcommander = builder.build();
		jcommander.usage();
		jcommander.parse(args);
		run();
	}
	
	public static void buildParameterList(Builder builder) { 
		
		List<ArgParameter> parameters = ArgParameterFactory.create();
		parameters.forEach( parameter -> {
			builder.addObject( parameter );
		});
		
	}

	public static void run() {
		String text = fileRepository.getTextFromResourceFile("/ascii_logo.txt");
	
		System.out.println(text);
	}

}

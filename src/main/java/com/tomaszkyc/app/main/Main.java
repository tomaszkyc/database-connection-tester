package com.tomaszkyc.app.main;

import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class Main {

	private static Logger log = new ConsoleLogger();
	


	public static void main(String[] args) {


		try {
			AppRunner appRunner = new AppRunner( args );
			appRunner.run();
			
		}
		catch( Exception exception) { 
			log.error("There was ann error during app running", exception);
		}
		
		

		
	}
}

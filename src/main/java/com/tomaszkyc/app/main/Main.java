package com.tomaszkyc.app.main;

import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

public class Main {

	private static Logger log = LoggerFactory.getLogger(true);
	


	public static void main(String[] args) {


		try {
			AppRunner appRunner = new AppRunner( args );
			appRunner.run();

			System.exit(0); //on success return to the system 0
		}
		catch( Exception exception) { 
			log.error("There was ann error during app running", exception);
			exception.printStackTrace();
			System.exit(-1); //on fail return to the system -1
		}
		
		

		
	}
}

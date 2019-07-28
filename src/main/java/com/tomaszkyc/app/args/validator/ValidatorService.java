package com.tomaszkyc.app.args.validator;

import java.util.List;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class ValidatorService {

	private static Logger log = new ConsoleLogger();

	private List<ArgParameter> parameters;

	public ValidatorService(List<ArgParameter> parameters) {
		this.parameters = parameters;
	}
	
	
	public void validate() { 
		//TODO: do dokończenia walidator
		
		
	}

}

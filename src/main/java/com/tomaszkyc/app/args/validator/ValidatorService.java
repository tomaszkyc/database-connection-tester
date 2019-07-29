package com.tomaszkyc.app.args.validator;

import java.util.Arrays;
import java.util.List;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgType;
import com.tomaszkyc.app.args.DatabaseType;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class ValidatorService {

	private static Logger log = new ConsoleLogger();

	private List<ArgParameter> parameters;

	public ValidatorService(List<ArgParameter> parameters) {
		this.parameters = parameters;
	}
	
	
	public void validate() throws Exception { 

		log.debug("Starting validation of input arguments...");
		for(ArgParameter parameter : parameters) { 
			
			ArgType parameterType = parameter.getArgType();
			
			ParameterValidator validator = ParameterValidatorFactory.create(parameterType);
			
			boolean isValidParameter = validator.validate(parameter);
			
			if ( !isValidParameter ) { 
				
				throw new Exception( validator.getErrorMessage() );
				
			}
			

			
		}
		
		log.debug("Input arguments validation finished successfully.");
	}

}

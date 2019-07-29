package com.tomaszkyc.app.args.validator;

import java.util.List;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgType;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

public class ValidatorService {

	private static Logger log = new ConsoleLogger();

	private List<ArgParameter> parameters;

	public ValidatorService(List<ArgParameter> parameters) {
		this.parameters = parameters;
	}
	
	
	public void validate() throws Exception { 
		
		
		for(ArgParameter parameter : parameters) { 
			
			ArgType parameterType = parameter.getArgType();
			
			ParameterValidator<ArgParameter> validator = ParameterValidatorFactory.create(parameterType);
			
			log.debug("is validator null: " + String.valueOf(validator == null));
			
			boolean isValidParameter = validator.validate(parameter);
			
			log.debug("Status after validation: " + String.valueOf(isValidParameter));
			
			if ( !isValidParameter ) { 
				
				throw new Exception( validator.getErrorMessage() );
				
			}
			
		}
		
		
	}

}

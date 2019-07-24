package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.ArgType;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.util.List;

public class ValidatorService {

	private Logger log;

	private List<ArgParameter> parameters;

	public ValidatorService(List<ArgParameter> parameters) throws Exception {

		this.parameters = parameters;
		this.log = LoggerFactory.getLogger(InformationParameter.isDebug( parameters ));
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

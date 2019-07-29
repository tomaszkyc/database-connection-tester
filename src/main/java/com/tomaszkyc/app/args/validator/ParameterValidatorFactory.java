package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgType;

public class ParameterValidatorFactory {

	public static ParameterValidator create(ArgType argType) { 
		
		if ( argType.equals(ArgType.AUTH_PARAM) ) { 
			return new AuthParameterValidator();
		}
		else if ( argType.equals(ArgType.DATABASE_PARAM) ) { 
			return new DatabaseParameterValidator();
		}
		else if ( argType.equals(ArgType.INFORMATION_PARAM) ) { 
			return new InformationParameterValidator();
		}
		else { 
			throw new IllegalArgumentException("Not implemented for argument type: " + argType.name());
		}
	}
}

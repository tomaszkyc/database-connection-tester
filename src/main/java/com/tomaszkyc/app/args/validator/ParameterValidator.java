package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgParameter;

public interface ParameterValidator {

	public boolean validate(ArgParameter parameter);
	
	public String getErrorMessage();
	
}

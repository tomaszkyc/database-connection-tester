package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgParameter;

public interface ParameterValidator<T extends ArgParameter> {

	public boolean validate(T parameter);
	
	public String getErrorMessage();
	
}

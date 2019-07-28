package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgParameter;

public interface ParameterValidator<T> {

	public boolean validate(T parameter);
	
}

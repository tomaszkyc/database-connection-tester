package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.ArgParameter;

public class InformationParameterValidator implements ParameterValidator {

	@Override
	public boolean validate(ArgParameter parameter) {
		// not implemented
		return true;
	}

	@Override
	public String getErrorMessage() {
		return "There was an error during information parameters validation. Check parameters" + 
				   " and try again.";
	}

}

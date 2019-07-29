package com.tomaszkyc.app.args.validator;

import com.tomaszkyc.app.args.InformationParameter;

public class InformationParameterValidator implements ParameterValidator<InformationParameter> {

	@Override
	public boolean validate(InformationParameter parameter) {
		// not implemented
		return true;
	}

	@Override
	public String getErrorMessage() {
		return "There was an error during information parameters validation. Check parameters" + 
				   " and try again.";
	}

}

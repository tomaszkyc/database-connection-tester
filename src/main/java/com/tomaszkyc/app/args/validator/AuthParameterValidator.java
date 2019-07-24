package com.tomaszkyc.app.args.validator;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.AuthParameter;

public class AuthParameterValidator implements ParameterValidator{

	public boolean validate(ArgParameter parameter) {
		
		Predicate<AuthParameter> isLoginProvided = (param) -> !StringUtils.isBlank( param.getDbLogin() );
		Predicate<AuthParameter> isPasswordProvided = (param) -> !StringUtils.isBlank( param.getDbPassword() );
		
		return isLoginProvided.and(isPasswordProvided).test((AuthParameter)parameter);
	}

	@Override
	public String getErrorMessage() {
		return "There was an error during authentication parameters validation. Check parameters" + 
				   " and try again.";
	}

	
}

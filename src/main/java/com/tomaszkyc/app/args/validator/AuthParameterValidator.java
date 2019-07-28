package com.tomaszkyc.app.args.validator;

import java.util.function.Predicate;

import com.tomaszkyc.app.args.AuthParameter;

public class AuthParameterValidator implements ParameterValidator<AuthParameter> {

	public boolean validate(AuthParameter parameter) {
		
		Predicate<AuthParameter> isLoginProvided = (param) -> !param.getDbLogin().isEmpty();
		Predicate<AuthParameter> isPasswordProvided = (param) -> !param.getDbPassword().isEmpty();
		
		return isLoginProvided.and(isPasswordProvided).test(parameter);
	}

	
}

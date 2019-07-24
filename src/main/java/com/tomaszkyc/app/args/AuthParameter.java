package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class AuthParameter implements ArgParameter {

	@Parameter(names = { "-username", "-u" }, description = "Database login")
	private String dbLogin;

	@Parameter(names = { "-password", "-p" }, description = "Database password")
	private String dbPassword;

	public String getDbLogin() {
		return dbLogin;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	@Override
	public ArgParameter getParameter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArgType getArgType() {
		// TODO Auto-generated method stub
		return ArgType.AUTH_PARAM;
	}

}

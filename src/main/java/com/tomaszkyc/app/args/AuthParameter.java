package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class AuthParameter implements ArgParameter {

	@Parameter(names = { "-username", "-u" }, description = "Database login", required = true)
	private String dbLogin;

	@Parameter(names = { "-password", "-p" }, description = "Database password", required = true)
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

}

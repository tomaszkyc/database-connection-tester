package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

public class InformationParameter implements ArgParameter  {

	@Parameter(names = "-usage", description = "Show available parameters", order = 0)
	private boolean helpRequired = false;
	
	@Parameter(names = "-debug", description = "Debug mode")
	private boolean debug = false;
	
	public boolean isDebug() {
		return debug;
	}

	@Override
	public ArgParameter getParameter() {
		// TODO Auto-generated method stub
		return this;
	}

	public boolean isHelpRequired() {
		return helpRequired;
	}
	
}

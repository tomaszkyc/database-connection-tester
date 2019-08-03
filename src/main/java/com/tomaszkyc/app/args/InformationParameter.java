package com.tomaszkyc.app.args;

import com.beust.jcommander.Parameter;

import java.util.List;

public class InformationParameter implements ArgParameter  {

	@Parameter(names = "-usage", description = "Show available parameters")
	private boolean helpRequired = false;
	
	@Parameter(names = "-debug", description = "Debug mode. Add this flag to execution args to add debugging mode")
	private boolean debug = false;
	
	public boolean isDebug() {
		return debug;
	}

	@Override
	public ArgParameter getParameter() {
		// TODO Auto-generated method stub
		return this;
	}

	public static boolean isDebug( List<ArgParameter> parameters ) throws Exception {

		boolean isDebugEnabled = false;

		for( ArgParameter parameter : parameters ) {

			if ( parameter.getArgType().equals(ArgType.INFORMATION_PARAM) ) {

				isDebugEnabled =  (( InformationParameter )parameter).isDebug();
				break;

			}

		}


		return isDebugEnabled;
	}

	public boolean isHelpRequired() {
		return helpRequired;
	}

	@Override
	public ArgType getArgType() {
		return ArgType.INFORMATION_PARAM;
	}
	
}

package com.tomaszkyc.app.args;

import java.util.ArrayList;
import java.util.List;

public class ArgParameterFactory {
	
	public static List<ArgParameter> create() { 
		
		List<ArgParameter> parameters = new ArrayList<>();
		
		parameters.add( new DatabaseParameter() );
		parameters.add( new AuthParameter() );
		parameters.add( new InformationParameter() );
		
		return parameters;
	}
}

package com.tomaszkyc.app.args;

public class ArgParameterSerializer {

	public static String serialize(ArgParameter inputParameter) { 
		
		StringBuilder serializedParameter = new StringBuilder();
		
		if ( inputParameter instanceof InformationParameter ) { 
			
			InformationParameter parameter = (InformationParameter) inputParameter;
			serializedParameter.append( InformationParameter.class.getName() + " properties: " );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Is help required: " + parameter.isHelpRequired() );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append("--------------------------------------------------------");
			serializedParameter.append( System.lineSeparator() );
			
		}
		else if ( inputParameter instanceof AuthParameter ) { 
			
			AuthParameter parameter = (AuthParameter) inputParameter;
			serializedParameter.append( AuthParameter.class.getName() + " properties: " );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Login: " + parameter.getDbLogin() );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Password: " + parameter.getDbPassword() );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append("--------------------------------------------------------");
			serializedParameter.append( System.lineSeparator() );
			
			
		}
		else if ( inputParameter instanceof DatabaseParameter ) { 
			
			DatabaseParameter parameter = (DatabaseParameter) inputParameter;
			serializedParameter.append( DatabaseParameter.class.getName() + " properties: " );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Hostname: " + parameter.getDatabaseHostname() );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Port: " + parameter.getDatabasePort() );
			serializedParameter.append( System.lineSeparator() );		
			serializedParameter.append( "Database type: " + parameter.getDatabaseType() );
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append( "Database name: " + parameter.getDatabaseName());
			serializedParameter.append( System.lineSeparator() );
			serializedParameter.append("--------------------------------------------------------");
			serializedParameter.append( System.lineSeparator() );
			
		}
		else {
			throw new IllegalArgumentException("Given input argument isn't implemented in serializer.");
		}

		return serializedParameter.toString();
	}
	
	
}

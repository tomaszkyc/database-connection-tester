package com.tomaszkyc.app.args.validator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.tomaszkyc.app.args.DatabaseParameter;
import com.tomaszkyc.app.args.DatabaseType;

public class DatabaseParameterValidator implements ParameterValidator<DatabaseParameter> {

	
	private static Predicate<DatabaseParameter> isDatabaseTypeCorrect = new Predicate<DatabaseParameter>() {

		@Override
		public boolean test(DatabaseParameter param) {
			
			List<DatabaseType> dbTypes = Arrays.asList( DatabaseType.values() );
			for( DatabaseType type : dbTypes ) { 
				
				if ( type.name().equals( param.getDatabaseType() ) ) { 
					return true;
				}
			}
			return false;
		}
	};
	
	
	@Override
	public boolean validate(DatabaseParameter parameter) {
		
		Predicate<DatabaseParameter> isHostNameNotEmpty = (param) -> !param.getDatabaseHostname().isEmpty();
		Predicate<DatabaseParameter> isPortNotEmpty = (param) -> !param.getDatabasePort().isEmpty();
		Predicate<DatabaseParameter> isDbNameNotEmpty = (param) -> !param.getDatabaseName().isEmpty();
		
		
		return isHostNameNotEmpty.and(isPortNotEmpty)
								 .and(isDbNameNotEmpty)
					             .and(isDatabaseTypeCorrect).test(parameter);
		
		
	}


	@Override
	public String getErrorMessage() {
		
		return "There was an error during database parameters validation. Check parameters" + 
			   " and try again.";
		
	}

}

package com.tomaszkyc.app.args.validator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.DatabaseParameter;
import com.tomaszkyc.app.args.DatabaseType;

public class DatabaseParameterValidator implements ParameterValidator {

	
	private static Predicate<DatabaseParameter> isDatabaseTypeCorrect = new Predicate<DatabaseParameter>() {

		@Override
		public boolean test(DatabaseParameter param) {
			
			List<DatabaseType> dbTypes = Arrays.asList( DatabaseType.values() );
			for( DatabaseType type : dbTypes ) { 
				
				if ( type.name().equalsIgnoreCase( param.getDatabaseType() ) ) { 
					return true;
				}
			}
			return false;
		}
	};
	
	
	@Override
	public boolean validate(ArgParameter parameter) {
		
		
		
		
		Predicate<DatabaseParameter> isHostNameNotEmpty = (param) -> !StringUtils.isBlank( param.getDatabaseHostname() );
		Predicate<DatabaseParameter> isPortNotEmpty = (param) -> !StringUtils.isBlank( param.getDatabasePort() );
		Predicate<DatabaseParameter> isDbNameNotEmpty = (param) -> !StringUtils.isBlank( param.getDatabaseName() );
		
		
		return isHostNameNotEmpty.and(isPortNotEmpty)
								 .and(isDbNameNotEmpty)
					             .and(isDatabaseTypeCorrect).test((DatabaseParameter)parameter);
		
		
	}


	@Override
	public String getErrorMessage() {
		
		return "There was an error during database parameters validation. Check parameters" + 
			   " and try again.";
		
	}

}

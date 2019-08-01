package com.tomaszkyc.app.config;

import com.tomaszkyc.app.args.*;
import com.tomaszkyc.app.database.UrlBuilder;
import com.tomaszkyc.app.database.UrlBuilderFactory;

import java.util.List;


public class DatabaseConfigJoiner {

    public static void join(DatabaseConfig baseConfig, final List<ArgParameter> inputArguments) throws Exception {

        //get database parameters
        DatabaseParameter databaseParameter = (DatabaseParameter) getArgByType(inputArguments, ArgType.DATABASE_PARAM);

        //get authentication parameters
        AuthParameter authParameter = (AuthParameter) getArgByType(inputArguments, ArgType.AUTH_PARAM);


        baseConfig.setUsername( authParameter.getDbLogin() );
        baseConfig.setPassword( authParameter.getDbPassword() );

        //get url builder
        UrlBuilder urlBuilder = UrlBuilderFactory.getBuilder(DatabaseType.parse( baseConfig.getDatabaseType() ) );

        String url = urlBuilder.build( baseConfig.getUrl(), databaseParameter );

        //set builded url
        baseConfig.setUrl( url );



    }

    static ArgParameter getArgByType(List<ArgParameter> arguments, ArgType argType) {

        ArgParameter argumentWithDefinedType = null;

        for( ArgParameter a : arguments ) {

            if ( a.getArgType().equals( argType ) ) {

                argumentWithDefinedType = a;
                break;
            }
        }

        return argumentWithDefinedType;
    }


}

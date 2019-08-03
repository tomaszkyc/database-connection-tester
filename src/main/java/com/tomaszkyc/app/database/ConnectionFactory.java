package com.tomaszkyc.app.database;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.DatabaseParameter;
import com.tomaszkyc.app.args.DatabaseType;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.config.DatabaseConfig;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ConnectionFactory {



    public static Connection build(DatabaseConfig databaseConfig, List<ArgParameter> parameters) throws Exception{

        Logger log = LoggerFactory.getLogger(InformationParameter.isDebug( parameters ));

        Connection connection = null;

        log.debug("Started building connection object");

        DatabaseType databaseType = DatabaseParameter.getDatababaseType( parameters );

        if ( databaseType.equals( DatabaseType.MYSQL ) ) {
            DriverManager.registerDriver(new SQLServerDriver());

        }
        else {
            //context for class
            Class.forName( databaseConfig.getDrivername() );
        }



        connection = DriverManager.getConnection( databaseConfig.getUrl(),
                                                  databaseConfig.getUsername(),
                                                  databaseConfig.getPassword() );

        log.debug("Finished building connection object");

        return connection;
    }

}

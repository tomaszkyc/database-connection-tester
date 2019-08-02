package com.tomaszkyc.app.database;

import com.tomaszkyc.app.config.DatabaseConfig;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static Logger log = new ConsoleLogger();

    public static Connection build(DatabaseConfig databaseConfig) throws Exception{

        Connection connection = null;

        log.debug("Started building connection object");

        //context for class
        Class.forName( databaseConfig.getDrivername() );


        connection = DriverManager.getConnection( databaseConfig.getUrl(),
                                                  databaseConfig.getUsername(),
                                                  databaseConfig.getPassword() );

        log.debug("Finished building connection object");

        return connection;
    }

}

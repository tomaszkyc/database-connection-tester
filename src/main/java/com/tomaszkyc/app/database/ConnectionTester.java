package com.tomaszkyc.app.database;

import com.tomaszkyc.app.config.DatabaseConfig;
import com.tomaszkyc.app.logging.ConsoleLogger;
import com.tomaszkyc.app.logging.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTester {

    private static Logger log = new ConsoleLogger();

    public static boolean test(Connection connection, DatabaseConfig databaseConfig){

        boolean isConnectionToDb = false;
        log.debug("Started testing connection");

        try {
            Statement statement;
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery( databaseConfig.getTestQuery() );
            while( resultSet.next() ) {
                log.debug( "Got timestamp from database: " + resultSet.getString("actual_time") );
            }
            isConnectionToDb = true;

        } catch (SQLException e) {
            log.error("There was an error during connection ", e);

        }

        return isConnectionToDb;
    }

}

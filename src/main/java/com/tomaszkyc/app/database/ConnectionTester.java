package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.ArgParameter;
import com.tomaszkyc.app.args.InformationParameter;
import com.tomaszkyc.app.config.DatabaseConfig;
import com.tomaszkyc.app.logging.Logger;
import com.tomaszkyc.app.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ConnectionTester {



    public static boolean test(Connection connection, DatabaseConfig databaseConfig, List<ArgParameter> inputParameters) throws Exception {

        Logger log = LoggerFactory.getLogger(InformationParameter.isDebug(inputParameters));

        boolean isConnectionToDb = false;
        log.debug("Started testing connection");

        try {
            Statement statement;
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery( databaseConfig.getTestQuery() );
            while( resultSet.next() ) {
                log.info( "Got timestamp from database: " + resultSet.getString("actual_time") );
            }
            isConnectionToDb = true;

        } catch (SQLException e) {
            log.error("There was an error during connection ", e);

        }

        return isConnectionToDb;
    }

}

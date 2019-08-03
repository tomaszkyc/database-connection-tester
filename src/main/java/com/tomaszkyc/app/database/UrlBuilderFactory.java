package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseType;

public class UrlBuilderFactory {

    public static UrlBuilder getBuilder(DatabaseType databaseType) throws Exception {

        if ( databaseType.equals( DatabaseType.MYSQL ) ) {
            return new MysqlUrlBuilder();
        }
        else if ( databaseType.equals( DatabaseType.ORACLE ) ) {
            return new OracleUrlBuilder();
        }
        else {
            throw new IllegalArgumentException("For this database type: " + databaseType.name() + " factory not implemented");
        }

    }

}

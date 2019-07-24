package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseParameter;

public class MssqlUrlBuilder implements UrlBuilder {


    @Override
    public String build(String urlPattern, DatabaseParameter databaseParameter) {
        String mssqlUrl = urlPattern.replace("@hostname@", databaseParameter.getDatabaseHostname())
                .replace("@port@", databaseParameter.getDatabasePort())
                .replace("@db_name@", databaseParameter.getDatabaseName());

        return mssqlUrl;
    }
}

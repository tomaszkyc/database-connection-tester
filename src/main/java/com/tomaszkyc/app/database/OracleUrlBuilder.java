package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseParameter;

public class OracleUrlBuilder implements UrlBuilder {
    @Override
    public String build(String urlPattern, DatabaseParameter databaseParameter) {

        String oracleUrl = urlPattern.replace("@hostname@", databaseParameter.getDatabaseHostname())
                .replace("@port@", databaseParameter.getDatabasePort())
                .replace("@db_name@", databaseParameter.getDatabaseName());


        return oracleUrl;
    }
}

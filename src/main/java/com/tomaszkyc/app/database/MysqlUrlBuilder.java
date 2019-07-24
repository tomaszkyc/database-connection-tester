package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseParameter;

import java.util.Map;

public class MysqlUrlBuilder implements UrlBuilder {

    @Override
    public String build(String urlPattern, DatabaseParameter databaseParameter) {

        String mysqlUrl = urlPattern.replace("@hostname@", databaseParameter.getDatabaseHostname())
                                    .replace("@port@", databaseParameter.getDatabasePort())
                                    .replace("@db_name@", databaseParameter.getDatabaseName());

        return mysqlUrl;
    }
}

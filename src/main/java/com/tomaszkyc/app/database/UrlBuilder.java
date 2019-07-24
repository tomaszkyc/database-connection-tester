package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseParameter;

public interface UrlBuilder {

    String build(String urlPattern, DatabaseParameter databaseParameter);


}

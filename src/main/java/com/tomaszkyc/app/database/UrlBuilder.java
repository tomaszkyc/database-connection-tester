package com.tomaszkyc.app.database;

import com.tomaszkyc.app.args.DatabaseParameter;

import java.util.Map;

public interface UrlBuilder {

    String build(String urlPattern, DatabaseParameter dbParameter);


}

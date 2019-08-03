package com.tomaszkyc.app.logging;

public class InfoLogger implements Logger {


    public void debug(String msg) {

    }

    public void error(String msg, Exception e) {

    }


    public void info(String msg) {

        System.out.println("INFO: " + msg);

    }

    public void print(String msg) {

        System.out.println( msg );

    }
}

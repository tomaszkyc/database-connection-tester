package com.tomaszkyc.app.logging;

public class LoggerFactory {

    public static Logger getLogger(boolean debugModeEnabled) {

        if ( debugModeEnabled ) {
            return new ConsoleLogger();
        }
        else {
            //return only Info logger - prints only log.info messages
            return new InfoLogger();
        }

    }

}

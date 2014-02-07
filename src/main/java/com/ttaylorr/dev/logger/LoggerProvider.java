package com.ttaylorr.dev.logger;

import java.util.HashMap;

public final class LoggerProvider {

    private static HashMap<Class, Logger> loggers;

    public static Logger getLogger(Class clazz) {
        return loggers.get(clazz);
    }

    public static Logger putLogger(Class clazz) {
        Logger logger = new SimpleLogger(System.out);
        loggers.put(clazz, logger);
        return logger;
    }

}

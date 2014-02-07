package com.ttaylorr.dev.logger;

import java.util.HashMap;

public final class LoggerProvider {

    private static HashMap<Class, Logger> loggers = new HashMap<>();

    public static Logger getLogger(Class clazz) {
        return loggers.get(clazz);
    }

    public static Logger putLogger(Class clazz) {
        if (loggers.containsKey(clazz)) {
            return null;
        }

        Logger logger = new SimpleLogger(System.out);
        loggers.put(clazz, logger);
        return logger;
    }

}

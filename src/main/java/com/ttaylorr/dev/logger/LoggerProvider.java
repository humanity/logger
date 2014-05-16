package com.ttaylorr.dev.logger;

import java.util.HashMap;

public final class LoggerProvider {

    private static HashMap<Class, Logger> loggers = new HashMap<>();

    public static Logger getLogger(Class clazz) {
        return loggers.get(clazz);
    }

    /**
     * Puts a logger into the cache, if it already exists - return existing logger.
     *
     * @param clazz The class to associate the {@link com.ttaylorr.dev.logger.Logger}
     * @param minimum The minimum {@link com.ttaylorr.dev.logger.LogLevel} to log at.
     *                If there is already a logger, its log level is not modified.
     * @return
     */
    public static Logger putLogger(Class clazz, LogLevel minimum) {
        if (loggers.containsKey(clazz)) {
            return loggers.get(clazz);
        }

        Logger logger = new SimpleLogger(System.out, minimum);
        loggers.put(clazz, logger);
        return logger;
    }

    public static Logger putLogger(Class clazz) {
        return putLogger(clazz, LogLevel.DEBUG);
    }
}

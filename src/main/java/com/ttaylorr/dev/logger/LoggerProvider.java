package com.ttaylorr.dev.logger;

import java.util.HashMap;

public final class LoggerProvider {

    private static HashMap<Class, Logger> loggers;

    public static Logger getLogger(Class clazz) {
        return loggers.get(clazz);
    }

    public static void putLogger(Class clazz) {
        loggers.put(clazz, new SimpleLogger(System.out));
    }

}

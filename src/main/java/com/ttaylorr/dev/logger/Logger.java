package com.ttaylorr.dev.logger;

public interface Logger {

    public void debug(String str, Object... args);

    public void info(String str, Object... args);

    public void warn(String str, Object... args);

    public void severe(String str, Object... args);

    public void debug(String str);

    public void info(String str);

    public void warn(String str);

    public void severe(String str);

    public void log(LogLevel level, String str, Object... args);

    public boolean canLog(LogLevel level);
}

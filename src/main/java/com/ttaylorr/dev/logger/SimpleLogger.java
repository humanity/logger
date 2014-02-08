package com.ttaylorr.dev.logger;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleLogger implements Logger {

    private final PrintStream out;
    private final SimpleDateFormat dateFormat;

    public SimpleLogger(PrintStream stream) {
        this.out = stream;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public void debug(String str, Object... args) {
        this.log(LogLevel.DEBUG, str, args);
    }

    @Override
    public void info(String str, Object... args) {
        this.log(LogLevel.INFO, str, args);
    }

    @Override
    public void warn(String str, Object... args) {
        this.log(LogLevel.WARN, str, args);
    }

    @Override
    public void severe(String str, Object... args) {
        this.log(LogLevel.SEVERE, str, args);
    }

    @Override
    public void debug(String str) {
        this.debug(str, null);
    }

    @Override
    public void info(String str) {
        this.info(str, null);
    }

    @Override
    public void warn(String str) {
        this.warn(str, null);
    }

    @Override
    public void severe(String str) {
        this.severe(str, null);
    }

    @Override
    public void log(LogLevel level, String str, Object... args) {
        StringBuilder builder = new StringBuilder();

        builder.append(formatDate()).append(' ');
        builder.append('[').append(level.name()).append(']').append(' ');

        int argCount = -1;

        Pattern pattern = Pattern.compile(Pattern.quote("{}"));
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            str.replaceFirst(matcher.group(), args[++argCount].toString());
        }

        builder.append(str);
        this.out.println(builder.toString());
    }

    public String formatDate() {
        return this.dateFormat.format(new Date());
    }
}

package com.example.task04;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private static final ArrayList<Logger> loggers = new ArrayList<>();
    private static final ArrayList<MessageHandler> handlers = new ArrayList<>();
    private final String name;
    private LoggerLevel level;

    public Logger(String name){
        this.name = name;
        this.level = LoggerLevel.DEBUG;
        loggers.add(this);
    }

    public void addHandler(MessageHandler handler){
        handlers.add(handler);
    }

    public static Logger getLogger(String name){
        for(Logger logger : loggers){
            if(logger.name.equals(name)){
                return logger;
            }
        }
        Logger logger = new Logger(name);
        loggers.add(logger);
        return logger;
    }

    private void printLog(LoggerLevel level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String formatedMessage = String.format("[%s] %s %s %s - %s%n", level, date, time, name, message);

            for(MessageHandler handler : handlers){
                handler.handleMessage(formatedMessage);
            }
        }
    }

    private void log(LoggerLevel level, String message){
        printLog(level, message);
    }

    private void log(LoggerLevel level, String template, Object... args){
        printLog(level, String.format(template, args));
    }

    public void debug(String message){
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String template, Object... args){
        log(LoggerLevel.DEBUG, template, args);
    }

    public void info(String message){
        log(LoggerLevel.INFO, message);
    }

    public void info(String template, Object... args){
        log(LoggerLevel.INFO, template, args);
    }

    public void warning(String message){
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String template, Object... args){
        log(LoggerLevel.WARNING, template, args);
    }

    public void error(String message){
        log(LoggerLevel.ERROR, message);
    }

    public void error(String template, Object... args){
        log(LoggerLevel.ERROR, template, args);
    }

    public String getName(){
        return name;
    }

    public LoggerLevel getLevel(){
        return level;
    }

    public void setLevel(LoggerLevel level){
        this.level = level;
    }
}

package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        Logger logger = new Logger("FirstLogger");

        ConsoleHandler consoleHandler = new ConsoleHandler();
        logger.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("log.txt");
        logger.addHandler(fileHandler);

        logger.debug("debug");
        logger.info("info");
        logger.warning("warning");
    }
}

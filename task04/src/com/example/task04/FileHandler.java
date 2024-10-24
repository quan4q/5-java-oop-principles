package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    private final String fileName;

    public FileHandler(String path){
        this.fileName = path;
    }

    @Override
    public void handleMessage(String message){
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message + '\n');
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}

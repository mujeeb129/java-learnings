package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreateWriteExample {
    public static void main(String[] args) throws IOException {
        File newFile = new File("new_example.txt");
        boolean fileExists = !newFile.exists();

//        if (fileExists){
//            boolean _ = newFile.createNewFile();
//        }
        try (FileWriter fileWriter = new FileWriter("new_example.txt")) {
            fileWriter.append("Good morning bangalore");
            fileWriter.append("\nappended");
        }
    }
}

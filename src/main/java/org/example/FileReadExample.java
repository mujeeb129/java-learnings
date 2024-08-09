package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReadExample {
    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File("example.txt");
        try (Scanner scanner = new Scanner(myFile)){
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
        }
    }
}
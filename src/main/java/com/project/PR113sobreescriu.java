package com.project;

import java.io.BufferedWriter; // Make sure to import this
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PR113sobreescriu {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        try {
            escriureFrases(camiFitxer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escriureFrases(String filePath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("I can only show you the door");
            writer.newLine();
            writer.write("You're the one that has to walk through it");
            writer.newLine();
        }
    }
}

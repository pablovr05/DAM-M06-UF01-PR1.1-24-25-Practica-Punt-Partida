package com.project;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class PR114linies {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/numeros.txt";

        generarNumerosAleatoris(camiFitxer);
    }

    public static void generarNumerosAleatoris(String camiFitxer) {
        Random random = new Random();

        try (FileWriter writer = new FileWriter(camiFitxer, StandardCharsets.UTF_8)) {
            for (int i = 0; i < 10; i++) {//FOR PER GENERAR 10 NÚMEROS
                int numeroAleatori = random.nextInt(100); //Generar un número random
                writer.write(String.valueOf(numeroAleatori));
                // Això ho faig per escriure un espai buit al final del arxiu.
                if (i < 9) {
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            System.err.println("No s'ha pogut escriure l'arxiu: " + e.getMessage());
        }
    }
}

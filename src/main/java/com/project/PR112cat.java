package com.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class PR112cat {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No s'ha proporcionat cap ruta d'arxiu.");
            return;
        }
        String rutaArxiu = args[0];
        mostrarContingutArxiu(rutaArxiu);
    }

    //Funció
    public static void mostrarContingutArxiu(String rutaArxiu) {
        File arxiu = new File(rutaArxiu);

        if (arxiu.isFile()) {
            try {
                //Llegir amb UTF8
                String contingut = new String(Files.readAllBytes(Paths.get(rutaArxiu)), StandardCharsets.UTF_8);
                // Mostrar el contenido
                System.out.println(contingut);
            } catch (IOException e) {
                System.out.println("El fitxer no existeix o no és accessible.");
            }
        } else if (arxiu.isDirectory()) {
            System.out.println("El path no correspon a un arxiu, sinó a una carpeta.");
        } else {
            System.out.println("El fitxer no existeix o no és accessible.");
        }
    }
}

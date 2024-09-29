package com.project;

import java.io.File;
import java.io.IOException;

public class PR111Files {

    public static void main(String[] args) {
        String camiDirectori = System.getProperty("user.dir") + "/data/pr111/myFiles";
        gestionarArxius(camiDirectori);
    }

    public static void gestionarArxius(String camiDirectori) {
        try {
            File directori = new File(camiDirectori);
            
            // Comprobar si el directorio existe y crearlo si no
            if (!directori.exists()) {
                System.out.println("Intentant crear el directori: " + camiDirectori);
                if (directori.mkdirs()) {
                    System.out.println("Directori creat correctament: " + camiDirectori);
                } else {
                    System.err.println("No s'ha pogut crear el directori: " + camiDirectori);
                    return; // Terminar la ejecución si no se puede crear el directorio
                }
            } else {
                System.out.println("El directori ja existeix: " + camiDirectori);
            }

            File file1 = new File(directori, "file1.txt");
            File file2 = new File(directori, "file2.txt");

            // Crear arxius
            if (file1.createNewFile()) {
                System.out.println("Fitxer creat: " + file1.getName());
            } else {
                System.out.println("El fitxer " + file1.getName() + " ja existeix.");
            }

            if (file2.createNewFile()) {
                System.out.println("Fitxer creat: " + file2.getName());
            } else {
                System.out.println("El fitxer " + file2.getName() + " ja existeix.");
            }

            // Renombrar
            File renamedFile = new File(directori, "renamedFile.txt");
            if (file2.renameTo(renamedFile)) {
                System.out.println("El fitxer " + file2.getName() + " s'ha renombrat a " + renamedFile.getName());
            } else {
                System.err.println("No s'ha pogut renombrar el fitxer " + file2.getName());
            }

            // Llistar
            System.out.println("Els arxius de la carpeta són:");
            mostrarArxius(directori);

            // Eliminar
            if (file1.delete()) {
                System.out.println("El fitxer " + file1.getName() + " s'ha eliminat.");
            } else {
                System.err.println("No s'ha pogut eliminar el fitxer " + file1.getName());
            }

            // Llistar
            System.out.println("Els arxius de la carpeta són:");
            mostrarArxius(directori);

        } catch (IOException e) {
            System.err.println("S'ha produït un error durant la gestió dels arxius.");
            e.printStackTrace();
        }
    }

    public static void mostrarArxius(File directori) {
        File[] arxius = directori.listFiles();
        if (arxius != null && arxius.length > 0) {
            for (File arxiu : arxius) {
                System.out.println(arxiu.getName());
            }
        } else {
            System.out.println("No hi ha arxius en aquest directori.");
        }
    }
}

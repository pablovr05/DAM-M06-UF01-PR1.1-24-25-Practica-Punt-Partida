package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PR110ReadFile {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/GestioTasques.java";
        llegirIMostrarFitxer(camiFitxer); 
    }

    // Funció:
    public static void llegirIMostrarFitxer(String camiFitxer) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(camiFitxer));
            String linia;
            int numeroLinia = 1;

            while ((linia = reader.readLine()) != null) {
                System.out.println(numeroLinia + ": " + linia);
                numeroLinia++;
            }
        } catch (IOException e) {
            System.err.println("No s'ha pogut llegir el fitxer: " + camiFitxer);
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close(); //Això és per tancar l'arxiu, si hi ha un error, aquest es printearà en la linea de abaix ( catch IOException ).
                } catch (IOException e) {
                    System.err.println("Error tancant el fitxer: " + camiFitxer);
                }
            }
        }
    }
}

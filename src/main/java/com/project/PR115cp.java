package com.project;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PR115cp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Has d'indicar dues rutes d'arxiu.");
            System.out.println("Ús: PR115cp <origen> <destinació>");
            return;
        }

        String rutaOrigen = args[0];
        String rutaDesti = args[1];

        File fitxerDesti = new File(rutaDesti);
        if (fitxerDesti.exists()) {
            System.out.println("Advertència: L'arxiu de destinació ja existeix i serà sobreescrit."); //He tenido que buscar como llamar la ejecución de un archivo con un parámetro en el chatgpt
        }

        copiarArxiu(rutaOrigen, rutaDesti);
    }

    public static void copiarArxiu(String rutaOrigen, String rutaDesti) {
        File fitxerOrigen = new File(rutaOrigen); //Això agafa el origen com a un paràmetre

        if (!fitxerOrigen.exists() || !fitxerOrigen.isFile()) { //Això comprova que existeix la ruta y és un arxiu.
            System.out.println("Error: L'arxiu d'origen no existeix o no és un fitxer vàlid.");
            return;
        }

        //Aquesta linea la he buscat a un forum i després he preguntat al chatgpt com fer-la servir, basicament, el que fa és fer un try per copiar l'arxiu, reader es l'arxiu on s'agafa el text i writter l'arxiu on estem fent la copia.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fitxerOrigen), StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rutaDesti), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine(); //Això el que fa és avançar una linea per poder copiar en la següent linea.
            }

            System.out.println("La còpia s'ha realitzat correctament.");
        } catch (IOException e) {
            System.out.println("Error: No s'ha pogut copiar l'arxiu. " + e.getMessage());
        }
    }
}

package com.project;

import java.io.FileWriter;
import java.io.IOException; 
import java.nio.charset.StandardCharsets; 
import java.io.File;

public class PR113append {

    public static void main(String[] args) {
        String camiFitxer = System.getProperty("user.dir") + "/data/frasesMatrix.txt";

        afegirFrases(camiFitxer);
    }

    public static void afegirFrases(String camiFitxer) {
        try {
            File file = new File(camiFitxer);
            // Comprovem si el fitxer existeix, si no, el creem
            if (!file.exists()) {
                file.createNewFile(); // Creem un nou fitxer si no existeix
            }
            
            // Utilitzem FileWriter per obrir el fitxer en mode append (afegir)
            try (FileWriter writer = new FileWriter(camiFitxer, StandardCharsets.UTF_8, true)) {
                // Comprovem si el fitxer no està buit; si no ho està, afegim una nova línia
                if (file.length() > 0) {
                    writer.write("\n"); // Afegim una nova línia només si el fitxer ja té contingut
                }
                // Afegim les frases al fitxer
                writer.write("I can only show you the door\n");
                writer.write("You're the one that has to walk through it\n");
                // Mostrem un missatge per confirmar que les frases s'han afegit correctament
                System.out.println("S'han afegit les frases al fitxer.");
            }
        } catch (IOException e) {
            // Si es produeix un error d'entrada/sortida, mostrem un missatge d'error
            System.err.println("No s'ha pogut escriure l'arxiu: " + e.getMessage());
        }
    }
}

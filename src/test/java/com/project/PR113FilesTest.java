package com.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PR113FilesTest {

    @TempDir
    Path directoriTemporal;

    @BeforeEach
    void setUp() throws IOException {
        // Limpiar el contenido del archivo si existe
        File fitxer = new File(directoriTemporal.toFile(), "frasesMatrix.txt");
        if (fitxer.exists()) {
            fitxer.delete(); // Elimina el archivo para empezar desde cero
        }
        // Create the file to ensure it exists for the tests
        fitxer.createNewFile();
    }

    @Test
    void testSobreescriureFrases() throws IOException {
        // Definir el camí del fitxer dins del directori temporal
        File fitxer = new File(directoriTemporal.toFile(), "frasesMatrix.txt");

        // Executar el mètode que sobreescriu l'arxiu
        PR113sobreescriu.escriureFrases(fitxer.getPath());

        // Comprovar que el fitxer existeix
        assertTrue(fitxer.exists(), "El fitxer hauria d'existir");

        // Llegir tot el contingut del fitxer com a text complet amb UTF-8
        String contingut = Files.readString(fitxer.toPath(), StandardCharsets.UTF_8);

        // Dividir el contingut per línies, mantenint les línies buides
        String[] linies = contingut.split("\\R", -1);  // "\\R" gestiona qualsevol tipus de salt de línia

        // Comprovar el nombre de línies esperades
        assertEquals(3, linies.length, "El fitxer hauria de tenir tres línies: dues frases i una línia en blanc al final.");
        assertEquals("I can only show you the door", linies[0], "La primera frase hauria de coincidir.");
        assertEquals("You're the one that has to walk through it", linies[1], "La segona frase hauria de coincidir.");
        assertEquals("", linies[2], "L'última línia hauria de ser en blanc.");
    }

    @Test
    public void testAfegirFrases() throws IOException {
        String camiFitxer = new File(directoriTemporal.toFile(), "frasesMatrix.txt").getPath();
        PR113sobreescriu.escriureFrases(camiFitxer); // Asegúrate de que se escriben las frases primero
        PR113append.afegirFrases(camiFitxer);

        // Read back the content of the file
        List<String> lines = Files.readAllLines(new File(camiFitxer).toPath(), StandardCharsets.UTF_8);
        
        // Assert the expected conditions
        assertEquals(5, lines.size(), "El fitxer hauria de tenir quatre línies després de dos afegits: dues frases per afegir.");
        assertEquals("", lines.get(2), "La tercera frase hauria de coincidir després d'afegir.");
    }
}


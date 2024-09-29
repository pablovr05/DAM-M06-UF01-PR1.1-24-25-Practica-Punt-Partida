package com.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class PR111FilesTest {

    @TempDir
    Path directoriTemporal;

    @Test
    void testGestionarArxius() {
        // Preparació: Definir el camí de la carpeta temporal dins del directori temporal proporcionat per JUnit
        File carpeta = new File(directoriTemporal.toFile(), "myFiles");

        // Ejecutar el método de gestión de archivos pasando la ruta del directorio "myFiles"
        PR111Files.gestionarArxius(carpeta.getAbsolutePath());

        // Comprobar que la carpeta existe
        assertTrue(carpeta.exists() && carpeta.isDirectory(), "La carpeta hauria d'existir");

        // Comprobar que se ha creado "renamedFile.txt" y no existe "file2.txt"
        File renamedFile = new File(carpeta, "renamedFile.txt");
        assertTrue(renamedFile.exists(), "El fitxer hauria d'haver estat renombrat a 'renamedFile.txt'");
        File file2 = new File(carpeta, "file2.txt");
        assertFalse(file2.exists(), "El fitxer 'file2.txt' no hauria d'existir");

        // Comprobar que se ha eliminado "file1.txt"
        File file1 = new File(carpeta, "file1.txt");
        assertFalse(file1.exists(), "El fitxer 'file1.txt' hauria d'haver estat eliminat");

        // Comprobar el listado final de la carpeta
        String[] arxiusFinals = carpeta.list();
        assertNotNull(arxiusFinals);
        assertEquals(1, arxiusFinals.length, "Ha de quedar només un fitxer a la carpeta");
        assertEquals("renamedFile.txt", arxiusFinals[0], "L'únic fitxer restant hauria de ser 'renamedFile.txt'");
    }
}

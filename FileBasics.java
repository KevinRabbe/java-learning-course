/**
 * FileBasics.java
 * Grundlagen der Dateiverwaltung in Java
 */

import java.io.File;
import java.io.IOException;

public class FileBasics {
    public static void main(String[] args) {
        System.out.println("=== Grundlagen der Dateiverwaltung ===\\n");

        // 1. Erstellen von File-Objekten
        System.out.println("--- Erstellen von File-Objekten ---");
        
        // Relativer Pfad
        File relativeFile = new File("test.txt");
        System.out.println("Relativer Pfad: " + relativeFile.getPath());
        
        // Absoluter Pfad
        File absoluteFile = new File("/tmp/test.txt");
        System.out.println("Absoluter Pfad: " + absoluteFile.getAbsolutePath());
        
        // Verzeichnis und Dateiname
        File fileInDir = new File("data", "input.txt");
        System.out.println("Datei in Verzeichnis: " + fileInDir.getPath());

        // 2. Überprüfen von Dateien und Verzeichnissen
        System.out.println("\\n--- Überprüfen von Dateien und Verzeichnissen ---");
        
        File testFile = new File("example.txt");
        System.out.println("Dateiname: " + testFile.getName());
        System.out.println("Existiert: " + testFile.exists());
        System.out.println("Ist Datei: " + testFile.isFile());
        System.out.println("Ist Verzeichnis: " + testFile.isDirectory());
        
        if (testFile.exists()) {
            System.out.println("Länge: " + testFile.length() + " Bytes");
            System.out.println("Kann gelesen werden: " + testFile.canRead());
            System.out.println("Kann geschrieben werden: " + testFile.canWrite());
        }

        // 3. Arbeiten mit Verzeichnissen
        System.out.println("\\n--- Arbeiten mit Verzeichnissen ---");
        
        File directory = new File("test_directory");
        System.out.println("Verzeichnis existiert: " + directory.exists());
        
        // Verzeichnis erstellen
        if (!directory.exists()) {
            boolean created = directory.mkdir(); // mkdir für einzelnes Verzeichnis
            System.out.println("Verzeichnis erstellt: " + created);
        }
        
        // Mehrere verschachtelte Verzeichnisse erstellen
        File nestedDir = new File("parent/child/grandchild");
        if (!nestedDir.exists()) {
            boolean created = nestedDir.mkdirs(); // mkdirs für verschachtelte Verzeichnisse
            System.out.println("Verschachtelte Verzeichnisse erstellt: " + created);
        }

        // 4. Dateien auflisten
        System.out.println("\\n--- Dateien auflisten ---");
        
        File currentDir = new File(".");
        String[] files = currentDir.list();
        if (files != null) {
            System.out.println("Dateien im aktuellen Verzeichnis:");
            for (String file : files) {
                System.out.println(" - " + file);
            }
        }

        // Mit File-Array für mehr Details
        File[] fileObjects = currentDir.listFiles();
        if (fileObjects != null) {
            System.out.println("Detaillierte Liste:");
            for (File f : fileObjects) {
                String type = f.isDirectory() ? "[DIR]" : "[FILE]";
                System.out.println(" " + type + " " + f.getName());
            }
        }

        // 5. Pfad-Operationen
        System.out.println("\\n--- Pfad-Operationen ---");
        
        File pathFile = new File("data/documents/report.txt");
        System.out.println("Vollständiger Pfad: " + pathFile.getAbsolutePath());
        System.out.println("Übergeordnetes Verzeichnis: " + pathFile.getParent());
        System.out.println("Dateiname: " + pathFile.getName());

        // 6. Temporäre Dateien
        System.out.println("\\n--- Temporäre Dateien ---");
        
        try {
            File tempFile = File.createTempFile("temp_", ".txt");
            System.out.println("Temporäre Datei erstellt: " + tempFile.getAbsolutePath());
            
            // Temporäre Datei wird beim Beenden des Programms gelöscht
            tempFile.deleteOnExit();
            System.out.println("Datei wird beim Beenden gelöscht.");
            
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der temporären Datei: " + e.getMessage());
        }

        // 7. Aufräumen (Beispiel)
        System.out.println("\\n--- Aufräumen ---");
        
        // Verzeichnis löschen (nur wenn leer)
        File tempDir = new File("test_directory");
        if (tempDir.exists() && tempDir.isDirectory()) {
            boolean deleted = tempDir.delete();
            System.out.println("Verzeichnis gelöscht: " + deleted);
        }
    }
}
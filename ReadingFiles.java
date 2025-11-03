/**
 * ReadingFiles.java
 * Verschiedene Methoden zum Lesen von Dateien in Java
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFiles {
    public static void main(String[] args) {
        System.out.println("=== Verschiedene Methoden zum Lesen von Dateien ===\\n");

        // Erstelle eine Testdatei zum Lesen
        createTestFile();

        // 1. Lesen mit FileReader (zeichenweise)
        System.out.println("--- 1. Lesen mit FileReader ---");
        readWithFileReader("test_input.txt");

        // 2. Lesen mit BufferedReader (zeilenweise)
        System.out.println("\\n--- 2. Lesen mit BufferedReader ---");
        readWithBufferedReader("test_input.txt");

        // 3. Lesen mit FileInputStream (binär)
        System.out.println("\\n--- 3. Lesen mit FileInputStream ---");
        readWithFileInputStream("test_input.txt");

        // 4. Lesen mit Files.readAllLines (NIO.2)
        System.out.println("\\n--- 4. Lesen mit Files.readAllLines ---");
        readWithFilesReadAllLines("test_input.txt");

        // 5. Lesen mit Files.lines (Stream-API)
        System.out.println("\\n--- 5. Lesen mit Files.lines ---");
        readWithFilesLines("test_input.txt");

        // 6. Sicheres Lesen mit try-with-resources
        System.out.println("\\n--- 6. Sicheres Lesen mit try-with-resources ---");
        safeReading("test_input.txt");

        // Aufräumen
        deleteTestFile();
    }

    private static void createTestFile() {
        try (PrintWriter writer = new PrintWriter("test_input.txt", StandardCharsets.UTF_8)) {
            writer.println("Zeile 1: Hallo Welt!");
            writer.println("Zeile 2: Java ist toll.");
            writer.println("Zeile 3: Dateien lesen macht Spaß.");
            writer.println("Zeile 4: Ende der Datei.");
            System.out.println("Testdatei erstellt: test_input.txt");
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Testdatei: " + e.getMessage());
        }
    }

    private static void readWithFileReader(String filename) {
        try {
            FileReader reader = new FileReader(filename, StandardCharsets.UTF_8);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    private static void readWithBufferedReader(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename, StandardCharsets.UTF_8));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Gelesen: " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    private static void readWithFileInputStream(String filename) {
        try {
            FileInputStream inputStream = new FileInputStream(filename);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                System.out.print("Binär-Daten: ");
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println();
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    private static void readWithFilesReadAllLines(String filename) {
        try {
            Path path = Paths.get(filename);
            java.util.List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String line : lines) {
                System.out.println("Gelesen: " + line);
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    private static void readWithFilesLines(String filename) {
        try {
            Path path = Paths.get(filename);
            Files.lines(path, StandardCharsets.UTF_8)
                 .forEach(line -> System.out.println("Stream: " + line));
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
    }

    private static void safeReading(String filename) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Zeile " + lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
        // Ressourcen werden automatisch freigegeben
    }

    private static void deleteTestFile() {
        try {
            Files.deleteIfExists(Paths.get("test_input.txt"));
            System.out.println("\\nTestdatei gelöscht.");
        } catch (IOException e) {
            System.out.println("Fehler beim Löschen der Testdatei: " + e.getMessage());
        }
    }
}
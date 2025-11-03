/**
 * WritingFiles.java
 * Verschiedene Methoden zum Schreiben von Dateien in Java
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingFiles {
    public static void main(String[] args) {
        System.out.println("=== Verschiedene Methoden zum Schreiben von Dateien ===\n");

        // 1. Schreiben mit FileWriter (zeichenweise)
        System.out.println("--- 1. Schreiben mit FileWriter ---");
        writeWithFileWriter("output1.txt");

        // 2. Schreiben mit PrintWriter (zeilenweise)
        System.out.println("--- 2. Schreiben mit PrintWriter ---");
        writeWithPrintWriter("output2.txt");

        // 3. Schreiben mit BufferedWriter
        System.out.println("--- 3. Schreiben mit BufferedWriter ---");
        writeWithBufferedWriter("output3.txt");

        // 4. Schreiben mit FileOutputStream (binär)
        System.out.println("--- 4. Schreiben mit FileOutputStream ---");
        writeWithFileOutputStream("output4.bin");

        // 5. Schreiben mit Files.write (NIO.2)
        System.out.println("--- 5. Schreiben mit Files.write ---");
        writeWithFilesWrite("output5.txt");

        // 6. Anhängen an eine Datei
        System.out.println("--- 6. Anhängen an eine Datei ---");
        appendToFile("output5.txt");

        // 7. Sicheres Schreiben mit try-with-resources
        System.out.println("--- 7. Sicheres Schreiben mit try-with-resources ---");
        safeWriting("output6.txt");

        // Inhalte überprüfen
        System.out.println("\n--- Inhalte der geschriebenen Dateien ---");
        checkFileContents("output1.txt");
        checkFileContents("output2.txt");
        checkFileContents("output3.txt");
        checkFileContents("output5.txt");
        checkFileContents("output6.txt");

        // Aufräumen
        deleteTestFiles();
    }

    private static void writeWithFileWriter(String filename) {
        try {
            FileWriter writer = new FileWriter(filename, StandardCharsets.UTF_8);
            writer.write("Zeile 1: Geschrieben mit FileWriter\n");
            writer.write("Zeile 2: Zeichenweise Schreiben\n");
            writer.close();
            System.out.println("Datei " + filename + " erfolgreich geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void writeWithPrintWriter(String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename, StandardCharsets.UTF_8);
            writer.println("Zeile 1: Geschrieben mit PrintWriter");
            writer.println("Zeile 2: Einfaches zeilenweises Schreiben");
            writer.println("Zeile 3: Automatische Zeilenumbrüche");
            writer.close();
            System.out.println("Datei " + filename + " erfolgreich geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void writeWithBufferedWriter(String filename) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename), StandardCharsets.UTF_8);
            writer.write("Zeile 1: Geschrieben mit BufferedWriter\n");
            writer.write("Zeile 2: Gepuffertes Schreiben für bessere Performance\n");
            writer.write("Zeile 3: Gut für große Dateien\n");
            writer.close();
            System.out.println("Datei " + filename + " erfolgreich geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void writeWithFileOutputStream(String filename) {
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);
            String text = "Binäre Daten: Dies ist eine Binärdatei.";
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes);
            outputStream.close();
            System.out.println("Binäre Datei " + filename + " erfolgreich geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void writeWithFilesWrite(String filename) {
        try {
            java.util.List<String> lines = java.util.Arrays.asList(
                "Zeile 1: Geschrieben mit Files.write",
                "Zeile 2: NIO.2 API",
                "Zeile 3: Einfach und modern"
            );
            Files.write(Paths.get(filename), lines, StandardCharsets.UTF_8);
            System.out.println("Datei " + filename + " erfolgreich geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void appendToFile(String filename) {
        try {
            Files.write(Paths.get(filename), 
                       java.util.Arrays.asList("\nZeile 4: Diese Zeile wurde angehängt"),
                       StandardCharsets.UTF_8, 
                       StandardOpenOption.APPEND);
            System.out.println("An " + filename + " erfolgreich angehängt.");
        } catch (IOException e) {
            System.out.println("Fehler beim Anhängen: " + e.getMessage());
        }
    }

    private static void safeWriting(String filename) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get(filename), StandardCharsets.UTF_8))) {
            writer.println("Zeile 1: Sicheres Schreiben");
            writer.println("Zeile 2: try-with-resources");
            writer.println("Zeile 3: Ressourcen werden automatisch freigegeben");
            System.out.println("Datei " + filename + " sicher geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void checkFileContents(String filename) {
        try {
            if (Files.exists(Paths.get(filename))) {
                System.out.println("\nInhalt von " + filename + ":");
                Files.lines(Paths.get(filename), StandardCharsets.UTF_8)
                     .forEach(line -> System.out.println("  " + line));
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen von " + filename + ": " + e.getMessage());
        }
    }

    private static void deleteTestFiles() {
        System.out.println("\n--- Aufräumen ---");
        String[] files = {"output1.txt", "output2.txt", "output3.txt", "output4.bin", "output5.txt", "output6.txt"};
        for (String file : files) {
            try {
                boolean deleted = Files.deleteIfExists(Paths.get(file));
                System.out.println("Datei " + file + " gelöscht: " + deleted);
            } catch (IOException e) {
                System.out.println("Fehler beim Löschen von " + file + ": " + e.getMessage());
            }
        }
    }
}
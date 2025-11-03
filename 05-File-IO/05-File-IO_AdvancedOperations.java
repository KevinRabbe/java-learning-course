/**
 * AdvancedOperations.java
 * Fortgeschrittene Dateioperationen in Java
 */

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class AdvancedOperations {
    public static void main(String[] args) {
        System.out.println("=== Fortgeschrittene Dateioperationen ===\n");

        // Testdateien erstellen
        createTestFiles();

        // 1. Dateien kopieren
        System.out.println("--- 1. Dateien kopieren ---");
        copyFile("source.txt", "copy.txt");

        // 2. Dateien verschieben/umbenennen
        System.out.println("--- 2. Dateien verschieben/umbenennen ---");
        moveFile("copy.txt", "moved.txt");

        // 3. Dateien löschen
        System.out.println("--- 3. Dateien löschen ---");
        deleteFile("moved.txt");

        // 4. Verzeichnisse erstellen und durchlaufen
        System.out.println("--- 4. Verzeichnisse erstellen und durchlaufen ---");
        createDirectories();
        listDirectoryContents("test_dir");

        // 5. Rekursives Löschen von Verzeichnissen
        System.out.println("--- 5. Rekursives Löschen ---");
        deleteDirectoryRecursively("test_dir");

        // 6. Dateiattribute überprüfen
        System.out.println("--- 6. Dateiattribute überprüfen ---");
        checkFileAttributes("source.txt");

        // 7. Mehrere Dateien gleichzeitig verarbeiten
        System.out.println("--- 7. Mehrere Dateien gleichzeitig verarbeiten ---");
        processMultipleFiles();

        // Aufräumen
        cleanupTestFiles();
    }

    private static void createTestFiles() {
        try {
            // Haupttestdatei
            Files.write(Paths.get("source.txt"), 
                       List.of("Zeile 1: Testinhalt", 
                              "Zeile 2: Für Kopieren und Verschieben",
                              "Zeile 3: Dateioperationen"), 
                       StandardOpenOption.CREATE);

            // Zusätzliche Dateien für Mehrfachverarbeitung
            Files.write(Paths.get("file1.txt"), List.of("Inhalt 1"));
            Files.write(Paths.get("file2.txt"), List.of("Inhalt 2"));
            Files.write(Paths.get("file3.txt"), List.of("Inhalt 3"));

            System.out.println("Testdateien erstellt.");
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Testdateien: " + e.getMessage());
        }
    }

    private static void copyFile(String source, String target) {
        try {
            Path sourcePath = Paths.get(source);
            Path targetPath = Paths.get(target);
            
            // Kopieren mit NIO.2
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Datei " + source + " erfolgreich nach " + target + " kopiert.");
            
            // Überprüfen
            if (Files.exists(targetPath)) {
                System.out.println("Kopie existiert: " + Files.size(targetPath) + " Bytes");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Kopieren: " + e.getMessage());
        }
    }

    private static void moveFile(String source, String target) {
        try {
            Path sourcePath = Paths.get(source);
            Path targetPath = Paths.get(target);
            
            // Verschieben/Umbennen mit NIO.2
            Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Datei " + source + " erfolgreich nach " + target + " verschoben.");
            
            // Überprüfen
            if (!Files.exists(sourcePath) && Files.exists(targetPath)) {
                System.out.println("Verschiebung erfolgreich.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Verschieben: " + e.getMessage());
        }
    }

    private static void deleteFile(String filename) {
        try {
            Path filePath = Paths.get(filename);
            boolean deleted = Files.deleteIfExists(filePath);
            System.out.println("Datei " + filename + " gelöscht: " + deleted);
        } catch (IOException e) {
            System.out.println("Fehler beim Löschen: " + e.getMessage());
        }
    }

    private static void createDirectories() {
        try {
            // Mehrere verschachtelte Verzeichnisse erstellen
            Path dirPath = Paths.get("test_dir", "subdir", "deep");
            Files.createDirectories(dirPath);
            System.out.println("Verzeichnisse erstellt: " + dirPath.toString());

            // Dateien in verschiedenen Unterverzeichnissen erstellen
            Files.write(dirPath.resolve("file_in_deep.txt"), List.of("Datei in tiefem Verzeichnis"));
            Files.write(Paths.get("test_dir", "file_in_subdir.txt"), List.of("Datei in Unterverzeichnis"));

        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Verzeichnisse: " + e.getMessage());
        }
    }

    private static void listDirectoryContents(String dirname) {
        try {
            Path dirPath = Paths.get(dirname);
            if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
                System.out.println("Inhalt von " + dirname + ":");
                
                // Rekursives Auflisten mit FileVisitor
                Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        System.out.println("  Datei: " + file.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        System.out.println("  Verzeichnis: " + dir.toString());
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Auflisten des Verzeichnisses: " + e.getMessage());
        }
    }

    private static void deleteDirectoryRecursively(String dirname) {
        try {
            Path dirPath = Paths.get(dirname);
            if (Files.exists(dirPath)) {
                // Rekursives Löschen
                Files.walkFileTree(dirPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        System.out.println("Gelöscht: " + file.toString());
                        return FileVisitResult.CONTINUE;
                    }
                    
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        Files.delete(dir);
                        System.out.println("Gelöscht: " + dir.toString());
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Verzeichnis " + dirname + " rekursiv gelöscht.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim rekursiven Löschen: " + e.getMessage());
        }
    }

    private static void checkFileAttributes(String filename) {
        try {
            Path filePath = Paths.get(filename);
            if (Files.exists(filePath)) {
                BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
                
                System.out.println("Attribute von " + filename + ":");
                System.out.println("  Größe: " + attrs.size() + " Bytes");
                System.out.println("  Erstellungszeit: " + attrs.creationTime());
                System.out.println("  Letzte Änderung: " + attrs.lastModifiedTime());
                System.out.println("  Letzter Zugriff: " + attrs.lastAccessTime());
                System.out.println("  Ist Verzeichnis: " + attrs.isDirectory());
                System.out.println("  Ist reguläre Datei: " + attrs.isRegularFile());
                System.out.println("  Ist symbolischer Link: " + attrs.isSymbolicLink());
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Überprüfen der Attribute: " + e.getMessage());
        }
    }

    private static void processMultipleFiles() {
        try {
            // Mehrere Dateien finden und verarbeiten
            Path currentDir = Paths.get(".");
            Files.walk(currentDir, 1) // Nur erste Ebene
                 .filter(path -> path.toString().endsWith(".txt") && !path.toString().contains("source"))
                 .forEach(path -> {
                     try {
                         System.out.println("Verarbeite: " + path.getFileName());
                         List<String> lines = Files.readAllLines(path);
                         System.out.println("  Zeilen: " + lines.size());
                         System.out.println("  Erste Zeile: " + (lines.isEmpty() ? "Leer" : lines.get(0)));
                     } catch (IOException e) {
                         System.out.println("Fehler bei " + path + ": " + e.getMessage());
                     }
                 });
        } catch (IOException e) {
            System.out.println("Fehler bei der Mehrfachverarbeitung: " + e.getMessage());
        }
    }

    private static void cleanupTestFiles() {
        System.out.println("\n--- Endgültiges Aufräumen ---");
        String[] files = {"source.txt", "file1.txt", "file2.txt", "file3.txt"};
        for (String file : files) {
            try {
                Files.deleteIfExists(Paths.get(file));
                System.out.println("Aufgeräumt: " + file);
            } catch (IOException e) {
                System.out.println("Fehler beim Aufräumen von " + file + ": " + e.getMessage());
            }
        }
    }
}
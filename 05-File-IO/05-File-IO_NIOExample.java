/**
 * NIOExample.java
 * Moderne NIO.2 APIs für Dateioperationen
 */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.stream.Stream;

public class NIOExample {
    public static void main(String[] args) {
        System.out.println("=== Moderne NIO.2 APIs ===\n");

        // Testdateien und Verzeichnisse erstellen
        setupTestEnvironment();

        // 1. Path und Paths verwenden
        System.out.println("--- 1. Path und Paths verwenden ---");
        demonstratePaths();

        // 2. Files-Klasse für grundlegende Operationen
        System.out.println("--- 2. Files-Klasse für grundlegende Operationen ---");
        demonstrateFilesBasics();

        // 3. DirectoryStream für Verzeichnisdurchlauf
        System.out.println("--- 3. DirectoryStream für Verzeichnisdurchlauf ---");
        demonstrateDirectoryStream();

        // 4. FileVisitor für rekursive Operationen
        System.out.println("--- 4. FileVisitor für rekursive Operationen ---");
        demonstrateFileVisitor();

        // 5. WatchService für Dateisystem-Überwachung
        System.out.println("--- 5. WatchService für Dateisystem-Überwachung ---");
        demonstrateWatchService();

        // 6. Erweiterte Dateiattribute
        System.out.println("--- 6. Erweiterte Dateiattribute ---");
        demonstrateFileAttributes();

        // Aufräumen
        cleanupTestEnvironment();
    }

    private static void setupTestEnvironment() {
        try {
            // Testverzeichnis erstellen
            Path testDir = Paths.get("nio_test");
            Files.createDirectories(testDir);

            // Testdateien erstellen
            Files.write(testDir.resolve("file1.txt"), List.of("Inhalt 1"));
            Files.write(testDir.resolve("file2.txt"), List.of("Inhalt 2"));
            Files.write(testDir.resolve("file3.txt"), List.of("Inhalt 3"));

            // Unterverzeichnis mit Dateien
            Path subDir = testDir.resolve("subdir");
            Files.createDirectory(subDir);
            Files.write(subDir.resolve("nested.txt"), List.of("Verschachtelte Datei"));

            System.out.println("Testumgebung erstellt: nio_test/");
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Testumgebung: " + e.getMessage());
        }
    }

    private static void demonstratePaths() {
        try {
            // Path-Objekte erstellen
            Path path1 = Paths.get("nio_test", "file1.txt");
            Path path2 = Paths.get("nio_test/file1.txt");
            Path path3 = Paths.get(".").resolve("nio_test").resolve("file1.txt");

            System.out.println("Pfad 1: " + path1);
            System.out.println("Pfad 2: " + path2);
            System.out.println("Pfad 3: " + path3);

            // Pfadoperationen
            Path normalized = path1.normalize();
            Path parent = path1.getParent();
            Path filename = path1.getFileName();

            System.out.println("Normalisiert: " + normalized);
            System.out.println("Übergeordnet: " + parent);
            System.out.println("Dateiname: " + filename);

            // Pfadvergleich
            System.out.println("Sind gleich: " + Files.isSameFile(path1, path3));

        } catch (IOException e) {
            System.out.println("Fehler bei Path-Demonstration: " + e.getMessage());
        }
    }

    private static void demonstrateFilesBasics() {
        try {
            Path testFile = Paths.get("nio_test", "file1.txt");

            // Grundlegende Operationen
            System.out.println("Datei existiert: " + Files.exists(testFile));
            System.out.println("Ist reguläre Datei: " + Files.isRegularFile(testFile));
            System.out.println("Ist Verzeichnis: " + Files.isDirectory(testFile));
            System.out.println("Größe: " + Files.size(testFile) + " Bytes");
            System.out.println("Kann gelesen werden: " + Files.isReadable(testFile));
            System.out.println("Kann geschrieben werden: " + Files.isWritable(testFile));

            // Datei kopieren mit NIO.2
            Path copyPath = Paths.get("nio_test", "file1_copy.txt");
            Files.copy(testFile, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Datei kopiert nach: " + copyPath);

            // Inhalt lesen
            List<String> lines = Files.readAllLines(testFile);
            System.out.println("Inhalt: " + lines);

            // Inhalt schreiben
            Path newFile = Paths.get("nio_test", "new_file.txt");
            Files.write(newFile, List.of("Neue Zeile 1", "Neue Zeile 2"));
            System.out.println("Neue Datei erstellt: " + newFile);

        } catch (IOException e) {
            System.out.println("Fehler bei Files-Basics: " + e.getMessage());
        }
    }

    private static void demonstrateDirectoryStream() {
        Path testDir = Paths.get("nio_test");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(testDir)) {
            System.out.println("Dateien in " + testDir + ":");
            for (Path entry : stream) {
                System.out.println("  " + entry.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Fehler bei DirectoryStream: " + e.getMessage());
        }

        // Mit Filter
        try (DirectoryStream<Path> filteredStream = Files.newDirectoryStream(testDir, "*.txt")) {
            System.out.println("Nur .txt Dateien:");
            for (Path entry : filteredStream) {
                System.out.println("  " + entry.getFileName());
            }
        } catch (IOException e) {
            System.out.println("Fehler bei gefiltertem DirectoryStream: " + e.getMessage());
        }
    }

    private static void demonstrateFileVisitor() {
        Path testDir = Paths.get("nio_test");

        try {
            // Rekursives Auflisten mit FileVisitor
            Files.walkFileTree(testDir, new SimpleFileVisitor<Path>() {
                private int fileCount = 0;
                private int dirCount = 0;

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    fileCount++;
                    System.out.println("Datei gefunden: " + file + " (" + attrs.size() + " Bytes)");
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    System.out.println("Verzeichnis: " + dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc != null) {
                        System.err.println("Fehler in Verzeichnis " + dir + ": " + exc.getMessage());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    System.err.println("Fehler bei Datei " + file + ": " + exc.getMessage());
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("FileVisitor abgeschlossen.");

        } catch (IOException e) {
            System.out.println("Fehler bei FileVisitor: " + e.getMessage());
        }
    }

    private static void demonstrateWatchService() {
        Path testDir = Paths.get("nio_test");

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            // Verzeichnis überwachen
            testDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                                          StandardWatchEventKinds.ENTRY_DELETE,
                                          StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Überwache Verzeichnis: " + testDir);
            System.out.println("Erstelle eine neue Datei in nio_test/ um die Überwachung zu testen...");
            System.out.println("(Die Überwachung läuft für 5 Sekunden)");

            // Kurze Überwachung (in realer Anwendung würde dies in einem separaten Thread laufen)
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 5000) { // 5 Sekunden
                WatchKey key = watchService.poll();
                if (key != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        Path filename = (Path) event.context();
                        System.out.println("Ereignis: " + kind + " - " + filename);
                    }
                    key.reset();
                }
                Thread.sleep(100); // Kurze Pause
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Fehler bei WatchService: " + e.getMessage());
        }
    }

    private static void demonstrateFileAttributes() {
        try {
            Path testFile = Paths.get("nio_test", "file1.txt");

            // Grundlegende Attribute
            BasicFileAttributes basicAttrs = Files.readAttributes(testFile, BasicFileAttributes.class);
            System.out.println("Grundlegende Attribute:");
            System.out.println("  Größe: " + basicAttrs.size());
            System.out.println("  Erstellungszeit: " + basicAttrs.creationTime());
            System.out.println("  Letzte Änderung: " + basicAttrs.lastModifiedTime());
            System.out.println("  Letzter Zugriff: " + basicAttrs.lastAccessTime());

            // DOS-Attribute (falls verfügbar)
            try {
                DosFileAttributes dosAttrs = Files.readAttributes(testFile, DosFileAttributes.class);
                System.out.println("DOS-Attribute:");
                System.out.println("  Versteckt: " + dosAttrs.isHidden());
                System.out.println("  Schreibgeschützt: " + dosAttrs.isReadOnly());
                System.out.println("  System: " + dosAttrs.isSystem());
                System.out.println("  Archiv: " + dosAttrs.isArchive());
            } catch (UnsupportedOperationException e) {
                System.out.println("DOS-Attribute nicht verfügbar auf diesem System.");
            }

            // POSIX-Attribute (falls verfügbar)
            try {
                PosixFileAttributes posixAttrs = Files.readAttributes(testFile, PosixFileAttributes.class);
                System.out.println("POSIX-Attribute:");
                System.out.println("  Besitzer: " + posixAttrs.owner());
                System.out.println("  Gruppe: " + posixAttrs.group());
                System.out.println("  Berechtigungen: " + posixAttrs.permissions());
            } catch (UnsupportedOperationException e) {
                System.out.println("POSIX-Attribute nicht verfügbar auf diesem System.");
            }

        } catch (IOException e) {
            System.out.println("Fehler bei Dateiattributen: " + e.getMessage());
        }
    }

    private static void cleanupTestEnvironment() {
        Path testDir = Paths.get("nio_test");

        try {
            // Rekursives Löschen
            if (Files.exists(testDir)) {
                Files.walkFileTree(testDir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Testumgebung aufgeräumt.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Aufräumen: " + e.getMessage());
        }
    }
}
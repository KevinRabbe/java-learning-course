/**
 * FileIOQuiz.java
 * Quiz und Übungen zu Dateiverwaltung in Java
 */

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileIOQuiz {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int totalQuestions = 0;

    public static void main(String[] args) {
        System.out.println("=== File I/O Quiz ===\n");
        System.out.println("Teste dein Wissen über Dateiverwaltung in Java!");
        System.out.println("Drücke Enter, um zu beginnen...\n");
        scanner.nextLine();

        // Erstelle Testdateien für die Übungen
        createTestFiles();

        // Multiple Choice Fragen
        runMultipleChoiceQuiz();

        // Praktische Übungen
        runPracticalExercises();

        // Ergebnis anzeigen
        showResults();

        // Aufräumen
        cleanupTestFiles();
    }

    private static void createTestFiles() {
        try {
            Files.write(Paths.get("quiz_data.txt"), List.of(
                "Name: Alice",
                "Alter: 25",
                "Stadt: Berlin"
            ));
            Files.write(Paths.get("quiz_binary.dat"), "Binäre Testdaten".getBytes());
            System.out.println("Testdateien für Quiz erstellt.\n");
        } catch (IOException e) {
            System.out.println("Fehler beim Erstellen der Testdateien: " + e.getMessage());
        }
    }

    private static void runMultipleChoiceQuiz() {
        System.out.println("=== Multiple Choice Fragen ===\n");

        askQuestion("Welche Klasse wird verwendet, um Dateien zu lesen?",
                   new String[]{"A) FileWriter", "B) FileReader", "C) FileOutputStream", "D) FileInputStream"},
                   "B");

        askQuestion("Was ist der Zweck der try-with-resources Anweisung?",
                   new String[]{"A) Schnelleres Lesen", "B) Automatisches Schließen von Ressourcen", "C) Mehr Threads", "D) Größere Dateien"},
                   "B");

        askQuestion("Welche Methode liest alle Zeilen einer Datei auf einmal?",
                   new String[]{"A) readLine()", "B) readAllLines()", "C) read()", "D) readBytes()"},
                   "B");

        askQuestion("Was ist NIO.2?",
                   new String[]{"A) Neue Eingabe/Ausgabe API", "B) Network I/O", "C) Non-Input Output", "D) New Instance Object"},
                   "A");

        askQuestion("Welche Exception wird bei Dateioperationen häufig geworfen?",
                   new String[]{"A) NullPointerException", "B) IOException", "C) ArithmeticException", "D) ClassCastException"},
                   "B");
    }

    private static void askQuestion(String question, String[] options, String correctAnswer) {
        totalQuestions++;
        System.out.println("Frage " + totalQuestions + ": " + question);

        for (String option : options) {
            System.out.println(option);
        }

        System.out.print("Deine Antwort (A/B/C/D): ");
        String answer = scanner.nextLine().toUpperCase().trim();

        if (answer.equals(correctAnswer)) {
            System.out.println("✓ Richtig!\n");
            score++;
        } else {
            System.out.println("✗ Falsch. Die richtige Antwort ist: " + correctAnswer + "\n");
        }
    }

    private static void runPracticalExercises() {
        System.out.println("=== Praktische Übungen ===\n");

        // Übung 1: Datei lesen
        exercise1ReadFile();

        // Übung 2: Datei schreiben
        exercise2WriteFile();

        // Übung 3: Verzeichnis durchlaufen
        exercise3ListDirectory();

        // Übung 4: Datei kopieren
        exercise4CopyFile();

        // Übung 5: Exception Handling
        exercise5ExceptionHandling();
    }

    private static void exercise1ReadFile() {
        System.out.println("Übung 1: Lies den Inhalt der Datei 'quiz_data.txt' und gib den Namen aus.");
        System.out.println("(Implementiere den Code selbst - hier ist eine Musterlösung):");

        try {
            List<String> lines = Files.readAllLines(Paths.get("quiz_data.txt"));
            for (String line : lines) {
                if (line.startsWith("Name:")) {
                    String name = line.substring(6).trim();
                    System.out.println("Name: " + name);
                    score++;
                    totalQuestions++;
                    System.out.println("✓ Übung erfolgreich!\n");
                    return;
                }
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }
        System.out.println("✗ Übung nicht erfolgreich.\n");
    }

    private static void exercise2WriteFile() {
        System.out.println("Übung 2: Schreibe 'Hello World!' in eine neue Datei 'hello.txt'.");
        System.out.println("(Implementiere den Code selbst - hier ist eine Musterlösung):");

        try {
            Files.write(Paths.get("hello.txt"), List.of("Hello World!"));
            if (Files.exists(Paths.get("hello.txt"))) {
                System.out.println("Datei erfolgreich erstellt.");
                score++;
                totalQuestions++;
                System.out.println("✓ Übung erfolgreich!\n");
            } else {
                System.out.println("Datei wurde nicht erstellt.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }
        System.out.println("✗ Übung nicht erfolgreich.\n");
    }

    private static void exercise3ListDirectory() {
        System.out.println("Übung 3: Liste alle .txt Dateien im aktuellen Verzeichnis auf.");
        System.out.println("(Implementiere den Code selbst - hier ist eine Musterlösung):");

        try {
            int count = 0;
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."), "*.txt")) {
                for (Path entry : stream) {
                    System.out.println("Gefunden: " + entry.getFileName());
                    count++;
                }
            }
            if (count > 0) {
                score++;
                totalQuestions++;
                System.out.println("✓ Übung erfolgreich!\n");
            } else {
                System.out.println("Keine .txt Dateien gefunden.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Auflisten: " + e.getMessage());
        }
        System.out.println("✗ Übung nicht erfolgreich.\n");
    }

    private static void exercise4CopyFile() {
        System.out.println("Übung 4: Kopiere 'quiz_data.txt' nach 'quiz_data_copy.txt'.");
        System.out.println("(Implementiere den Code selbst - hier ist eine Musterlösung):");

        try {
            Path source = Paths.get("quiz_data.txt");
            Path target = Paths.get("quiz_data_copy.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

            if (Files.exists(target)) {
                System.out.println("Datei erfolgreich kopiert.");
                score++;
                totalQuestions++;
                System.out.println("✓ Übung erfolgreich!\n");
            } else {
                System.out.println("Kopie fehlgeschlagen.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Kopieren: " + e.getMessage());
        }
        System.out.println("✗ Übung nicht erfolgreich.\n");
    }

    private static void exercise5ExceptionHandling() {
        System.out.println("Übung 5: Versuche, eine nicht existierende Datei zu lesen, und behandle die Exception.");
        System.out.println("(Implementiere den Code selbst - hier ist eine Musterlösung):");

        try {
            Files.readAllLines(Paths.get("nicht_existierende_datei.txt"));
            System.out.println("Datei gelesen (unerwartet).");
        } catch (NoSuchFileException e) {
            System.out.println("Exception korrekt behandelt: " + e.getMessage());
            score++;
            totalQuestions++;
            System.out.println("✓ Übung erfolgreich!\n");
        } catch (IOException e) {
            System.out.println("Andere IOException: " + e.getMessage());
        }
        System.out.println("✗ Übung nicht erfolgreich.\n");
    }

    private static void showResults() {
        System.out.println("=== Quiz Ergebnis ===");
        System.out.println("Richtige Antworten: " + score + " von " + totalQuestions);
        double percentage = (double) score / totalQuestions * 100;
        System.out.printf("Prozentsatz: %.1f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("🎉 Ausgezeichnet! Du beherrschst File I/O!");
        } else if (percentage >= 60) {
            System.out.println("👍 Gut! Übe noch ein bisschen mehr.");
        } else {
            System.out.println("📚 Du solltest die Grundlagen noch einmal durchgehen.");
        }

        System.out.println("\n=== Wichtige Lernpunkte ===");
        System.out.println("• Verwende immer try-with-resources für Streams");
        System.out.println("• IOException ist die häufigste Exception bei I/O");
        System.out.println("• NIO.2 bietet moderne, effizientere APIs");
        System.out.println("• Überprüfe immer, ob Dateien existieren");
        System.out.println("• Schließe Ressourcen ordnungsgemäß");
    }

    private static void cleanupTestFiles() {
        String[] files = {"quiz_data.txt", "quiz_binary.dat", "hello.txt", "quiz_data_copy.txt"};

        for (String file : files) {
            try {
                Files.deleteIfExists(Paths.get(file));
            } catch (IOException e) {
                System.out.println("Fehler beim Löschen von " + file + ": " + e.getMessage());
            }
        }
        System.out.println("Quiz-Dateien aufgeräumt.");
    }
}
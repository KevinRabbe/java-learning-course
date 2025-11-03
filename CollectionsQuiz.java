/**
 * CollectionsQuiz.java
 * Kleine Übungen und Quiz-Fragen zu Collections in Java
 */

import java.util.*;

public class CollectionsQuiz {
    public static void main(String[] args) {
        System.out.println("=== Collections Quiz in Java ===\n");

        // Quiz-Fragen und Antworten
        System.out.println("Quiz-Fragen zu Collections:");
        System.out.println("1. Was ist der Unterschied zwischen ArrayList und LinkedList?");
        System.out.println("   Antwort: ArrayList ist besser für zufälligen Zugriff (get), LinkedList für häufige Einfügungen/Löschungen am Anfang/Ende.\n");

        System.out.println("2. Wie fügst du ein Element in eine HashMap ein?");
        System.out.println("   Antwort: Mit put(key, value), z.B. map.put(\"Schlüssel\", \"Wert\");\n");

        System.out.println("3. Was passiert, wenn du einen bestehenden Schlüssel in einer HashMap überschreibst?");
        System.out.println("   Antwort: Der alte Wert wird ersetzt.\n");

        // Kleine Übung 1: ArrayList füllen und ausgeben
        System.out.println("Übung 1: Erstelle eine ArrayList mit 5 Namen und gib sie aus.");
        ArrayList<String> namen = new ArrayList<>();
        namen.add("Anna");
        namen.add("Max");
        namen.add("Lisa");
        namen.add("Paul");
        namen.add("Zoe");
        System.out.println("Lösung: " + namen + "\n");

        // Kleine Übung 2: HashMap mit Städten
        System.out.println("Übung 2: Erstelle eine HashMap mit Stadt-Land Paaren und gib eine Stadt aus.");
        HashMap<String, String> staedte = new HashMap<>();
        staedte.put("Berlin", "Deutschland");
        staedte.put("Paris", "Frankreich");
        staedte.put("Rom", "Italien");
        System.out.println("Lösung: Paris ist in " + staedte.get("Paris") + "\n");

        // Kleine Übung 3: LinkedList als Queue
        System.out.println("Übung 3: Verwende LinkedList als Warteschlange (Queue).");
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Erster");
        queue.add("Zweiter");
        queue.add("Dritter");
        System.out.println("Warteschlange: " + queue);
        System.out.println("Entferne erstes Element: " + queue.poll());
        System.out.println("Warteschlange danach: " + queue + "\n");

        // Multiple Choice Quiz
        System.out.println("Multiple Choice:");
        System.out.println("4. Welche Methode entfernt ein Element aus einer ArrayList nach Index?");
        System.out.println("   a) delete(index)");
        System.out.println("   b) remove(index)");
        System.out.println("   c) erase(index)");
        System.out.println("   Antwort: b) remove(index)\n");

        System.out.println("5. Was gibt keySet() in einer HashMap zurück?");
        System.out.println("   a) Eine Liste der Werte");
        System.out.println("   b) Eine Menge der Schlüssel");
        System.out.println("   c) Eine Map der Einträge");
        System.out.println("   Antwort: b) Eine Menge der Schlüssel\n");

        // Praktische Übung: Wortzähler
        System.out.println("Praktische Übung: Zähle die Wörter in einem Satz.");
        String satz = "Java ist eine Programmiersprache. Java ist beliebt.";
        String[] woerter = satz.split("\\s+");
        HashMap<String, Integer> wortZaehler = new HashMap<>();
        for (String wort : woerter) {
            wort = wort.toLowerCase().replaceAll("[^a-zäöüß]", "");
            if (!wort.isEmpty()) {
                wortZaehler.put(wort, wortZaehler.getOrDefault(wort, 0) + 1);
            }
        }
        System.out.println("Wortzählung: " + wortZaehler);
        System.out.println("Häufigstes Wort: java (2 mal)\n");

        System.out.println("Quiz beendet! Wiederhole die Übungen, um zu lernen.");
    }
}
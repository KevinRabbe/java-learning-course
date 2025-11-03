/**
 * HashMapDemo.java
 * Demonstration von HashMap in Java
 */

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        System.out.println("=== HashMap in Java ===\n");

        // 1. Erstellen einer HashMap
        System.out.println("--- Erstellen einer HashMap ---");
        HashMap<String, Integer> altersMap = new HashMap<>();
        System.out.println("Leere HashMap erstellt: " + altersMap);
        System.out.println("Größe: " + altersMap.size());

        // 2. Elemente hinzufügen (put)
        System.out.println("\n--- Elemente hinzufügen ---");
        altersMap.put("Anna", 25);
        altersMap.put("Max", 30);
        altersMap.put("Lisa", 28);
        System.out.println("Nach Hinzufügen: " + altersMap);
        System.out.println("Größe: " + altersMap.size());

        // Überschreiben eines Werts
        altersMap.put("Anna", 26);
        System.out.println("Nach Überschreiben von Anna: " + altersMap);

        // 3. Elemente abrufen (get)
        System.out.println("\n--- Elemente abrufen ---");
        System.out.println("Alter von Anna: " + altersMap.get("Anna"));
        System.out.println("Alter von Max: " + altersMap.get("Max"));
        System.out.println("Alter von Peter (nicht vorhanden): " + altersMap.get("Peter")); // null

        // 4. Prüfen auf Vorhandensein
        System.out.println("\n--- Prüfen auf Vorhandensein ---");
        System.out.println("Enthält Schlüssel 'Anna'? " + altersMap.containsKey("Anna"));
        System.out.println("Enthält Schlüssel 'Peter'? " + altersMap.containsKey("Peter"));
        System.out.println("Enthält Wert 30? " + altersMap.containsValue(30));
        System.out.println("Enthält Wert 35? " + altersMap.containsValue(35));

        // 5. Elemente entfernen (remove)
        System.out.println("\n--- Elemente entfernen ---");
        altersMap.remove("Lisa");
        System.out.println("Nach Entfernen von Lisa: " + altersMap);

        // 6. Iteration über die Map
        System.out.println("\n--- Iteration über die Map ---");
        System.out.println("Mit keySet():");
        for (String name : altersMap.keySet()) {
            System.out.println(" - " + name + ": " + altersMap.get(name));
        }

        System.out.println("Mit entrySet():");
        for (Map.Entry<String, Integer> entry : altersMap.entrySet()) {
            System.out.println(" - " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Mit values():");
        for (Integer alter : altersMap.values()) {
            System.out.println(" - Alter: " + alter);
        }

        // 7. HashMap mit anderen Datentypen
        System.out.println("\n--- HashMap mit String-Keys und String-Values ---");
        HashMap<String, String> stadtMap = new HashMap<>();
        stadtMap.put("Berlin", "Deutschland");
        stadtMap.put("Paris", "Frankreich");
        stadtMap.put("Rom", "Italien");
        System.out.println("Stadt-Land Map: " + stadtMap);

        // 8. Map leeren
        System.out.println("\n--- Map leeren ---");
        altersMap.clear();
        System.out.println("Nach clear(): " + altersMap);
        System.out.println("Ist leer? " + altersMap.isEmpty());

        // 9. Praktisches Beispiel: Zählung
        System.out.println("\n--- Praktisches Beispiel: Wortzählung ---");
        String text = "Java ist eine Programmiersprache. Java ist objektorientiert.";
        String[] woerter = text.split("\\s+");
        HashMap<String, Integer> wortZaehler = new HashMap<>();

        for (String wort : woerter) {
            wort = wort.toLowerCase().replaceAll("[^a-zäöüß]", ""); // Bereinigung
            if (!wort.isEmpty()) {
                wortZaehler.put(wort, wortZaehler.getOrDefault(wort, 0) + 1);
            }
        }

        System.out.println("Wortzählung: " + wortZaehler);
    }
}
import java.util.HashMap;
import java.util.Map;

/**
 * HashMapBeispiele.java
 * 
 * Demonstriert die Arbeit mit HashMap in Java.
 * HashMap speichert Key-Value Paare.
 */

public class HashMapBeispiele {
    
    public static void main(String[] args) {
        
        System.out.println("=== HASHMAP IN JAVA ===\n");
        
        // HashMap erstellen
        HashMap<String, Integer> alter = new HashMap<>();
        HashMap<String, String> hauptstaedte = new HashMap<>();
        
        // Elemente hinzufügen
        alter.put("Anna", 25);
        alter.put("Ben", 30);
        alter.put("Clara", 22);
        alter.put("David", 28);
        
        hauptstaedte.put("Deutschland", "Berlin");
        hauptstaedte.put("Frankreich", "Paris");
        hauptstaedte.put("Italien", "Rom");
        hauptstaedte.put("Spanien", "Madrid");
        
        System.out.println("Alter: " + alter);
        System.out.println("Hauptstädte: " + hauptstaedte);
        System.out.println();
        
        // Werte abrufen
        System.out.println("--- Werte abrufen ---");
        System.out.println("Alter von Anna: " + alter.get("Anna"));
        System.out.println("Hauptstadt von Deutschland: " + hauptstaedte.get("Deutschland"));
        System.out.println();
        
        // HashMap durchlaufen
        System.out.println("--- HashMap durchlaufen ---");
        for (Map.Entry<String, Integer> entry : alter.entrySet()) {
            System.out.println(entry.getKey() + " ist " + entry.getValue() + " Jahre alt.");
        }
        
        System.out.println("\n=== ENDE ===");
    }
}
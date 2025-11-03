/**
 * ArrayListDemo.java
 * Demonstration von ArrayList in Java
 */

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("=== ArrayList in Java ===\n");

        // 1. Erstellen einer ArrayList
        System.out.println("--- Erstellen einer ArrayList ---");
        ArrayList<String> namen = new ArrayList<>();
        System.out.println("Leere Liste erstellt: " + namen);
        System.out.println("Größe: " + namen.size());

        // 2. Elemente hinzufügen
        System.out.println("\n--- Elemente hinzufügen ---");
        namen.add("Anna");
        namen.add("Max");
        namen.add("Lisa");
        System.out.println("Nach Hinzufügen: " + namen);
        System.out.println("Größe: " + namen.size());

        // Element an bestimmter Position hinzufügen
        namen.add(1, "Paul");
        System.out.println("Nach Einfügen an Index 1: " + namen);

        // 3. Elemente abrufen
        System.out.println("\n--- Elemente abrufen ---");
        System.out.println("Element an Index 0: " + namen.get(0));
        System.out.println("Element an Index 2: " + namen.get(2));

        // 4. Elemente ändern
        System.out.println("\n--- Elemente ändern ---");
        namen.set(1, "Peter");
        System.out.println("Nach Ändern von Index 1: " + namen);

        // 5. Elemente entfernen
        System.out.println("\n--- Elemente entfernen ---");
        namen.remove(2);
        System.out.println("Nach Entfernen von Index 2: " + namen);

        // Element nach Wert entfernen
        namen.remove("Lisa");
        System.out.println("Nach Entfernen von 'Lisa': " + namen);

        // 6. Prüfen auf Vorhandensein
        System.out.println("\n--- Prüfen auf Vorhandensein ---");
        System.out.println("Enthält 'Max'? " + namen.contains("Max"));
        System.out.println("Enthält 'Lisa'? " + namen.contains("Lisa"));

        // Index eines Elements finden
        int index = namen.indexOf("Peter");
        System.out.println("Index von 'Peter': " + index);

        // 7. Iteration über die Liste
        System.out.println("\n--- Iteration über die Liste ---");
        System.out.println("Mit for-each Schleife:");
        for (String name : namen) {
            System.out.println(" - " + name);
        }

        System.out.println("Mit for-Schleife:");
        for (int i = 0; i < namen.size(); i++) {
            System.out.println("Index " + i + ": " + namen.get(i));
        }

        // 8. ArrayList mit anderen Datentypen
        System.out.println("\n--- ArrayList mit Integern ---");
        ArrayList<Integer> zahlen = new ArrayList<>();
        zahlen.add(10);
        zahlen.add(20);
        zahlen.add(30);
        System.out.println("Integer-Liste: " + zahlen);

        // Autoboxing/Unboxing
        int summe = 0;
        for (int zahl : zahlen) {
            summe += zahl; // Unboxing automatisch
        }
        System.out.println("Summe: " + summe);

        // 9. Liste leeren
        System.out.println("\n--- Liste leeren ---");
        namen.clear();
        System.out.println("Nach clear(): " + namen);
        System.out.println("Ist leer? " + namen.isEmpty());
    }
}
/**
 * LinkedListDemo.java
 * Demonstration von LinkedList in Java
 */

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("=== LinkedList in Java ===\n");

        // 1. Erstellen einer LinkedList
        System.out.println("--- Erstellen einer LinkedList ---");
        LinkedList<String> namen = new LinkedList<>();
        System.out.println("Leere LinkedList erstellt: " + namen);
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

        // Elemente am Anfang und Ende hinzufügen
        namen.addFirst("Zoe");
        namen.addLast("Tim");
        System.out.println("Nach addFirst und addLast: " + namen);

        // 3. Elemente abrufen
        System.out.println("\n--- Elemente abrufen ---");
        System.out.println("Erstes Element: " + namen.getFirst());
        System.out.println("Letztes Element: " + namen.getLast());
        System.out.println("Element an Index 2: " + namen.get(2));

        // 4. Elemente entfernen
        System.out.println("\n--- Elemente entfernen ---");
        namen.removeFirst();
        System.out.println("Nach removeFirst: " + namen);

        namen.removeLast();
        System.out.println("Nach removeLast: " + namen);

        namen.remove(2);
        System.out.println("Nach Entfernen von Index 2: " + namen);

        // 5. Prüfen auf Vorhandensein
        System.out.println("\n--- Prüfen auf Vorhandensein ---");
        System.out.println("Enthält 'Max'? " + namen.contains("Max"));
        System.out.println("Ist leer? " + namen.isEmpty());

        // 6. Iteration über die Liste
        System.out.println("\n--- Iteration über die Liste ---");
        System.out.println("Mit for-each Schleife:");
        for (String name : namen) {
            System.out.println(" - " + name);
        }

        // 7. Vergleich mit ArrayList (Performance-Beispiel)
        System.out.println("\n--- Performance-Vergleich ---");
        System.out.println("LinkedList ist gut für häufige Einfügungen/Löschungen am Anfang/Ende.");
        System.out.println("ArrayList ist schneller für zufälligen Zugriff (get).");

        // Einfache Demonstration
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.addFirst(i); // Schnell in LinkedList
        }
        System.out.println("LinkedList Größe nach 100.000 addFirst: " + linkedList.size());

        // 8. Liste leeren
        System.out.println("\n--- Liste leeren ---");
        namen.clear();
        System.out.println("Nach clear(): " + namen);
        System.out.println("Ist leer? " + namen.isEmpty());

        // 9. Praktisches Beispiel: Warteschlange
        System.out.println("\n--- Praktisches Beispiel: Warteschlange (Queue) ---");
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Kunde 1");
        queue.add("Kunde 2");
        queue.add("Kunde 3");

        System.out.println("Warteschlange: " + queue);
        System.out.println("Nächster Kunde: " + queue.poll()); // Entfernt und gibt erstes Element
        System.out.println("Warteschlange nach poll: " + queue);
    }
}
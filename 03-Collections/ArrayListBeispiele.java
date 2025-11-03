import java.util.ArrayList;

/**
 * Beispiele für die Verwendung von ArrayLists in Java.
 */
public class ArrayListBeispiele {
    public static void main(String[] args) {
        // Erstellen einer ArrayList
        ArrayList<String> todoListe = new ArrayList<>();

        // Elemente hinzufügen
        todoListe.add("Einkaufen gehen");
        todoListe.add("Hausaufgaben machen");
        todoListe.add("Wäsche waschen");

        // Elemente abrufen
        System.out.println("Erste Aufgabe: " + todoListe.get(0));

        // Elemente modifizieren
        todoListe.set(1, "Mathematik Hausaufgaben machen");
        System.out.println("Aktualisierte zweite Aufgabe: " + todoListe.get(1));

        // Elemente entfernen
        todoListe.remove("Wäsche waschen");
        System.out.println("Aufgaben nach dem Entfernen: " + todoListe);

        // Überprüfen der Größe der ArrayList
        System.out.println("Anzahl der Aufgaben in der Liste: " + todoListe.size());

        // Iterationsmethoden
        System.out.println("Alle Aufgaben in der Liste:");
        for (String aufgabe : todoListe) {
            System.out.println(aufgabe);
        }

        // Nutzung einer for-Schleife
        for (int i = 0; i < todoListe.size(); i++) {
            System.out.println("Aufgabe " + (i + 1) + ": " + todoListe.get(i));
        }
    }
}
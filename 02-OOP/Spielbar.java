/**
 * Spielbar.java
 * 
 * Demonstriert Interfaces in Java.
 * Ein Interface definiert einen Vertrag, den Klassen implementieren müssen.
 */

// Interface Definition
public interface Spielbar {
    
    // Abstrakte Methoden (automatisch public und abstract)
    void spielStarten();
    void spielBeenden();
    void punkteAnzeigen();
    
    // Default-Methode (seit Java 8)
    default void spielInfo() {
        System.out.println("Dies ist ein Spiel!");
    }
    
    // Konstante (automatisch public static final)
    int MAX_PUNKTE = 1000;
}

// Klasse die das Interface implementiert
class Fussballspiel implements Spielbar {
    
    private String teamA;
    private String teamB;
    private int punkteA;
    private int punkteB;
    private boolean istGestartet;
    
    public Fussballspiel(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.punkteA = 0;
        this.punkteB = 0;
        this.istGestartet = false;
    }
    
    @Override
    public void spielStarten() {
        istGestartet = true;
        System.out.println("Fußballspiel startet: " + teamA + " vs " + teamB);
    }
    
    @Override
    public void spielBeenden() {
        istGestartet = false;
        System.out.println("Spiel beendet!");
        punkteAnzeigen();
    }
    
    @Override
    public void punkteAnzeigen() {
        System.out.println("Punkte: " + teamA + " " + punkteA + " : " + punkteB + " " + teamB);
    }
    
    public void torErzielen(String team) {
        if (istGestartet) {
            if (team.equals(teamA)) {
                punkteA++;
                System.out.println("TOR für " + teamA + "!");
            } else if (team.equals(teamB)) {
                punkteB++;
                System.out.println("TOR für " + teamB + "!");
            }
        }
    }
}

// Weitere Klasse die dasselbe Interface implementiert
class Kartenspiel implements Spielbar {
    
    private String spielerName;
    private int punkte;
    
    public Kartenspiel(String spielerName) {
        this.spielerName = spielerName;
        this.punkte = 0;
    }
    
    @Override
    public void spielStarten() {
        System.out.println("Kartenspiel startet! Spieler: " + spielerName);
        punkte = 0;
    }
    
    @Override
    public void spielBeenden() {
        System.out.println("Kartenspiel beendet!");
        punkteAnzeigen();
    }
    
    @Override
    public void punkteAnzeigen() {
        System.out.println(spielerName + " hat " + punkte + " Punkte erreicht.");
    }
    
    public void karteSpielen(int wert) {
        punkte += wert;
        System.out.println("Karte gespielt! Wert: " + wert);
    }
}

// Test-Klasse
class InterfaceTest {
    
    public static void main(String[] args) {
        System.out.println("=== INTERFACES DEMO ===\n");
        
        // Fußballspiel
        Fussballspiel spiel1 = new Fussballspiel("Bayern München", "Borussia Dortmund");
        spiel1.spielStarten();
        spiel1.torErzielen("Bayern München");
        spiel1.torErzielen("Borussia Dortmund");
        spiel1.torErzielen("Bayern München");
        spiel1.spielBeenden();
        
        System.out.println();
        
        // Kartenspiel
        Kartenspiel spiel2 = new Kartenspiel("Kevin");
        spiel2.spielStarten();
        spiel2.karteSpielen(10);
        spiel2.karteSpielen(25);
        spiel2.spielBeenden();
        
        System.out.println();
        
        // Polymorphismus mit Interface
        System.out.println("--- Polymorphismus mit Interface ---");
        Spielbar[] spiele = {spiel1, spiel2};
        
        for (Spielbar spiel : spiele) {
            spiel.spielInfo(); // Default-Methode
            spiel.punkteAnzeigen();
        }
        
        System.out.println("\nMaximale Punkte: " + Spielbar.MAX_PUNKTE);
        
        System.out.println("\n=== ENDE ===");
    }
}

/**
 * WICHTIGE KONZEPTE:
 * 
 * 1. interface = Definiert einen Vertrag (welche Methoden implementiert werden müssen)
 * 2. implements = Klasse implementiert ein Interface
 * 3. Alle Methoden in einem Interface sind automatisch public und abstract
 * 4. Default-Methoden (seit Java 8) haben eine Implementierung
 * 5. Konstanten in Interfaces sind automatisch public static final
 * 6. Eine Klasse kann mehrere Interfaces implementieren
 * 
 * UNTERSCHIED: Abstract Class vs Interface
 * - Abstract Class: Kann Konstruktor, normale Methoden und Attribute haben
 * - Interface: Nur Methodensignaturen (und default-Methoden seit Java 8)
 * - Eine Klasse kann nur von EINER Klasse erben, aber MEHRERE Interfaces implementieren
 * 
 * ÜBUNGEN:
 * 1. Erstelle ein Interface "Druckbar" mit Methode drucken()
 * 2. Implementiere es in Klassen wie Dokument, Bild, Text
 * 3. Erstelle ein Interface "Vergleichbar" zum Vergleichen von Objekten
 */

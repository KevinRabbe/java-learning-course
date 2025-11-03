/**
 * Tier.java
 * Abstrakte Basisklasse für alle Tiere
 * 
 * Eine abstrakte Klasse kann nicht direkt instanziiert werden.
 * Sie dient als Vorlage für abgeleitete Klassen (wie Hund, Katze).
 * Abstrakte Methoden müssen von den abgeleiteten Klassen implementiert werden.
 */

public abstract class Tier {
    
    // ========== ATTRIBUTE ==========
    // protected: Zugriff in dieser Klasse und in abgeleiteten Klassen
    protected String name;
    protected int alter;
    protected double gewicht;
    
    // ========== KONSTRUKTOR ==========
    public Tier(String name, int alter, double gewicht) {
        this.name = name;
        this.alter = alter;
        this.gewicht = gewicht;
    }
    
    // ========== ABSTRAKTE METHODEN ==========
    // Müssen von jeder abgeleiteten Klasse implementiert werden
    public abstract void machGeraeusch();
    public abstract void bewege();
    
    // ========== KONKRETE METHODEN ==========
    // Werden von allen Tieren geteilt und können direkt verwendet werden
    
    public void fressen() {
        System.out.println(name + " frisst.");
        gewicht += 0.1;
    }
    
    public void schlafen() {
        System.out.println(name + " schläft. Zzz...");
    }
    
    public void zeigeInfo() {
        System.out.println("=== Tier-Information ===");
        System.out.println("Name: " + name);
        System.out.println("Alter: " + alter + " Jahre");
        System.out.println("Gewicht: " + String.format("%.2f", gewicht) + " kg");
        System.out.println("Typ: " + this.getClass().getSimpleName());
    }
    
    // ========== GETTER UND SETTER ==========
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAlter() {
        return alter;
    }
    
    public void setAlter(int alter) {
        if (alter >= 0) {
            this.alter = alter;
        }
    }
    
    public double getGewicht() {
        return gewicht;
    }
    
    public void setGewicht(double gewicht) {
        if (gewicht > 0) {
            this.gewicht = gewicht;
        }
    }
    
    // ========== ÜBERLADENE METHODE ==========
    // Method Overloading: Gleicher Name, unterschiedliche Parameter
    public void fressen(String futter) {
        System.out.println(name + " frisst " + futter + ".");
        gewicht += 0.2;
    }
}
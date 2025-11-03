/**
 * Variables.java
 * Dieses Programm demonstriert die Verwendung verschiedener Datentypen in Java
 * und zeigt, wie man Variablen deklariert und initialisiert.
 */

public class Variables {
    public static void main(String[] args) {
        System.out.println("=== Java Datentypen und Variablen ===\n");

        // ========== PRIMITIVE DATENTYPEN ==========
        
        // 1. GANZZAHLEN (Integer Types)
        System.out.println("--- Ganzzahlige Datentypen ---");
        
        // byte: 8-bit, Bereich: -128 bis 127
        byte alterInJahren = 25;
        System.out.println("byte - Alter: " + alterInJahren + " Jahre");
        
        // short: 16-bit, Bereich: -32,768 bis 32,767
        short einwohnerKleinstadt = 15000;
        System.out.println("short - Einwohner: " + einwohnerKleinstadt);
        
        // int: 32-bit, Bereich: -2^31 bis 2^31-1 (Standard für Ganzzahlen)
        int einwohnerGroßstadt = 3500000;
        System.out.println("int - Einwohner Großstadt: " + einwohnerGroßstadt);
        
        // long: 64-bit, Bereich: -2^63 bis 2^63-1 (für sehr große Zahlen)
        long weltbevoelkerung = 7900000000L; // 'L' am Ende für long
        System.out.println("long - Weltbevölkerung: " + weltbevoelkerung);
        
        // 2. GLEITKOMMAZAHLEN (Floating Point Types)
        System.out.println("\n--- Gleitkommazahlen ---");
        
        // float: 32-bit, ca. 6-7 Dezimalstellen
        float temperatur = 23.5f; // 'f' am Ende für float
        System.out.println("float - Temperatur: " + temperatur + "°C");
        
        // double: 64-bit, ca. 15 Dezimalstellen (Standard für Dezimalzahlen)
        double pi = 3.14159265359;
        System.out.println("double - Pi: " + pi);
        
        // 3. ZEICHEN (Character Type)
        System.out.println("\n--- Zeichen ---");
        
        // char: 16-bit, einzelnes Unicode-Zeichen
        char note = 'A';
        char symbol = '€';
        System.out.println("char - Note: " + note);
        System.out.println("char - Symbol: " + symbol);
        
        // 4. BOOLEAN (Wahrheitswert)
        System.out.println("\n--- Boolean ---");
        
        // boolean: true oder false
        boolean istSonnig = true;
        boolean istKalt = false;
        System.out.println("boolean - Ist es sonnig? " + istSonnig);
        System.out.println("boolean - Ist es kalt? " + istKalt);
        
        // ========== REFERENZDATENTYPEN ==========
        System.out.println("\n--- Referenzdatentypen ---");
        
        // String: Zeichenkette (Klasse, kein primitiver Typ)
        String name = "Max Mustermann";
        String begruessung = "Hallo, " + name + "!";
        System.out.println("String - " + begruessung);
        
        // ========== VARIABLEN-DEKLARATION UND INITIALISIERUNG ==========
        System.out.println("\n--- Deklaration und Initialisierung ---");
        
        // Deklaration (Variable wird angelegt, aber nicht initialisiert)
        int zahl1;
        
        // Initialisierung (Wert wird zugewiesen)
        zahl1 = 42;
        System.out.println("Zahl1 nach Initialisierung: " + zahl1);
        
        // Deklaration und Initialisierung in einer Zeile
        int zahl2 = 100;
        System.out.println("Zahl2: " + zahl2);
        
        // Mehrere Variablen gleichen Typs in einer Zeile deklarieren
        int a = 10, b = 20, c = 30;
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);
        
        // ========== KONSTANTEN ==========
        System.out.println("\n--- Konstanten ---");
        
        // final: Wert kann nach Initialisierung nicht mehr geändert werden
        final double MEHRWERTSTEUER = 0.19;
        final int TAGE_IM_JAHR = 365;
        System.out.println("Konstante - Mehrwertsteuer: " + MEHRWERTSTEUER);
        System.out.println("Konstante - Tage im Jahr: " + TAGE_IM_JAHR);
        
        // MEHRWERTSTEUER = 0.20; // Fehler! Konstanten können nicht geändert werden
        
        // ========== TYPE CASTING (Typumwandlung) ==========
        System.out.println("\n--- Type Casting ---");
        
        // Implizites Casting (automatisch, von kleiner zu größer)
        int ganzzahl = 100;
        double kommazahl = ganzzahl; // int wird automatisch zu double
        System.out.println("Implizites Casting - int zu double: " + kommazahl);
        
        // Explizites Casting (manuell, von größer zu kleiner)
        double pi2 = 3.14159;
        int piGerundet = (int) pi2; // double wird manuell zu int (Nachkommastellen gehen verloren)
        System.out.println("Explizites Casting - double zu int: " + piGerundet);
        
        // ========== NAMENSKONVENTIONEN ==========
        System.out.println("\n--- Namenskonventionen ---");
        System.out.println("✓ Variablen: camelCase (z.B. meinAlter, istAktiv)");
        System.out.println("✓ Konstanten: UPPER_CASE (z.B. MAX_WERT, PI)");
        System.out.println("✓ Klassen: PascalCase (z.B. MeineKlasse, Auto)");
        System.out.println("✓ Aussagekräftige Namen verwenden!");
        
        // ========== BEISPIEL-BERECHNUNG ==========
        System.out.println("\n--- Praktisches Beispiel ---");
        
        double preis = 49.99;
        double mwst = preis * MEHRWERTSTEUER;
        double gesamtpreis = preis + mwst;
        
        System.out.println("Nettopreis: " + preis + "€");
        System.out.println("MwSt (19%): " + String.format("%.2f", mwst) + "€");
        System.out.println("Bruttopreis: " + String.format("%.2f", gesamtpreis) + "€");
    }
}
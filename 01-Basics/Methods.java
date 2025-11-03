/**
 * Methods.java
 * Dieses Programm demonstriert die Verwendung von Methoden in Java.
 * Du lernst hier: Methoden definieren, Parameter, Rückgabewerte, 
 * Method Overloading und Variable Scope.
 */

public class Methods {
    
    // ========== KLASSENVARIABLEN (Scope: ganze Klasse) ==========
    static int klassenZaehler = 0;
    
    // ========== MAIN-METHODE (Einstiegspunkt) ==========
    public static void main(String[] args) {
        System.out.println("=== Java Methoden ===\n");
        
        // ========== 1. EINFACHE METHODE OHNE PARAMETER UND RÜCKGABEWERT ==========
        System.out.println("--- Methode ohne Parameter und Rückgabewert ---");
        begruessung();
        
        // ========== 2. METHODE MIT PARAMETER ==========
        System.out.println("\n--- Methode mit Parameter ---");
        begruesseBenutzer("Max");
        begruesseBenutzer("Anna");
        
        // ========== 3. METHODE MIT RÜCKGABEWERT ==========
        System.out.println("\n--- Methode mit Rückgabewert ---");
        int summe = addiere(5, 7);
        System.out.println("5 + 7 = " + summe);
        
        double durchschnitt = berechneDurchschnitt(10, 20, 30);
        System.out.println("Durchschnitt von 10, 20, 30 = " + durchschnitt);
        
        // ========== 4. METHOD OVERLOADING (Methodenüberladung) ==========
        System.out.println("\n--- Method Overloading ---");
        System.out.println("Fläche Rechteck (5 x 3): " + berechneFlaeche(5, 3));
        System.out.println("Fläche Quadrat (4 x 4): " + berechneFlaeche(4));
        System.out.println("Fläche Kreis (r=5): " + berechneFlaeche(5.0));
        
        // ========== 5. VARIABLE SCOPE (Gültigkeitsbereich) ==========
        System.out.println("\n--- Variable Scope ---");
        demonstriereScope();
        
        // ========== 6. PRAKTISCHE BEISPIELE ==========
        System.out.println("\n--- Praktische Beispiele ---");
        
        // Temperatur-Umrechnung
        double celsius = 25.0;
        double fahrenheit = celsiusZuFahrenheit(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        
        // Primzahl-Check
        int zahl = 17;
        if (istPrimzahl(zahl)) {
            System.out.println(zahl + " ist eine Primzahl");
        } else {
            System.out.println(zahl + " ist keine Primzahl");
        }
        
        // Fakultät berechnen
        int n = 5;
        System.out.println("Fakultät von " + n + " = " + berechneFakultaet(n));
        
        // ========== 7. REKURSION (Methode ruft sich selbst auf) ==========
        System.out.println("\n--- Rekursion ---");
        int faktorialZahl = 5;
        System.out.println("Fakultät von " + faktorialZahl + " (rekursiv) = " + fakultaet(faktorialZahl));
        
        // ========== 8. VARARGS (Variable Anzahl von Argumenten) ==========
        System.out.println("\n--- Varargs ---");
        System.out.println("Summe(1,2,3): " + summeVarargs(1, 2, 3));
        System.out.println("Summe(10,20,30,40,50): " + summeVarargs(10, 20, 30, 40, 50));
    }
    
    // ========== METHODEN-DEFINITIONEN ==========
    
    // 1. Methode ohne Parameter und ohne Rückgabewert (void)
    public static void begruessung() {
        System.out.println("Willkommen zum Java-Kurs!");
        System.out.println("Heute lernen wir Methoden.");
    }
    
    // 2. Methode mit einem Parameter
    public static void begruesseBenutzer(String name) {
        System.out.println("Hallo " + name + "! Schön, dass du da bist.");
    }
    
    // 3. Methode mit Rückgabewert (int)
    public static int addiere(int a, int b) {
        int ergebnis = a + b;
        return ergebnis; // Rückgabe des Ergebnisses
    }
    
    // 4. Methode mit mehreren Parametern und Rückgabewert
    public static double berechneDurchschnitt(int zahl1, int zahl2, int zahl3) {
        double summe = zahl1 + zahl2 + zahl3;
        double durchschnitt = summe / 3.0;
        return durchschnitt;
    }
    
    // ========== METHOD OVERLOADING ==========
    // Gleicher Methodenname, unterschiedliche Parameter
    
    // Fläche eines Rechtecks (2 Parameter)
    public static int berechneFlaeche(int laenge, int breite) {
        return laenge * breite;
    }
    
    // Fläche eines Quadrats (1 Parameter)
    public static int berechneFlaeche(int seite) {
        return seite * seite;
    }
    
    // Fläche eines Kreises (1 double Parameter)
    public static double berechneFlaeche(double radius) {
        return Math.PI * radius * radius;
    }
    
    // ========== VARIABLE SCOPE ==========
    public static void demonstriereScope() {
        // Lokale Variable (nur in dieser Methode sichtbar)
        int lokaleVariable = 10;
        System.out.println("Lokale Variable: " + lokaleVariable);
        
        // Klassenvariable (in der ganzen Klasse sichtbar)
        klassenZaehler++;
        System.out.println("Klassenvariable: " + klassenZaehler);
        
        // Block-Scope
        if (true) {
            int blockVariable = 20; // Nur im if-Block sichtbar
            System.out.println("Block Variable: " + blockVariable);
        }
        // System.out.println(blockVariable); // Fehler! Außerhalb des Blocks nicht sichtbar
    }
    
    // ========== PRAKTISCHE METHODEN ==========
    
    // Celsius zu Fahrenheit umrechnen
    public static double celsiusZuFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }
    
    // Prüfen ob eine Zahl eine Primzahl ist
    public static boolean istPrimzahl(int zahl) {
        if (zahl <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(zahl); i++) {
            if (zahl % i == 0) {
                return false; // Teilbar durch i, also keine Primzahl
            }
        }
        
        return true; // Keine Teiler gefunden, also Primzahl
    }
    
    // Fakultät berechnen (iterativ)
    public static int berechneFakultaet(int n) {
        int ergebnis = 1;
        for (int i = 1; i <= n; i++) {
            ergebnis *= i;
        }
        return ergebnis;
    }
    
    // Fakultät berechnen (rekursiv)
    public static int fakultaet(int n) {
        if (n <= 1) {
            return 1; // Basisfall: Rekursion endet hier
        }
        return n * fakultaet(n - 1); // Rekursiver Aufruf
    }
    
    // Varargs: Variable Anzahl von Parametern
    public static int summeVarargs(int... zahlen) {
        int summe = 0;
        for (int zahl : zahlen) {
            summe += zahl;
        }
        return summe;
    }
    
    /*
     * WICHTIGE KONZEPTE:
     * 
     * 1. METHODENSIGNATUR: Name + Parameter (ohne Rückgabetyp)
     * 2. RÜCKGABEWERT: Typ vor dem Methodennamen (int, double, String, void)
     * 3. void: Methode gibt nichts zurück
     * 4. return: Beendet Methode und gibt Wert zurück
     * 5. OVERLOADING: Gleicher Name, unterschiedliche Parameter
     * 6. SCOPE: Gültigkeitsbereich von Variablen
     * 7. REKURSION: Methode ruft sich selbst auf
     * 8. VARARGS: int... erlaubt beliebig viele Parameter
     * 
     * NAMENSKONVENTIONEN:
     * - Methoden: camelCase (z.B. berechneFlaeche, istPrimzahl)
     * - Verben verwenden (get, set, calculate, check, is, etc.)
     * - Aussagekräftige Namen!
     */
}
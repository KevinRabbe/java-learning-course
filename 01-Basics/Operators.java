/**
 * Operators.java
 * 
 * Hier lernst du alle wichtigen Operatoren in Java kennen!
 */

public class Operators {
    
    public static void main(String[] args) {
        
        System.out.println("=== JAVA OPERATOREN ===");
        System.out.println();
        
        // ============================================
        // 1. ARITHMETISCHE OPERATOREN
        // ============================================
        
        int a = 10;
        int b = 3;
        
        System.out.println("--- Arithmetische Operatoren ---");
        System.out.println("a = " + a + ", b = " + b);
        
        // Addition
        int summe = a + b;
        System.out.println("Addition: " + a + " + " + b + " = " + summe);
        
        // Subtraktion
        int differenz = a - b;
        System.out.println("Subtraktion: " + a + " - " + b + " = " + differenz);
        
        // Multiplikation
        int produkt = a * b;
        System.out.println("Multiplikation: " + a + " * " + b + " = " + produkt);
        
        // Division
        int quotient = a / b;
        System.out.println("Division: " + a + " / " + b + " = " + quotient);
        
        // Modulo (Rest)
        int rest = a % b;
        System.out.println("Modulo: " + a + " % " + b + " = " + rest);
        
        System.out.println();
        
        // ============================================
        // 2. INKREMENT UND DEKREMENT
        // ============================================
        
        System.out.println("--- Inkrement und Dekrement ---");
        
        int x = 5;
        System.out.println("x = " + x);
        
        // Post-Inkrement (erst verwenden, dann erhöhen)
        System.out.println("x++ = " + (x++)); // gibt 5 aus
        System.out.println("x nach x++ = " + x); // jetzt ist x = 6
        
        // Pre-Inkrement (erst erhöhen, dann verwenden)
        System.out.println("++x = " + (++x)); // gibt 7 aus
        
        // Post-Dekrement
        System.out.println("x-- = " + (x--)); // gibt 7 aus
        System.out.println("x nach x-- = " + x); // jetzt ist x = 6
        
        // Pre-Dekrement
        System.out.println("--x = " + (--x)); // gibt 5 aus
        
        System.out.println();
        
        // ============================================
        // 3. VERGLEICHSOPERATOREN
        // ============================================
        
        System.out.println("--- Vergleichsoperatoren ---");
        
        int zahl1 = 10;
        int zahl2 = 20;
        
        System.out.println("zahl1 = " + zahl1 + ", zahl2 = " + zahl2);
        
        // Gleich
        System.out.println("zahl1 == zahl2: " + (zahl1 == zahl2)); // false
        
        // Ungleich
        System.out.println("zahl1 != zahl2: " + (zahl1 != zahl2)); // true
        
        // Größer als
        System.out.println("zahl1 > zahl2: " + (zahl1 > zahl2)); // false
        
        // Kleiner als
        System.out.println("zahl1 < zahl2: " + (zahl1 < zahl2)); // true
        
        // Größer oder gleich
        System.out.println("zahl1 >= zahl2: " + (zahl1 >= zahl2)); // false
        
        // Kleiner oder gleich
        System.out.println("zahl1 <= zahl2: " + (zahl1 <= zahl2)); // true
        
        System.out.println();
        
        // ============================================
        // 4. LOGISCHE OPERATOREN
        // ============================================
        
        System.out.println("--- Logische Operatoren ---");
        
        boolean istSonnig = true;
        boolean istWarm = true;
        boolean istRegnerisch = false;
        
        // UND (&&) - beide müssen true sein
        System.out.println("istSonnig && istWarm: " + (istSonnig && istWarm)); // true
        System.out.println("istSonnig && istRegnerisch: " + (istSonnig && istRegnerisch)); // false
        
        // ODER (||) - mindestens einer muss true sein
        System.out.println("istSonnig || istRegnerisch: " + (istSonnig || istRegnerisch)); // true
        System.out.println("istWarm || istRegnerisch: " + (istWarm || istRegnerisch)); // true
        
        // NICHT (!) - kehrt den Wert um
        System.out.println("!istSonnig: " + (!istSonnig)); // false
        System.out.println("!istRegnerisch: " + (!istRegnerisch)); // true
        
        System.out.println();
        
        // ============================================
        // 5. ZUWEISUNGSOPERATOREN
        // ============================================
        
        System.out.println("--- Zuweisungsoperatoren ---");
        
        int wert = 10;
        System.out.println("Anfangswert: " + wert);
        
        // Einfache Zuweisung
        wert = 20;
        System.out.println("wert = 20: " + wert);
        
        // Addition mit Zuweisung
        wert += 5; // entspricht: wert = wert + 5
        System.out.println("wert += 5: " + wert);
        
        // Subtraktion mit Zuweisung
        wert -= 3; // entspricht: wert = wert - 3
        System.out.println("wert -= 3: " + wert);
        
        // Multiplikation mit Zuweisung
        wert *= 2; // entspricht: wert = wert * 2
        System.out.println("wert *= 2: " + wert);
        
        // Division mit Zuweisung
        wert /= 4; // entspricht: wert = wert / 4
        System.out.println("wert /= 4: " + wert);
        
        // Modulo mit Zuweisung
        wert %= 3; // entspricht: wert = wert % 3
        System.out.println("wert %= 3: " + wert);
        
        System.out.println();
        
        // ============================================
        // 6. TERNÄRER OPERATOR (Bedingungsoperator)
        // ============================================
        
        System.out.println("--- Ternärer Operator ---");
        
        int alter = 18;
        String status = (alter >= 18) ? "Erwachsen" : "Minderjährig";
        System.out.println("Alter: " + alter + ", Status: " + status);
        
        int punkte = 75;
        String note = (punkte >= 90) ? "Sehr gut" : 
                      (punkte >= 75) ? "Gut" : 
                      (punkte >= 60) ? "Befriedigend" : "Nicht bestanden";
        System.out.println("Punkte: " + punkte + ", Note: " + note);
        
        System.out.println();
        System.out.println("=== ENDE ===");
    }
}

/**
 * ÜBUNGEN:
 * 1. Berechne den Durchschnitt von drei Zahlen
 * 2. Prüfe, ob eine Zahl gerade oder ungerade ist (mit %)
 * 3. Finde die größere von zwei Zahlen mit dem ternären Operator
 * 4. Schreibe ein Programm, das die Temperatur in Celsius in Fahrenheit umrechnet
 */
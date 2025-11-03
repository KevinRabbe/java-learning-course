/**
 * ControlFlow.java
 * 
 * Hier lernst du alle Kontrollstrukturen in Java kennen!
 * Kontrollstrukturen steuern den Ablauf deines Programms.
 */

public class ControlFlow {
    
    public static void main(String[] args) {
        
        System.out.println("=== JAVA KONTROLLSTRUKTUREN ===");
        System.out.println();
        
        // ============================================
        // 1. IF-ELSE STATEMENTS
        // ============================================
        
        System.out.println("--- if-else ---");
        
        // Einfaches if
        int alter = 20;
        if (alter >= 18) {
            System.out.println("Du bist volljährig!");
        }
        
        // if-else
        int temperatur = 15;
        if (temperatur > 20) {
            System.out.println("Es ist warm!");
        } else {
            System.out.println("Es ist kalt!");
        }
        
        // if-else-if-else
        int punkte = 85;
        if (punkte >= 90) {
            System.out.println("Note: Sehr gut");
        } else if (punkte >= 75) {
            System.out.println("Note: Gut");
        } else if (punkte >= 60) {
            System.out.println("Note: Befriedigend");
        } else if (punkte >= 50) {
            System.out.println("Note: Ausreichend");
        } else {
            System.out.println("Note: Nicht bestanden");
        }
        
        System.out.println();
        
        // ============================================
        // 2. SWITCH-CASE STATEMENTS
        // ============================================
        
        System.out.println("--- switch-case ---");
        
        int tag = 3;
        switch (tag) {
            case 1:
                System.out.println("Montag");
                break;
            case 2:
                System.out.println("Dienstag");
                break;
            case 3:
                System.out.println("Mittwoch");
                break;
            default:
                System.out.println("Anderer Tag");
                break;
        }
        
        System.out.println();
        
        // ============================================
        // 3. FOR-SCHLEIFE
        // ============================================
        
        System.out.println("--- for-Schleife ---");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        
        System.out.println();
        
        // ============================================
        // 4. WHILE-SCHLEIFE
        // ============================================
        
        System.out.println("--- while-Schleife ---");
        
        int zaehler = 1;
        while (zaehler <= 5) {
            System.out.println(zaehler);
            zaehler++;
        }
        
        System.out.println();
        System.out.println("=== ENDE ===");
    }
}
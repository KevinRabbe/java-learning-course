/**
 * ArrayBeispiele.java
 * 
 * Demonstriert die Arbeit mit Arrays in Java.
 * Arrays sind feste Datenstrukturen mit fester Größe.
 */

public class ArrayBeispiele {
    
    public static void main(String[] args) {
        
        System.out.println("=== ARRAYS IN JAVA ===\n");
        
        // Array Deklaration
        int[] zahlen = new int[5];
        zahlen[0] = 10;
        zahlen[1] = 20;
        zahlen[2] = 30;
        zahlen[3] = 40;
        zahlen[4] = 50;
        
        String[] namen = {"Anna", "Ben", "Clara", "David"};
        
        // Array durchlaufen
        System.out.println("--- Array durchlaufen ---");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.println("Index " + i + ": " + zahlen[i]);
        }
        
        System.out.println();
        
        for (String name : namen) {
            System.out.println(name);
        }
        
        System.out.println("\n=== ENDE ===");
    }
}
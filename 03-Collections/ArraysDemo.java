/**
 * ArraysDemo.java
 * Demonstration von Arrays in Java
 */

public class ArraysDemo {
    public static void main(String[] args) {
        System.out.println("=== Arrays in Java ===\n");

        // 1. Eindimensionale Arrays
        System.out.println("--- Eindimensionale Arrays ---");
        
        // Deklaration und Initialisierung
        int[] zahlen = {10, 20, 30, 40, 50};
        
        // Zugriff auf Elemente
        System.out.println("Erstes Element: " + zahlen[0]);
        System.out.println("Letztes Element: " + zahlen[zahlen.length - 1]);
        
        // Ändern eines Elements
        zahlen[2] = 35;
        System.out.println("Geändertes Element an Index 2: " + zahlen[2]);
        
        // Durchlaufen mit for-Schleife
        System.out.print("Alle Elemente: ");
        for (int i = 0; i < zahlen.length; i++) {
            System.out.print(zahlen[i] + " ");
        }
        System.out.println();
        
        // Durchlaufen mit for-each
        System.out.print("Alle Elemente (for-each): ");
        for (int zahl : zahlen) {
            System.out.print(zahl + " ");
        }
        System.out.println();
        
        // 2. Mehrdimensionale Arrays (2D)
        System.out.println("\n--- Mehrdimensionale Arrays ---");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix-Element [1][2]: " + matrix[1][2]);
        
        // Durchlaufen einer 2D-Array
        System.out.println("Ganze Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // 3. Array-Operationen
        System.out.println("\n--- Array-Operationen ---");
        
        // Kopieren eines Arrays
        int[] original = {1, 2, 3, 4, 5};
        int[] kopie = new int[original.length];
        System.arraycopy(original, 0, kopie, 0, original.length);
        
        System.out.print("Original: ");
        for (int num : original) System.out.print(num + " ");
        System.out.print("\nKopie: ");
        for (int num : kopie) System.out.print(num + " ");
        System.out.println();
        
        // Suchen in einem Array
        int gesucht = 3;
        boolean gefunden = false;
        for (int i = 0; i < original.length; i++) {
            if (original[i] == gesucht) {
                System.out.println(gesucht + " gefunden an Index " + i);
                gefunden = true;
                break;
            }
        }
        if (!gefunden) {
            System.out.println(gesucht + " nicht gefunden");
        }
        
        // Sortieren (einfach Bubble Sort)
        int[] unsortiert = {5, 2, 8, 1, 9};
        System.out.print("Unsortiert: ");
        for (int num : unsortiert) System.out.print(num + " ");
        
        for (int i = 0; i < unsortiert.length - 1; i++) {
            for (int j = 0; j < unsortiert.length - i - 1; j++) {
                if (unsortiert[j] > unsortiert[j + 1]) {
                    int temp = unsortiert[j];
                    unsortiert[j] = unsortiert[j + 1];
                    unsortiert[j + 1] = temp;
                }
            }
        }
        
        System.out.print("\nSortiert: ");
        for (int num : unsortiert) System.out.print(num + " ");
        System.out.println();
    }
}
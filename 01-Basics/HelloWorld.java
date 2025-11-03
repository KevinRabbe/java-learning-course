/**
 * HelloWorld.java
 * 
 * Dies ist dein erstes Java-Programm!
 * 
 * Jedes Java-Programm beginnt mit einer Klasse.
 * Der Klassenname MUSS mit dem Dateinamen übereinstimmen.
 */

public class HelloWorld {
    
    /**
     * Die main-Methode ist der Einstiegspunkt jedes Java-Programms.
     * Hier beginnt die Ausführung.
     * 
     * @param args - Kommandozeilenargumente (wird später erklärt)
     */
    public static void main(String[] args) {
        
        // System.out.println() gibt Text in der Konsole aus
        System.out.println("Hallo Welt!");
        System.out.println("Willkommen bei Java!");
        
        // Du kannst auch Zahlen ausgeben
        System.out.println(42);
        System.out.println(3.14);
        
        // Mathematische Operationen
        System.out.println("5 + 3 = " + (5 + 3));
        System.out.println("10 - 4 = " + (10 - 4));
        System.out.println("6 * 7 = " + (6 * 7));
        
        // System.out.print() gibt ohne Zeilenumbruch aus
        System.out.print("Dies steht ");
        System.out.print("in einer Zeile!");
        System.out.println(); // Leere Zeile
        
        // Formatierte Ausgabe
        String name = "Kevin";
        int alter = 25;
        System.out.println("Mein Name ist " + name + " und ich bin " + alter + " Jahre alt.");
        
        // Moderne Variante mit String.format()
        System.out.println(String.format("Hallo, ich bin %s und %d Jahre alt!", name, alter));
    }
}

/**
 * SO FÜHRST DU DIESES PROGRAMM AUS:
 * 
 * 1. Öffne das Terminal/Kommandozeile
 * 2. Navigiere zu diesem Ordner
 * 3. Kompiliere: javac HelloWorld.java
 * 4. Führe aus: java HelloWorld
 * 
 * EXPERIMENTIERE:
 * - Ändere den Text in den println-Anweisungen
 * - Füge weitere println-Anweisungen hinzu
 * - Probiere verschiedene mathematische Operationen
 */
# Modul 5: File I/O - Dateiverwaltung

Willkommen zu Modul 5! Hier lernst du die Grundlagen der Dateiverwaltung in Java kennen - wie du Dateien lesen, schreiben und bearbeiten kannst.

## 📚 Themen in diesem Modul

### 1. Grundlagen der Dateiverwaltung
- Dateien und Verzeichnisse verstehen
- File-Klasse verwenden
- Pfade und absolute/relative Pfade

### 2. Dateien lesen
- Textdateien mit FileReader und BufferedReader lesen
- Binäre Dateien mit FileInputStream lesen
- try-with-resources für sichere Ressourcenverwaltung

### 3. Dateien schreiben
- Textdateien mit FileWriter und PrintWriter schreiben
- Binäre Dateien mit FileOutputStream schreiben
- Anhängen vs. Überschreiben

### 4. Fortgeschrittene Dateioperationen
- Dateien kopieren
- Dateien verschieben/umbenennen
- Dateien löschen
- Verzeichnisse erstellen und durchlaufen

### 5. Exception Handling bei I/O
- IOException behandeln
- FileNotFoundException
- Ressourcen ordnungsgemäß schließen

### 6. NIO.2 (New I/O)
- Path und Paths verwenden
- Files-Klasse für moderne Operationen
- DirectoryStream für Verzeichnisdurchlauf

## 🎯 Lernziele

Nach diesem Modul kannst du:
- ✅ Dateien sicher lesen und schreiben
- ✅ Mit verschiedenen Dateitypen arbeiten
- ✅ Exception Handling bei I/O-Operationen anwenden
- ✅ Verzeichnisse verwalten
- ✅ Moderne NIO.2 APIs verwenden
- ✅ Ressourcen ordnungsgemäß freigeben

## 📝 Dateien in diesem Modul

1. **FileBasics.java** - Grundlagen mit File-Klasse
2. **ReadingFiles.java** - Verschiedene Methoden zum Lesen von Dateien
3. **WritingFiles.java** - Schreiben von Text- und Binärdateien
4. **AdvancedOperations.java** - Kopieren, Verschieben, Löschen
5. **NIOExample.java** - Moderne NIO.2 APIs
6. **FileIOQuiz.java** - Übungen und Quiz-Fragen

## 🚀 Los geht's!

Beginne mit FileBasics.java, um die Grundlagen zu lernen. Erstelle Testdateien in einem separaten Ordner, um sicher zu experimentieren!

## 💡 Tipps

- Verwende immer try-with-resources für Streams.
- Schließe niemals Ressourcen manuell, wenn möglich.
- Überprüfe immer, ob Dateien existieren, bevor du sie liest.
- Verwende absolute Pfade für Produktionscode.
- Teste mit kleinen Dateien zuerst.

## 📚 Ressourcen

- [Oracle Java Tutorials: File I/O](https://docs.oracle.com/javase/tutorial/essential/io/index.html)
- [Java API Dokumentation: java.io](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/package-summary.html)
- [Java API Dokumentation: java.nio](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/nio/package-summary.html)
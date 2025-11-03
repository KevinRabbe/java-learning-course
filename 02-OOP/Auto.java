public class Auto {
    // Attribute
    private String marke;
    private String modell;
    private int baujahr;
    private String farbe;
    private int kilometerstand;
    private boolean istGestartet;

    // Konstruktor
    public Auto(String marke, String modell, int baujahr, String farbe) {
        this.marke = marke;
        this.modell = modell;
        this.baujahr = baujahr;
        this.farbe = farbe;
        this.kilometerstand = 0; // Initialer Kilometerstand
        this.istGestartet = false;
    }

    // Getter-Methoden
    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public String getFarbe() {
        return farbe;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public boolean isGestartet() {
        return istGestartet;
    }

    // Setter-Methoden
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    // Methoden
    public void starten() {
        if (!istGestartet) {
            istGestartet = true;
            System.out.println("Das Auto wurde gestartet.");
        } else {
            System.out.println("Das Auto ist bereits gestartet.");
        }
    }

    public void stoppen() {
        if (istGestartet) {
            istGestartet = false;
            System.out.println("Das Auto wurde gestoppt.");
        } else {
            System.out.println("Das Auto ist bereits gestoppt.");
        }
    }

    public void fahren(int kilometer) {
        if (istGestartet) {
            kilometerstand += kilometer;
            System.out.println("Das Auto ist gefahren: " + kilometer + " km.");
        } else {
            System.out.println("Das Auto muss zuerst gestartet werden.");
        }
    }

    public void hupen() {
        System.out.println("Hup Hup!");
    }

    public void zeigeInfo() {
        System.out.println("Marke: " + marke);
        System.out.println("Modell: " + modell);
        System.out.println("Baujahr: " + baujahr);
        System.out.println("Farbe: " + farbe);
        System.out.println("Kilometerstand: " + kilometerstand + " km");
        System.out.println("Ist gestartet: " + (istGestartet ? "Ja" : "Nein"));
    }

    public static void main(String[] args) {
        Auto meinAuto = new Auto("Volkswagen", "Golf", 2020, "Blau");
        meinAuto.zeigeInfo();
        meinAuto.starten();
        meinAuto.fahren(50);
        meinAuto.hupen();
        meinAuto.stoppen();
        meinAuto.zeigeInfo();
    }
}
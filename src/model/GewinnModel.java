package model;

/**
 * Spiellogik des einfachen Spieles
 * @author Muhammed Guerle
 * 23/09/2026
 */
public class GewinnModel {

    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() { // Startet mit 30 Punkten
        gesamtPunkte = 30;
        spielerZahl = 0;
        computerZahl = 0;
        rundenErgebnis = 0;
    }
    // Getter für Punkte, Computerzahl und Rundenergebnis
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public void berechneComputerZahl() {// Zufallszahl von 1 bis 9
        computerZahl = (int) (Math.random() * 9) + 1;


    }

    public void berechneRunde(int spielerZahl) {// Vergleicht die Zahl des Spielers mit der Computerzahl
        this.spielerZahl = spielerZahl;

        if (spielerZahl == computerZahl) {// gleiche Zahl
            rundenErgebnis = 20;
        } else if (spielerZahl == computerZahl + 1 || spielerZahl == computerZahl - 1) {// +- 1
            rundenErgebnis = 5;
        } else { //andere Zahlen
            rundenErgebnis = -10;
        }

        gesamtPunkte = gesamtPunkte + rundenErgebnis; // Rundenergebnis zu den Gesamtpunkten addieren
    }

    public boolean hatGewonnen() { // Gewonnen ab 100 Punkten
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {// Verloren bei 0 Punkten oder weniger
        return gesamtPunkte <= 0;
    }
}
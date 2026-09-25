package controller;

import model.GewinnModel;
import view.GewinnView;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controller des einfachen Spieles
 * @author Muhammed Guerle
 * 23/09/2026
 */
public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
        // Controller hört auf Eingabefeld und Button
        view.getEingabeFeld().addActionListener(this);
        view.getNochEinmalButton().addActionListener(this);
        // Startpunkte anzeigen
        view.getPunkteLabel().setText("Gesamtpunkte: " + model.getGesamtPunkte());
    }
    // Wird bei Enter im Eingabefeld oder Klick auf den Button aufgerufen
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getEingabeFeld()) {
            spielen();
        } else if (e.getSource() == view.getNochEinmalButton()) {
            zuruecksetzen();
        }
    }
    // Eine Runde spielen
    private void spielen() {
        int zahl;
        try {
            zahl = Integer.parseInt(view.getEingabeFeld().getText());
        } catch (NumberFormatException ex) {
            view.getRundenLabel().setText("Bitte 1 bis 9 eingeben!"); // keine Zahl eingegeben
            return;
        }
        if (zahl < 1 || zahl > 9) {
            view.getRundenLabel().setText("Bitte 1 bis 9 eingeben!");// Zahl außerhalb 1 bis 9
            return;
        }

        model.berechneComputerZahl();
        model.berechneRunde(zahl);

        // Anzeige nach der Auswertung aktualisieren
        Color farbe = model.getRundenErgebnis() > 0 ? Color.GREEN : Color.RED;
        view.getEingabeFeld().setEditable(false);// Eingabefeld sperren
        view.getNochEinmalButton().setEnabled(true);// Button freigeben

        view.getComputerFeld().setText("" + model.getComputerZahl());
        view.getPunkteLabel().setText("" + model.getGesamtPunkte());
        // Meldung je nach Ergebnis
        if (model.hatGewonnen()) {
            view.getRundenLabel().setText("Gewonnen");
        } else if (model.hatVerloren()) {
            view.getRundenLabel().setText("Verloren");
        } else if (model.getRundenErgebnis() > 0) {
            view.getRundenLabel().setText("+" + model.getRundenErgebnis());
        } else {
            view.getRundenLabel().setText("" + model.getRundenErgebnis());
        }
        //grün oder rot einfärben
        view.getRundenLabel().setBackground(farbe);
        view.getPunkteLabel().setBackground(farbe);
    }
    // Setzt die Runde zurück
    private void zuruecksetzen() {
        view.getEingabeFeld().setText("");
        view.getComputerFeld().setText("");
        view.getRundenLabel().setText("Tippe eine Zahl von 1 bis 9");
        view.getEingabeFeld().setEditable(true); //felder nocheinmal freigebn
        view.getNochEinmalButton().setEnabled(false); // nocheinmal button deaktiviert
    }
    // innere Klasse: main-Methode des Programms
    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
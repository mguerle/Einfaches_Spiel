package controller;

import model.GewinnModel;
import view.GewinnView;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.getEingabeFeld().addActionListener(this);
        view.getNochEinmalButton().addActionListener(this);

        view.getPunkteLabel().setText("Gesamtpunkte: " + model.getGesamtPunkte());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getEingabeFeld()) {
            spielen();
        } else if (e.getSource() == view.getNochEinmalButton()) {
            zuruecksetzen();
        }
    }

    private void spielen() {
        int zahl;
        try {
            zahl = Integer.parseInt(view.getEingabeFeld().getText());
        } catch (NumberFormatException ex) {
            view.getRundenLabel().setText("Bitte 1 bis 9 eingeben!");
            return;
        }
        if (zahl < 1 || zahl > 9) {
            view.getRundenLabel().setText("Bitte 1 bis 9 eingeben!");
            return;
        }

        model.berechneComputerZahl();
        model.berechneRunde(zahl);
        // Anzeige nach der Auswertung aktualisieren
        Color farbe = model.getRundenErgebnis() > 0 ? Color.GREEN : Color.RED;
        view.getComputerFeld().setText("" + model.getComputerZahl());
        view.getPunkteLabel().setText("" + model.getGesamtPunkte());
        if (model.hatGewonnen()) {
            view.getRundenLabel().setText("Gewonnen");
        } else if (model.hatVerloren()) {
            view.getRundenLabel().setText("Verloren");
        } else if (model.getRundenErgebnis() > 0) {
            view.getRundenLabel().setText("+" + model.getRundenErgebnis());
        } else {
            view.getRundenLabel().setText("" + model.getRundenErgebnis());
        }
        view.getRundenLabel().setBackground(farbe); //setzt die Farbe auf grün oder rot
        view.getPunkteLabel().setBackground(farbe);
    }

    private void zuruecksetzen() {
        view.getEingabeFeld().setText("");
        view.getComputerFeld().setText("");
        view.getRundenLabel().setText("Tippe eine Zahl von 1 bis 9");
    }

    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
        view.setVisible(true);
    }
}
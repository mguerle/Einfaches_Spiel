package controller;

import model.GewinnModel;
import view.GewinnView;

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
}
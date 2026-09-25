package view;

import javax.swing.*;
import java.awt.*;
/**
 * Oberfläche des einfachen Spieles
 * @author Muhammed Guerle
 * 23/09/2026
 */
public class GewinnView extends JFrame {
    private JLabel rundenLabel;
    private JLabel punkteLabel;
    private JTextField eingabeFeld;
    private JTextField computerFeld;
    private JButton nochEinmalButton;

    public GewinnView() {
        super("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fett = new Font("SansSerif", Font.BOLD, 14);
        Font gross = new Font("SansSerif", Font.BOLD, 40);
        // Labels oben: Rundenergebnis und Gesamtpunkte (immer weißer Hintergrund)
        rundenLabel = new JLabel("Schreib eine Zahl von 1 bis 9", SwingConstants.CENTER);
        rundenLabel.setOpaque(true);
        rundenLabel.setBackground(Color.WHITE);
        rundenLabel.setFont(fett);

        punkteLabel = new JLabel("", SwingConstants.CENTER);
        punkteLabel.setOpaque(true);
        punkteLabel.setBackground(Color.WHITE);
        punkteLabel.setFont(fett);
        // Oben: erst die Überschriften, dann die Labels
        JPanel oben = new JPanel(new GridLayout(2, 2));
        oben.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        oben.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));
        oben.add(rundenLabel);
        oben.add(punkteLabel);
        add(oben, BorderLayout.NORTH);
        // Textfelder in der Mitte: Eingabe des Spielers und Zahl des Computers
        eingabeFeld = new JTextField();
        eingabeFeld.setHorizontalAlignment(JTextField.CENTER);
        eingabeFeld.setFont(gross);

        computerFeld = new JTextField();
        computerFeld.setEditable(false);// Spieler darf hier nichts eingeben
        computerFeld.setHorizontalAlignment(JTextField.CENTER);
        computerFeld.setFont(gross);

        // Mitte: zwei Spalten nebeneinander
        JPanel mitte = new JPanel(new GridLayout(1, 2));
        mitte.add(spalte("Deine Zahl:", eingabeFeld));
        mitte.add(spalte("Computer:", computerFeld));
        add(mitte, BorderLayout.CENTER);
        // Button unten
        nochEinmalButton = new JButton("Noch einmal!");
        nochEinmalButton.setEnabled(false); // erst nach einer Runde aktiv
        JPanel unten = new JPanel();
        unten.add(nochEinmalButton);
        add(unten, BorderLayout.SOUTH);

        setSize(600, 350);
        setLocationRelativeTo(null); // Fenster in der Bildschirmmitte
    }
    // Baut eine Spalte mit überschrift oben, textfeld unten
    private JPanel spalte(String titel, JTextField feld) {
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel(titel, SwingConstants.CENTER), BorderLayout.NORTH);
        p.add(feld, BorderLayout.CENTER);
        return p;
    }
    //getter Methoden
    public JLabel getRundenLabel() { return rundenLabel; }
    public JLabel getPunkteLabel() { return punkteLabel; }
    public JTextField getEingabeFeld() { return eingabeFeld; }
    public JTextField getComputerFeld() { return computerFeld; }
    public JButton getNochEinmalButton() { return nochEinmalButton; }
}
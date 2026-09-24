package view;

import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel rundenLabel;
    private JLabel punkteLabel;
    private JTextField eingabeFeld;
    private JTextField computerFeld;
    private JButton nochEinmalButton;

    public GewinnView() {
        super("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fett = new Font("SansSerif", Font.BOLD, 14);
        Font gross = new Font("SansSerif", Font.BOLD, 40);
    }
}
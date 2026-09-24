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
        super("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Font fett = new Font("SansSerif", Font.BOLD, 14);
        Font gross = new Font("SansSerif", Font.BOLD, 40);

        rundenLabel = new JLabel("Shcreib eine Zahl von 1 bis 9", SwingConstants.CENTER);
        punkteLabel = new JLabel("", SwingConstants.CENTER);
        for (JLabel l : new JLabel[]{rundenLabel, punkteLabel}) {
            l.setOpaque(true);
            l.setBackground(Color.WHITE);
            l.setFont(fett);
        }
        JPanel oben = new JPanel(new GridLayout(2, 2));
        oben.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        oben.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));
        oben.add(rundenLabel);
        oben.add(punkteLabel);
        add(oben, BorderLayout.NORTH);
    }
}
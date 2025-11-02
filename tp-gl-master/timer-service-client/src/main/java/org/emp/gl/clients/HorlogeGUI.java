package org.emp.gl.clients;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private final JLabel labelHeure = new JLabel();
    private final JPanel panelRebours = new JPanel(new GridLayout(0, 1));
    private final TimerService timerService;
    private final List<CompteARebours> compteAReboursList;

    public HorlogeGUI(TimerService timerService, List<CompteARebours> compteAReboursList) {
        this.timerService = timerService;
        this.compteAReboursList = compteAReboursList;

        setTitle("Horloge + Compte à rebours");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        labelHeure.setFont(new Font("Arial", Font.BOLD, 36));
        labelHeure.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelHeure, BorderLayout.NORTH);


        for (int i = 0; i < compteAReboursList.size(); i++) {
            JLabel lbl = new JLabel("Compte à rebours " + (i + 1) + " : " + compteAReboursList.get(i).getValeur());
            lbl.setFont(new Font("Arial", Font.PLAIN, 20));
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
            panelRebours.add(lbl);
        }
        add(panelRebours, BorderLayout.CENTER);


        timerService.addTimeChangeListener(this);

        setVisible(true);
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(propertyName)) {
            // Met à jour l’heure
            String heure = String.format("%02d:%02d:%02d",
                    timerService.getHeures(),
                    timerService.getMinutes(),
                    timerService.getSecondes());

            SwingUtilities.invokeLater(() -> labelHeure.setText(heure));


            updateRebours();
        }
    }

    private void updateRebours() {
        Component[] labels = panelRebours.getComponents();
        for (int i = 0; i < compteAReboursList.size(); i++) {
            CompteARebours c = compteAReboursList.get(i);
            ((JLabel) labels[i]).setText("Compte à rebours " + (i + 1) + " : " + c.getValeur());
        }
    }
}

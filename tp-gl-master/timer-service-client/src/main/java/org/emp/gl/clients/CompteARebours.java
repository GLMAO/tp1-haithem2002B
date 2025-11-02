package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class CompteARebours implements TimerChangeListener {

    private int valeur; // le nombre de secondes restantes
    private final TimerService timerService;
    private boolean termine = false;

    public CompteARebours(TimerService timerService, int valeurInitiale) {
        this.timerService = timerService;
        this.valeur = valeurInitiale;
        this.timerService.addTimeChangeListener(this);
    }

    public int getValeur() {
        return valeur;
    }

    public boolean isTermine() {
        return termine;
    }


    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(propertyName) && !termine) {
            if (valeur > 0) {
                valeur--;
            } else {
                termine = true;
                System.out.println("Compte à rebours terminé !");
            }
        }
    }
}

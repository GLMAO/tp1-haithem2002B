package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Horloge implements TimerChangeListener {

    private final TimerService timerService;

    public Horloge(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
    }

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        if (TimerChangeListener.SECONDE_PROP.equals(propertyName)) {
            System.out.println("Heure : " + timerService.getHeures() + ":" +
                    timerService.getMinutes() + ":" +
                    timerService.getSecondes());
        }
    }
}

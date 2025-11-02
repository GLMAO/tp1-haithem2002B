package org.emp.gl.timer.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.TimerChangeProvider;

/**
 * Implémentation factice du service de temps (compte les secondes, minutes...).
 */
public class DummyTimeServiceImpl implements TimerService, TimerChangeProvider {

    private int heures = 0;
    private int minutes = 0;
    private int secondes = 0;

    private final List<TimerChangeListener> listeners = new ArrayList<>();

    @Override
    public void addTimeChangeListener(TimerChangeListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener listener) {
        listeners.remove(listener);
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    /** ✅ Démarrage du service de temps */
    public void start() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000); // attendre 1 seconde
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Incrémenter le temps
                incrementTime();

                // 🔔 Notifier tous les observateurs
                for (TimerChangeListener l : listeners) {
                    l.propertyChange(TimerChangeListener.SECONDE_PROP, null, secondes);
                }
            }
        });
        t.start();
    }

    /** Incrémentation du temps simulé */
    private void incrementTime() {
        secondes++;
        if (secondes >= 60) {
            secondes = 0;
            minutes++;
            if (minutes >= 60) {
                minutes = 0;
                heures++;
                if (heures >= 24) {
                    heures = 0;
                }
            }
        }
    }
}

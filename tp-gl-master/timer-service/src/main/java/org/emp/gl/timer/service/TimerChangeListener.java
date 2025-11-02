package org.emp.gl.timer.service;

public interface TimerChangeListener {

    String SECONDE_PROP = "seconde";
    String MINUTE_PROP = "minute";
    String HEURE_PROP = "heure";

    void propertyChange(String propertyName, Object oldValue, Object newValue);
}

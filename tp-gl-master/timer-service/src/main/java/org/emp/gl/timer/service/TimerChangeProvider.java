package org.emp.gl.timer.service;

public interface TimerChangeProvider {

    void addTimeChangeListener(TimerChangeListener listener);

    void removeTimeChangeListener(TimerChangeListener listener);
}

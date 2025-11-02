package org.emp.gl.core.launcher;

import org.emp.gl.clients.HorlogeGUI;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.timer.service.impl.DummyTimeServiceImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DummyTimeServiceImpl timerService = new DummyTimeServiceImpl();

        // 🔹 Créer plusieurs compte-à-rebours (par exemple 3)
        List<CompteARebours> comptes = new ArrayList<>();
        comptes.add(new CompteARebours(timerService, 5));
        comptes.add(new CompteARebours(timerService, 8));
        comptes.add(new CompteARebours(timerService, 10));

        // 🔹 Lancer la GUI
        SwingUtilities.invokeLater(() -> new HorlogeGUI(timerService, comptes));

        // 🔹 Démarrer le service de temps
        timerService.start();
    }
}

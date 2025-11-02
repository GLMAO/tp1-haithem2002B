package org.emp.gl.core.launcher;

import org.emp.gl.clients.Horloge ;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        testDuTimeService();
    }

    private static void testDuTimeService() {
        Horloge horloge = new Horloge("Num 1") ;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

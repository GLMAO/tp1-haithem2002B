package org.emp.gl.clients ; 

import org.emp.gl.timer.service.TimerService ; 


public class Horloge {

    String name; 
    TimerService timerService ; 


    public Horloge (String name) {
        this.name = name ; 

        System.out.println ("Horloge "+name+" initialized!") ;
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }

}

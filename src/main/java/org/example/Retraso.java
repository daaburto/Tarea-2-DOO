package org.example;

import java.time.Instant;
import java.util.List;

/**Clase que representa un retraso en una reunión.
 * @see Asistencia*/
public class Retraso extends Asistencia {
    /**Hora del retraso*/
    private Instant hora;

    /**Constructor de la clase Retraso*/
    public Retraso(){
        super();
    }

    /**@return hora del retraso*/
    public Instant getHora() {
        return hora;
    }
}

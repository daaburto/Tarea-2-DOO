package org.example;
import java.time.Instant;

/**
 * Clase que representa una invitación a una reunión.
 * Contiene la reunión a la que se refiere y su hora.
 */
public class Invitacion {
    /**Hora de la reunion*/
    private Instant hora;

    /**Reunión a la que se refiere la invitación
     *@see Reunion*/
    private Reunion reunion;

    /**
     * Constructor de la clase Invitacion.
     * @param r Reunión para la que se crea la invitación.
     */
    public Invitacion(Reunion r) {
        this.hora = r.getHoraPrevista();
        this.reunion = r;
    }

    /**@return hora de la reunión*/
    public Instant getHora() {
        return hora;
    }

    /**@return reunión de la invitación*/
    public Reunion getReunion(){
        return reunion;
    }
}

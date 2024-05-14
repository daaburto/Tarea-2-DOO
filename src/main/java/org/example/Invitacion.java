package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Reunion reunion;

    public Invitacion(Reunion r) {
        this.hora = r.getHoraPrevista();
        this.reunion = r;
    }
    public Instant getHora() {
        return hora;
    }
    public Reunion getReunion(){
        return reunion;
    }
}

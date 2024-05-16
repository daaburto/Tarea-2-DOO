package org.example;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**Clase que representa un retraso en una reunión.
 * @see Asistencia*/
public class Retraso extends Asistencia {
    /**Hora del retraso*/
    private Instant hora;

    /**Lista con las horas de retraso de los empleados*/
    public ArrayList<Instant> horaRetrasos;

    /**Constructor de la clase Retraso*/
    public Retraso(){
        super();
        horaRetrasos = new ArrayList<>();
    }

    /**@return hora de retraso de un empleado*/
    public Instant getHora(Empleado emp, Reunion re) {
        if (re.listaAsistencia.getList().contains(emp)){
            int i = re.listaAsistencia.getList().indexOf(emp);
            return horaRetrasos.get(i);
        }
        else{
            return null;
        }
    }
}

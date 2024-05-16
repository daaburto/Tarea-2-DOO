package org.example;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase que representa la asistencia a una reunión.
 * Contiene una lista de empleados que han confirmado su asistencia.
 */
public class Asistencia {
    /**Lista de empleados que han confirmado su asistencia a la reunión
     *@see Empleado*/
    public List<Empleado> listaEmpleados;

    /**
     * Constructor de la clase Asistencia.
     * Inicializa la lista de empleados.
     */
    public Asistencia(){
        listaEmpleados = new ArrayList<>();
    }

    /**
     * Agrega un empleado a la lista de asistencia.
     * @param emp El empleado que ha confirmado su asistencia.
     */
    public void addList(Empleado emp){
        listaEmpleados.add(emp);
    }

    /**@return lista de empleados que han confirmado su asistencia.*/
    public List getList(){
        return listaEmpleados;
    }

}

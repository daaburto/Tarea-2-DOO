package org.example;
import java.util.ArrayList;
/**
 * Clase que representa un departamento de una organización.
 * Los departamentos pueden contener empleados y pueden enviar invitaciones a reuniones a todos sus empleados.
 * @see Empleado
 * @see Invitable
 */
public class Departamento implements Invitable{
    /**Nombre del departamento*/
    private final String nombre;

    /**Lista de empleados en el departamento*/
    public ArrayList<Empleado> empleados;

    /**
     * Constructor de la clase Departamento.
     * @param nom El nombre del departamento.
     */
    public Departamento(String nom){
        this.nombre = nom;
        empleados = new ArrayList<>();
    }
    /**
     * Obtiene la cantidad de empleados en el departamento.
     * @return cantidad de empleados en el departamento.
     */
    public int ObtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**@return nombre del departamento*/
    public String getNombre() {
        return nombre;
    }

    /**
     * Envía una invitación a una reunión a todos los empleados del departamento.
     * @param inv La invitación a la reunión.
     */
    public void invitar(Invitacion inv)
    {
        for (int i = 0; i < empleados.size(); i++)
        {
            empleados.get(i).invitar(inv);
            System.out.println(empleados.get(i).getNombre() + " ha sido invitado a " + inv.getReunion());
        }
    }
}

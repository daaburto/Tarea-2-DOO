package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private final String nombre;
    public ArrayList<Empleado> empleados;

    public Departamento(String nom){
        this.nombre = nom;
        empleados = new ArrayList<>();
    }
    public int ObtenerCantidadEmpleados(){
        return empleados.size();
    }

    public String getNombre() {
        return nombre;
    }

    public void invitar()
    {
        for (int i = 0; i < empleados.size(); i++)
        {
            empleados.get(i).invitar();
            System.out.println(empleados.get(i).getNombre() + " a sido invitado");
        }
    }
}

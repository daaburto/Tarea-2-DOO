package org.example;
import java.util.List;
import java.util.ArrayList;

public class Asistencia {
    public List<Empleado> listaEmpleados;
    public Asistencia(){
        listaEmpleados = new ArrayList<>();
    }

    public void addList(Empleado emp){
        listaEmpleados.add(emp);
    }
    public List getList(){
        return listaEmpleados;
    }

}

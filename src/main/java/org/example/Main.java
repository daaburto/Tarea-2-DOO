package org.example;
public class Main {
    public static void main(String[] args) {
        Departamento dep1 = new Departamento("Departamento1");
        Empleado emp1 = new Empleado("7500","Sandoval Reyes", "Joaquin", "joaquinsandoval@gmail.com", dep1);
        Empleado emp2 = new Empleado("7501","Aburto Rivera", "Daniel", "daaburto@gmail.com", dep1);

        System.out.println(emp1.getCorreo());
        System.out.println(emp1.getApellidos());
        System.out.println(emp1.getNombre());
        System.out.println(emp1.getId());
        System.out.println(emp1.getDepartamento().getNombre());
        System.out.println(dep1.ObtenerCantidadEmpleados());

        dep1.invitar();

        
    }
}


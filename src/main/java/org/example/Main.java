package org.example;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // Prueba Departamentos y Empleados
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

        // Prueba Fechas en reuniones
        Date fecha = new Date(124,4,10);
        Duration duracion = Duration.ofHours(2).plusMinutes(30);
        ReunionPresencial reunion = new ReunionPresencial(fecha, Instant.parse("2024-05-10T14:00:00Z"),duracion,"314");
        reunion.iniciar();
        try {
            Thread.sleep(2000); // 1000 milisegundos = 1 segundo
        } catch (InterruptedException ignored) {
        }
        reunion.finalizar();
        System.out.println("fecha: "+ reunion.getFecha());
        System.out.println("Hora prevista: "+ reunion.getHoraPrevista());
        System.out.println("duracion prevista: "+ reunion.getDuracionPrevista());
        System.out.println("hora inicio: "+ reunion.getHoraInicio().truncatedTo(ChronoUnit.SECONDS));
        System.out.println("hora fin: "+ reunion.getHoraFin().truncatedTo(ChronoUnit.SECONDS));
        System.out.println("tiempo real: "+ reunion.calcularTiempoReal().truncatedTo(ChronoUnit.SECONDS));
        System.out.println("sala: "+ reunion.getSala());


    }
}


package org.example;
import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {



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

        // Prueba Departamentos, Empleados e invitaciones
        ReunionPresencial reunion1 = new ReunionPresencial(fecha, Instant.parse("2024-05-10T14:00:00Z"), duracion, "314");
        Invitacion inv1 = new Invitacion(reunion1);
        Departamento dep1 = new Departamento("Departamento1");
        Departamento dep2 = new Departamento("Departamento2");
        Empleado emp1 = new Empleado("7500","Sandoval Reyes", "Joaquin", "joaquinsandoval@gmail.com", dep1);
        Empleado emp2 = new Empleado("7501","Aburto Rivera", "Daniel", "daaburto@gmail.com", dep1);
        Empleado emp3 = new Empleado("7501","Herrera Guzman", "Juan", "herrera@gmail.com", dep2);

        dep1.invitar(inv1);

        emp1.asistir(inv1);
        emp2.asistir(inv1);

        System.out.println(reunion1.obtenerAsistencias());

    }
}


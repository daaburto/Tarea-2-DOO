package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

        // Prueba Fechas y notas en reuniones, además de generar un txt
        Date fecha = new Date(124,4,10);
        Duration duracion = Duration.ofHours(2).plusMinutes(30);
        ReunionPresencial reunion = new ReunionPresencial(fecha, Instant.parse("2024-05-10T14:00:00Z"),duracion,"314");
        reunion.iniciar();
        try {
            Thread.sleep(2000); // 1000 milisegundos = 1 segundo
        } catch (InterruptedException ignored) {
        }

        reunion.nuevaNota(new Notas("Cosa Importante"));
        reunion.nuevaNota(new Notas("Cosa MUY Importante"));
        reunion.nuevaNota(new Notas("[REDACTED]"));
        reunion.nuevaNota(new Notas("[Comment removed by moderator]"));

        reunion.finalizar();
        try (PrintWriter writer = new PrintWriter(new FileWriter("informacion_reunion.txt"))){
            writer.println(reunion);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo: " + e.getMessage());
        }


    }
}


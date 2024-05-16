package org.example;

import javax.swing.*;
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



        // Prueba Fechas y notas en reuniones, además de generar un txt

        Date fecha = new Date(124,4,10);
        Duration duracion = Duration.ofHours(2).plusMinutes(30);
        /*
        ReunionPresencial reunion = new ReunionPresencial(fecha, Instant.now().plus(Duration.ofSeconds(1)),duracion,tipoReunion.TECNICA,"314");
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


         */

        // Prueba Departamentos, Empleados e invitaciones
        ReunionPresencial reunion1 = new ReunionPresencial(fecha, Instant.now().plus(Duration.ofMillis(100)), duracion,tipoReunion.TECNICA, "314");
        Invitacion inv1 = new Invitacion(reunion1);
        Departamento dep1 = new Departamento("Departamento1");
        Departamento dep2 = new Departamento("Departamento2");
        Empleado emp1 = new Empleado("7500","Sandoval Reyes", "Joaquin", "joaquinsandoval@gmail.com", dep1);
        Empleado emp2 = new Empleado("7501","Aburto Rivera", "Daniel", "daaburto@gmail.com", dep1);
        Empleado emp3 = new Empleado("7501","Herrera Guzman", "Juan", "herrera@gmail.com", dep1);

        dep1.invitar(inv1);
        reunion1.iniciar();
        emp1.asistir(inv1);
        reunion1.nuevaNota(new Notas("Cosa MUY Importante"));
        reunion1.nuevaNota(new Notas("[REDACTED]"));
        reunion1.nuevaNota(new Notas("[Comment removed by moderator]"));
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ignored){
        }
        emp2.asistir(inv1);
        reunion1.finalizar();
        emp3.asistir(inv1);

        System.out.println(reunion1.calcularTiempoReal());
        System.out.println("Lista asistencias --> " + reunion1.obtenerAsistencias());
        System.out.println("Lista atrasos --> " + reunion1.obtenerRetrasos());
        System.out.println("Lista ausencias --> " + reunion1.obtenerAusencias());

        try (PrintWriter writer = new PrintWriter(new FileWriter("informacion_reunion2.txt"))){
            writer.println(reunion1);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo: " + e.getMessage());
        }
    }
}


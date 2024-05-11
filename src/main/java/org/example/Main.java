package org.example;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
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
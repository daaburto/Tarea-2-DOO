package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
    }
    public abstract List obtenerAsistencias();
    public abstract List obtenerAusencias();
    public abstract List obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();
    public Duration calcularTiempoReal(){
        return Duration.between(horaInicio,horaFin);
    }
    public void iniciar(){
        horaInicio = Instant.now();
    }
    public void finalizar(){
        horaFin = Instant.now();
    }
    public Date getFecha(){
        return fecha;
    }
    public Instant getHoraPrevista(){
        return horaPrevista;
    }
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    public Instant getHoraInicio(){
        return horaInicio;
    }
    public Instant getHoraFin(){
        return horaFin;
    }

}

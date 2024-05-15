package org.example;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    public ArrayList<Empleado> listaInvitados;
    public Asistencia listaAsistencia;
    public Retraso listaRetrasos;


    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = new ArrayList<>();
        this.listaAsistencia = new Asistencia();
        this.listaRetrasos = new Retraso();
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
    public void addInvitado(Empleado emp){
        listaInvitados.add(emp);
    }

}

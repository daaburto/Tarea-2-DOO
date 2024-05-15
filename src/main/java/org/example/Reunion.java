package org.example;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
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
    public ArrayList<Empleado> listaAusencias;
    private List<Notas> notas;


    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = new ArrayList<>();
        this.listaAsistencia = new Asistencia();
        this.listaRetrasos = new Retraso();
        this.listaAusencias = new ArrayList<>();
        this.notas = new ArrayList<>();
    }
    public abstract List obtenerAsistencias();
    public abstract List obtenerAusencias();
    public abstract List obtenerRetrasos();
    public abstract int obtenerTotalAsistencia();
    public abstract float obtenerPorcentajeAsistencia();
    public abstract void nuevaNota(Notas notas);
    public void agregarNota(Notas nota) {
        this.notas.add(nota);
    }

    public Duration calcularTiempoReal(){
        return Duration.between(horaInicio,horaFin);

    }
    public void iniciar(){
        horaInicio = Instant.now();
    }
    public void finalizar(){
        horaFin = Instant.now();
        // Comparar listaInvitados con listaAsistencia
        for (int i = 0; i < listaInvitados.size(); i ++){
            if (!listaAsistencia.getList().contains(listaInvitados.get(i))){
                listaAusencias.add(listaInvitados.get(i));
                System.out.println(listaInvitados.get(i).getNombre() + " Faltó a la reunión");
            }else {
                System.out.println(listaInvitados.get(i).getNombre() + " No faltó a la reunión");
            }
        }
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

    public void addInvitado(Empleado emp) {
        listaInvitados.add(emp);
    }

    public List<Notas> getNotas(){
        return notas;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Hora prevista: ").append(horaPrevista).append("\n");
        sb.append("Duración prevista: ").append(duracionPrevista).append("\n");
        sb.append("Hora de inicio: ").append(horaInicio).append("\n");
        sb.append("Hora de fin: ").append(horaFin).append("\n");
        sb.append("Notas:\n");
        for (Notas nota : notas) {
            sb.append(nota.getContenido()).append("\n");
        }
        return sb.toString();
    }

}

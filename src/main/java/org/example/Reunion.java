package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * La clase abstracta Reunion representa una reunión de tipo genérico que puede ser virtual o presencial.
 */
public abstract class Reunion {
    /**Fecha en la que se va a hacer la reunión*/
    private Date fecha;

    /**Hora a la que se espera iniciar la reunión*/
    private Instant horaPrevista;

    /**Tiempo estimado de la duración de la reunión*/
    private Duration duracionPrevista;

    /**Hora a la que inicia la reunión*/
    private Instant horaInicio;

    /**Hora a la que finaliza la reunión*/
    private Instant horaFin;

    /**Lista con los invitados a la reunión*/
    public ArrayList<Empleado> listaInvitados;

    /**Lista de la asistencia de la reunión*/
    public Asistencia listaAsistencia;

    /**Lista de los retrasos de la reunión*/
    public Retraso listaRetrasos;

    /**Listas con las ausencias de la reunión*/
    public ArrayList<Empleado> listaAusencias;

    /**Lista con las notas hechas en la reunion*/
    private List<Notas> notas;

    /**Tipo de la reunión*/
    private tipoReunion tipo;

    /**
     * Constructor de la clase Reunion.
     * @param fecha fecha de la reunión
     * @param horaPrevista hora a la que se espera iniciar la reunión
     * @param duracionPrevista duración estimada de la reunión
     * @param type Tipo de la reunión
     * @see tipoReunion
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion type){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.listaInvitados = new ArrayList<>();
        this.listaAsistencia = new Asistencia();
        this.listaRetrasos = new Retraso();
        this.listaAusencias = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.tipo = type;
    }

    /**
     * Método para obtener la lista de asistencias de la reunión.
     * @return Lista de asistencias.
     */
    public abstract List obtenerAsistencias();

    /**
     * Método para obtener la lista de ausencias de la reunión.
     * @return Lista de ausencias.
     */
    public abstract List obtenerAusencias();

    /**
     * Método para obtener la lista de retrasos a la reunión.
     * @return Lista de retrasos.
     */
    public abstract List obtenerRetrasos();

    /**
     * Método para obtener el total de asistencia a la reunión.
     * @return Cantidad total de asistencias.
     */
    public abstract int obtenerTotalAsistencia();

    /**
     * Método para obtener el porcentaje de asistencia a la reunión.
     * @return Porcentaje de asistencia.
     */
    public abstract float obtenerPorcentajeAsistencia();

    /**
     * Método abstracto para agregar una nueva nota a la reunión.
     * @param notas nota a agregar.
     */
    public abstract void nuevaNota(Notas notas);

    /**
     * Agrega una nota a la lista de notas de la reunión.
     * @param nota La nota a agregar.
     */
    public void agregarNota(Notas nota) {
        this.notas.add(nota);
    }

    /**
     * Calcula el tiempo entre la hora de inicio y fin de la reunión
     * @return Duración de la reunión
     */
    public Duration calcularTiempoReal(){
        return Duration.between(horaInicio,horaFin);
    }

    /**
     * Inicia la reunión estableciendo la hora de inicio como el momento actual.
     */
    public void iniciar(){
        horaInicio = Instant.now();
    }

    /**
     * Finaliza la reunión estableciendo la hora de finalización como el momento actual y
     * verifica la asistencia de los invitados.
     * Si un invitado no está en la lista de asistencia, se agrega a la lista de ausencias.
     */
    public void finalizar(){
        horaFin = Instant.now();
        for (int i = 0; i < listaInvitados.size(); i ++){
            if (!listaAsistencia.getList().contains(listaInvitados.get(i))){
                listaAusencias.add(listaInvitados.get(i));
            }
        }
    }

    /**
     * @return fecha de la reunión
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * @return hora prevista de la reunión
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * @return duración prevista de la reunión
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    /**
     * @return hora de inicio de la reunión
     */
    public Instant getHoraInicio(){
        return horaInicio;
    }

    /**
     * @return hora de término de la reunión
     */
    public Instant getHoraFin(){
        return horaFin;
    }

    /**
     * Agrega un empleado a la lista de invitados para la reunión.
     * @param emp Empleado que se va a agregar como invitado.
     */
    public void addInvitado(Empleado emp) {
        listaInvitados.add(emp);
    }

    /**
     * @return todas las notas hechas durante la reunión
     */
    public List<Notas> getNotas(){
        return notas;
    }

    /**
     * Genera un informe de la reunión
     */
    public void informe(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("informacion_reunion.txt"))){
            writer.println(this);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo: " + e.getMessage());
        }
    }



    /**
     * Representación en forma de string de la reunión.
     * Incluye la información relevante sobre la reunión.
     * @return Información relevante de la reunión.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de la reunión: ").append(tipo).append("\n");
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
package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * Clase que representa una reunión virtual.
 * Una reunión virtual se caracteriza por tener un enlace para acceder a una sala de reuniones en línea.
 * @see Reunion
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista de inicio de la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param enlace Enlace para acceder a la sala de reuniones.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista,tipoReunion type, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, type);
        this.enlace = enlace;
    }

    /**
     * {@inheritDoc}
     * @return Lista con la asistencia
     */
    public List obtenerAsistencias(){
        return listaAsistencia.getList();
    }

    /**
     * {@inheritDoc}
     * @return Lista de ausencias
     */
    public List obtenerAusencias(){
        return listaAusencias;
    }

    /**
     * {@inheritDoc}
     * @return Lista de retrasos
     */
    public List obtenerRetrasos(){
        return listaRetrasos.getList();
    }

    /**
     * {@inheritDoc}
     * @return Total de asistencia
     */
    public int obtenerTotalAsistencia(){
        return listaAsistencia.getList().size();
    }

    /**
     * {@inheritDoc}
     * @return Porcentaje de asistencia
     */
    public float obtenerPorcentajeAsistencia(){
        float total = listaInvitados.size();
        float asistencia = this.obtenerTotalAsistencia();
        return (asistencia*100)/total;
    }

    /**
     * Agrega una nueva nota a la reunión
     * @param nota nota a agregar.
     */
    public void nuevaNota(Notas nota){
        agregarNota(nota);
    }

    /**
     * @return enlace de la reunión
     */
    public String getEnlace() {
        return enlace;
    }

    /**
     * {@inheritDoc}
     * @return Información de la reunión
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala: ").append(enlace).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}

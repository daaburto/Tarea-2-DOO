package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
/**
 * Clase que representa una reunión presencial.
 * Una reunión presencial se lleva a cabo en una sala física.
 * @see Reunion
 */
public class ReunionPresencial extends Reunion{
    /**Sala en la que se lleva a cabo la reunión presencial*/
    private String sala;

    /**
     * Constructor de la clase ReunionVirtual.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista de inicio de la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param sala Sala en la que se lleva a cabo la reunión
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista,tipoReunion type , String sala) {
        super(fecha, horaPrevista, duracionPrevista, type);
        this.sala = sala;
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
     * @return sala de la reunión
     */
    public String getSala() {
        return sala;
    }

    /**
     * {@inheritDoc}
     * @return Información de la reunión
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala: ").append(sala).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
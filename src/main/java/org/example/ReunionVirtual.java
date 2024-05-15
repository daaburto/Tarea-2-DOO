package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
public class ReunionVirtual extends Reunion {
    private String enlace;

    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace) {
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    public List obtenerAsistencias(){
        return listaAsistencia.getList();
    }
    public List obtenerAusencias(){
        return listaAusencias;
    }
    public List obtenerRetrasos(){
        return listaRetrasos.getList();
    }
    public int obtenerTotalAsistencia(){
        return listaAsistencia.getList().size();
    }
    public float obtenerPorcentajeAsistencia(){
        float total = listaInvitados.size();
        float asistencia = this.obtenerTotalAsistencia();

        return (asistencia*100)/total;
    }
    public void nuevaNota(Notas nota){
        agregarNota(nota);
    }
    public String getEnlace() {
        return enlace;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala: ").append(enlace).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}

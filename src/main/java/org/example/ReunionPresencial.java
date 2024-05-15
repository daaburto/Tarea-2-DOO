package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
public class ReunionPresencial extends Reunion{
    private String sala;

    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista,String sala) {
        super(fecha, horaPrevista, duracionPrevista);
        this.sala = sala;

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
    public String getSala() {
        return sala;
    }
}
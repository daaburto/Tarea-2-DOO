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
        return null;
    }
    public List obtenerAusencias(){
        return null;
    }
    public List obtenerRetrasos(){
        return null;
    }
    public int obtenerTotalAsistencia(){
        return 0;
    }
    public float obtenerPorcentajeAsistencia(){
        return 0;
    }
    public void nuevaNota(Notas nota){
        agregarNota(nota);
    }
    public String getSala() {
        return sala;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sala: ").append(sala).append("\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
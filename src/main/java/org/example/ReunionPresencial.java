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
    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetrasos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public String getSala() {
        return sala;
    }
}
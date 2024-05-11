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
    public List obtenerAsistencias(){}
    public List obtenerAusencias(){}
    public List obtenerRetrasos(){}
    public int obtenerTotalAsistencia(){}
    public float obtenerPorcentajeAsistencia(){}
    public String getEnlace() {
        return enlace;
    }
}

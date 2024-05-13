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
    public String getEnlace() {
        return enlace;
    }


}

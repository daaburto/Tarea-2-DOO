package org.example;
import java.time.Instant;

public class Empleado implements Invitable{
    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;
    private final Departamento departamento;

    public Empleado(String id, String ap, String nam, String corr, Departamento d){
        this.id = id;
        this.apellidos = ap;
        this.nombre = nam;
        this.correo = corr;
        this.departamento = d;
        departamento.empleados.add(this);
    }

    public String getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public Departamento getDepartamento(){
        return departamento;
    }

    public void invitar(Invitacion inv){
        inv.getReunion().addInvitado(this);
    }

    public void asistir(Invitacion inv){
        if (inv.getReunion().listaInvitados.contains(this))
        {
            inv.getReunion().listaAsistencia.addList(this);
        }
        else
        {
            System.out.println(this.getNombre() + " no está invitado a la reunión");
        }
    }
}
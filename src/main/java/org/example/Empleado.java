package org.example;
import java.time.Instant;

/**
 * Clase que representa a un empleado.
 * Los empleados pueden ser invitados a reuniones y pueden confirmar su asistencia a través de invitaciones.
 * @see Invitable
 */
public class Empleado implements Invitable{
    /**Identificación del empleado*/
    private final String id;

    /**Apellidos del empleado*/
    private final String apellidos;

    /**Nombre del empleado*/
    private final String nombre;

    /**Correo del empleado*/
    private final String correo;

    /**Departamento del empleado
     * @see Departamento
     */
    private final Departamento departamento;

    /**
     * Constructor de la clase Empleado.
     * @param id Identificación del empleado.
     * @param ap Apellidos del empleado.
     * @param nam Nombre del empleado.
     * @param corr Correo electrónico del empleado.
     * @param d Departamento al que pertenece el empleado.
     * @see Departamento
     */
    public Empleado(String id, String ap, String nam, String corr, Departamento d){
        this.id = id;
        this.apellidos = ap;
        this.nombre = nam;
        this.correo = corr;
        this.departamento = d;
        departamento.empleados.add(this);
    }

    /**@return id del empleado*/
    public String getId() {
        return id;
    }
    /**@return apellidos del empleado*/
    public String getApellidos() {
        return apellidos;
    }

    /**@return nombre del empleado*/
    public String getNombre() {
        return nombre;
    }

    /**@return correo del empleado*/
    public String getCorreo() {
        return correo;
    }

    /**@return departamento del empleado*/
    public Departamento getDepartamento(){
        return departamento;
    }

    /**
     * Invita al empleado a una reunión.
     * @param inv La invitación a la reunión.
     */
    public void invitar(Invitacion inv){
        if (!inv.getReunion().listaInvitados.contains(this)){
            inv.getReunion().addInvitado(this);
        }
    }

    /**
     * Registra la asistencia del empleado a una reunión.
     * @param inv La invitación a la reunión.
     */
    public void asistir(Invitacion inv) {
        if (inv.getReunion().getHoraFin() == null) {
            if (inv.getReunion().listaInvitados.contains(this)) {
                if (Instant.now().isBefore(inv.getReunion().getHoraPrevista())) {
                    inv.getReunion().listaAsistencia.addList(this);

                } else {
                    inv.getReunion().listaAsistencia.addList(this);
                    inv.getReunion().listaRetrasos.addList(this);

                }
            }
        }
    }
}
import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;


public class DepartamentoTest {
    @Test
    public void test1 (){
        Departamento departamento = new Departamento("departamento 1");
        Empleado empleado1 = new Empleado("1", "sandoval", "joaquin", "joaquinsandoval@gmail.com", departamento);
        Empleado empleado2 = new Empleado("1", "aburto", "daniel", "danielaburto@gmail.com", departamento);

        Assertions.assertEquals(2,departamento.ObtenerCantidadEmpleados());

    }

    @Test
    public void test2 (){
        Reunion reunionvirtual = new ReunionVirtual(new Date(124,4,10), Instant.now(), Duration.ofHours(2).plusMinutes(30), tipoReunion.TECNICA, "reunion.enlace");
        Invitacion inv = new Invitacion(reunionvirtual);

        Departamento departamento = new Departamento("departamento 1");
        Departamento departamento2 = new Departamento("departamento 2");
        Empleado empleado1 = new Empleado("1", "sandoval", "joaquin", "joaquinsandoval@gmail.com", departamento);
        Empleado empleado2 = new Empleado("3", "aburto", "daniel", "danielaburto@gmail.com", departamento);
        Empleado empleado3 = new Empleado("2", "adolfo", "benjamin", "adolfobenjamin@gmail.com", departamento2);

        departamento.invitar(inv);
        empleado1.invitar(inv);
        empleado3.invitar(inv);

        ArrayList<Empleado> listaInvitados = new ArrayList<>();
        listaInvitados.add(empleado1);
        listaInvitados.add(empleado2);
        listaInvitados.add(empleado3);

        Assertions.assertEquals(listaInvitados, reunionvirtual.listaInvitados);
    }
}

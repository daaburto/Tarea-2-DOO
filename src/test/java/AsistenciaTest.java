import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class AsistenciaTest {
    @Test
    public void test1(){

        Departamento departamento = new Departamento("departamento 1");
        Empleado empleado1 = new Empleado("1", "herrera", "sebastian", "sebastianherrera@gmail.com", departamento);
        Date fecha = new Date(124,4,10);
        Duration duracion = Duration.ofHours(2).plusMinutes(30);

        Reunion reunion1 = new ReunionVirtual(fecha, Instant.now(), duracion, tipoReunion.TECNICA, "enlace");
        Invitacion inv = new Invitacion(reunion1);

        empleado1.invitar(inv);
        empleado1.asistir(inv);

        Assertions.assertEquals(empleado1, reunion1.listaAsistencia.getList().get(0));
    }
}

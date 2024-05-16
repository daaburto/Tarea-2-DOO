import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class EmpleadoTest {
    @Test
    public void test1(){
        Departamento departamento = new Departamento("departamento 1");
        Empleado empleado1 = new Empleado("1", "herrera", "sebastian", "sebastianherrera@gmail.com", departamento);

        ArrayList<String> expected = new ArrayList<>();
        ArrayList<String> resultados = new ArrayList<>();
        expected.add("1");
        expected.add("sebastian");
        expected.add("herrera");
        expected.add("sebastianherrera@gmail.com");
        expected.add("departamento 1");

        resultados.add(empleado1.getId());
        resultados.add(empleado1.getNombre());
        resultados.add(empleado1.getApellidos());
        resultados.add(empleado1.getCorreo());
        resultados.add(empleado1.getDepartamento().getNombre());

        Assertions.assertEquals(expected, resultados);
    }
}


import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class AusenciaTest {
    @Test
    public void test1(){
        Date fecha = new Date(124,4,10);
        Duration duracion = Duration.ofHours(2).plusMinutes(30);
        ReunionPresencial reunion1 = new ReunionPresencial(fecha, Instant.now().plus(Duration.ofSeconds(1)), duracion, tipoReunion.TECNICA, "314");
        Invitacion inv1 = new Invitacion(reunion1);
        Departamento dep1 = new Departamento("Departamento1");
        Departamento dep2 = new Departamento("Departamento2");
        Empleado emp1 = new Empleado("7500","Sandoval Reyes", "Joaquin", "joaquinsandoval@gmail.com", dep1);
        Empleado emp2 = new Empleado("7501","Aburto Rivera", "Daniel", "daaburto@gmail.com", dep1);
        Empleado emp3 = new Empleado("7501","Herrera Guzman", "Juan", "herrera@gmail.com", dep1);

        dep1.invitar(inv1);
        reunion1.iniciar();
        emp1.asistir(inv1);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException ignored){
        }
        emp2.asistir(inv1);
        reunion1.finalizar();
        emp3.asistir(inv1);

        ArrayList<Empleado> expected= new ArrayList<>();
        expected.add(emp3);

        Assertions.assertEquals(expected, reunion1.listaAusencias);

    }
}

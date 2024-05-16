import org.example.Reunion;
import org.example.ReunionPresencial;
import org.example.tipoReunion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionTest {
    @Test
    public void test1(){
        Date fecha = new Date(2024,5,15);
        Duration duracion = Duration.ofSeconds(10);

        Reunion reunion1 = new ReunionPresencial(fecha, Instant.now().plus(Duration.ofSeconds(1)), duracion, tipoReunion.TECNICA, "123");

        reunion1.iniciar();

        try{
            Thread.sleep(10000);
        }catch (InterruptedException ignored){
        }
        reunion1.finalizar();

        Assertions.assertEquals(reunion1.getHoraInicio().plus(reunion1.getDuracionPrevista()).truncatedTo(java.time.temporal.ChronoUnit.SECONDS), reunion1.getHoraFin().truncatedTo(java.time.temporal.ChronoUnit.SECONDS));
    }
}

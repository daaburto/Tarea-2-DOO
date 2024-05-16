import org.example.Notas;
import org.example.Reunion;
import org.example.ReunionPresencial;
import org.example.tipoReunion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotasTest {
    @Test
    public void test1(){
        Notas nota1 = new Notas("ejemplo de nota");

        Date fecha = new Date(2024,5,15);
        Duration duracion = Duration.ofSeconds(10);

        Reunion reunion1 = new ReunionPresencial(fecha, Instant.now().plus(Duration.ofSeconds(1)), duracion, tipoReunion.TECNICA, "123");

        reunion1.agregarNota(nota1);
        reunion1.getNotas();

        List<Notas> expected = new ArrayList<>();

        expected.add(nota1);

        Assertions.assertEquals(expected, reunion1.getNotas());


    }
}

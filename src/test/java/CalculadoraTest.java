import hello.Calculadora;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patriciadurand on 14/04/16.
 */
public class CalculadoraTest {

    @Test
    public void deveSomar2Mais2ERetornar4() throws Exception {
        Calculadora calculadora = new Calculadora();

        int soma = calculadora.soma(2, 2);

        assertEquals(4, soma);
    }
}

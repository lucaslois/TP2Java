package integracion;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import org.junit.Assert;
import org.junit.Test;

public class FinalDeJuegoTest {

    @Test
    public void testJugadorDebePagarMasDeLoQueTieneYNoTienePropiedadesPataVenderYPierde(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Oli",tablero);

        jugador.pagar(101000);

        Assert.assertTrue(jugador.perdio());
    }

}

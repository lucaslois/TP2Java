package AlgoPoly;

import modelo.Jugador;
import modelo.casilleros.RetrocesoDinamico;
import org.junit.Assert;
import org.junit.Test;

public class RetrocesoDinamicoTest {
    @Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede4UnidadesSinPropiedades() {
        RetrocesoDinamico casillero = new RetrocesoDinamico("B");
        Jugador jugador = new Jugador("Magalí");
        jugador.setPosicion(15);
        jugador.setNumeroObtenido(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 11);
    }

    // TODO: Programar metodo de jugador getCantidadTotalPropiedades() para conocer cuantas propiedades tiene.
    /*@Test
    public void testJugadorCaeEnRetrocesoDinamicoHabiendoSacado4YRetrocede2UnidadesCon2Propiedades() {
        RetrocesoDinamico casillero = new RetrocesoDinamico("B");
        Jugador jugador = new Jugador("Magalí");
        jugador.setPosicion(10);
        jugador.setNumeroObtenido(4);
        casillero.pisar(jugador);
        Assert.assertEquals(jugador.getPosicion(), 8);
    }*/
}

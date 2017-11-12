package AlgoPoly;

import exceptions.JugadorNoTieneDineroException;
import exceptions.PrecioNegativoException;
import modelo.casilleros.Barrio;
import modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {
    @Test(expected = PrecioNegativoException.class)
    public void testCreoUnBarrioConPrecioNegativoLanzaError() {
        Barrio barrio = new Barrio(-200, "C");
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYJugadorEsPropietarioDeTerreno() {
        Barrio buenosAiresSur = new Barrio(20000, "C");
        Jugador unJugador = new Jugador("Kev");
        buenosAiresSur.pisar(unJugador);
        unJugador.comprar(buenosAiresSur);
        Assert.assertEquals(buenosAiresSur.getPropietario(), unJugador);
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYTerrenoApareceEnLaListaDePropiedadesDeJugador() {
        Barrio barrio = new Barrio(20000, "C");
        Jugador unJugador = new Jugador("Lucky");
        barrio.pisar(unJugador);
        unJugador.comprar(barrio);
        Assert.assertTrue(unJugador.getPropiedades().contains(barrio));
    }


    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorCaeEnCasilleroYCompraTerrenoPeroNoTieneDinero() {
        Barrio barrio = new Barrio(80000, "J");
        Jugador unJugador = new Jugador("Lucky");

        unJugador.comprar(barrio);
    }

}

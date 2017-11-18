package AlgoPoly;

import exceptions.JugadorNoTieneDineroException;
import exceptions.PrecioNegativoException;
import modelo.casilleros.Barrio;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {
    @Test(expected = PrecioNegativoException.class)
    public void testCreoUnBarrioConPrecioNegativoLanzaError() {
        Barrio barrio = new Barrio(-200);
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYJugadorEsPropietarioDeTerreno() {
        Barrio buenosAiresSur = new Barrio(20000);
        Jugador unJugador = new Jugador("Kev");
        buenosAiresSur.pisar(unJugador);
        unJugador.comprar(buenosAiresSur);
        Assert.assertEquals(buenosAiresSur.getPropietario(), unJugador);
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYTerrenoApareceEnLaListaDePropiedadesDeJugador() {
        Barrio barrio = new Barrio(20000);
        Jugador unJugador = new Jugador("Lucky");
        barrio.pisar(unJugador);
        unJugador.comprar(barrio);
        Assert.assertTrue(unJugador.esDuenioDePropiedad(barrio));
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorCaeEnCasilleroYCompraTerrenoPeroNoTieneDinero() {
        Barrio barrio = new Barrio(120000);
        Jugador unJugador = new Jugador("Lucky");

        unJugador.comprar(barrio);
    }

}

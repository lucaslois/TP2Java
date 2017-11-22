package unitarias;

import exceptions.JugadorNoTieneDineroException;
import exceptions.PrecioNegativoException;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Barrio;
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
        Tablero tablero = TableroFactory.crearTablero();
        Barrio buenosAiresSur = new Barrio(20000);
        Jugador unJugador = new Jugador("Kev", tablero);
        buenosAiresSur.pisar(unJugador);
        unJugador.comprar(buenosAiresSur);
        Assert.assertEquals(buenosAiresSur.getPropietario(), unJugador);
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYTerrenoApareceEnLaListaDePropiedadesDeJugador() {
        Tablero tablero = TableroFactory.crearTablero();
        Barrio barrio = new Barrio(20000);
        Jugador unJugador = new Jugador("Lucky", tablero);
        barrio.pisar(unJugador);
        unJugador.comprar(barrio);
        Assert.assertTrue(unJugador.esDuenioDePropiedad(barrio));
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorCaeEnCasilleroYCompraTerrenoPeroNoTieneDinero() {
        Tablero tablero = TableroFactory.crearTablero();
        Barrio barrio = new Barrio(120000);
        Jugador unJugador = new Jugador("Lucky", tablero);

        unJugador.comprar(barrio);
    }

}

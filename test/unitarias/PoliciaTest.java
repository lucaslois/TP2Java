package unitarias;

import modelo.tablero.*;
import modelo.tablero.tipos_casilleros.*;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {
    @Test
    public void testJugadorCaeEnPoliciaNoPuedeMoverse() {
        Tablero tablero = new Tablero();
        Jugador unJugador = new Jugador("Magalí", tablero);
        Policia policia = new Policia();

        policia.pisar(unJugador);
        Assert.assertFalse(unJugador.puedeMoverse());
    }

    @Test
    public void testJugadorCaeEnPoliciaSuPosicionEsLaCarcel() {
        Tablero tablero = new Tablero();
        Jugador unJugador = new Jugador("Magalí", tablero);
        tablero.agregarCasillero(new BarrioSimple(4000,0,0,0,0));
        Policia policia = new Policia();
        tablero.agregarCasillero(policia);
        tablero.agregarCasillero(new BarrioSimple(6000,0,0,0,0));
        tablero.agregarCasillero(new Quini6());
        Carcel carcel = new Carcel();
        tablero.agregarCasillero(carcel);
        policia.pisar(unJugador);

        Assert.assertEquals(tablero.getNodoCarcel(), unJugador.getNodoActual());
    }
}

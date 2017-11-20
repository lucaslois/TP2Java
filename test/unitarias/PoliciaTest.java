package unitarias;

import modelo.tablero.*;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.tablero.tipos_casilleros.Carcel;
import modelo.tablero.tipos_casilleros.Policia;
import modelo.tablero.tipos_casilleros.Quini6;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {
    @Test
    public void testJugadorCaeEnPoliciaNoPuedeMoverse() {
        Jugador unJugador = new Jugador("Magalí");
        Policia policia = new Policia();

        policia.pisar(unJugador);
        Assert.assertFalse(unJugador.puedeMoverse());
    }

    @Test
    public void testJugadorCaeEnPoliciaSuPosicionEsLaCarcel() {
        Tablero tablero = Tablero.getInstance();
        Jugador unJugador = new Jugador("Magalí");
        tablero.crearCasillero(new Barrio(4000));
        Policia policia = (Policia) tablero.crearCasillero(new Policia());
        tablero.crearCasillero(new Barrio(6000));
        tablero.crearCasillero(new Quini6());
        tablero.crearCasillero(new Carcel());

        policia.pisar(unJugador);
        int posicion_carcel = Tablero.getInstance().getPosicionCarcel();
        int posicion_jugador = unJugador.getPosicion();
        Assert.assertEquals(posicion_carcel, posicion_jugador);
    }
}

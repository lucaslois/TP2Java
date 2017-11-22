package unitarias;

import exceptions.JugadorNoTieneDineroException;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Carcel;
import modelo.jugador.AccionesDelJugador;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
    @Test
    public void testJugadorCaeEnCarcelYNoPuedeAvanzar() {
        Tablero tablero = TableroFactory.crearTablero();
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli", tablero);
        carcel.pisar(jugador);
        Assert.assertFalse(jugador.puedeMoverse());
    }

    @Test
    public void testJugadorCaeEnCarcelYEstaPreso() {
        Tablero tablero = TableroFactory.crearTablero();
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli", tablero);
        carcel.pisar(jugador);
        Assert.assertTrue(jugador.estaPreso());
    }

    @Test // WHITEBOX TEST
    public void testJugadorCaeEnCarcelYDebePasar3Turnos() {
        Tablero tablero = TableroFactory.crearTablero();
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli", tablero);
        carcel.pisar(jugador);
        Assert.assertEquals(jugador.getTurnosRestantesEnCarcel(), 3);
    }

    @Test
    public void testJugadorPuedePagarFianzaSiEstaEnTurno2o3() {
        Tablero tablero = TableroFactory.crearTablero();
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev", tablero);
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        carcel.pisar(jugador);
        jugador.inicializarTurno(); // PASA EL PRIMER TURNO
        jugador.inicializarTurno(); // PASA EL SEGUNDO TURNO
        accJugador.pagarFianza(carcel);
        Assert.assertTrue(jugador.puedeMoverse());
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorNoPuedePagarFianzaEnturno2o3SeQuedaSinMovimientos() {
        Tablero tablero = TableroFactory.crearTablero();
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev", tablero);
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        jugador.pagar(80000);  // le saco plata
        carcel.pisar(jugador);
        jugador.inicializarTurno(); // PASA EL PRIMER TURNO
        jugador.inicializarTurno(); // PASA EL SEGUNDO TURNO
        accJugador.pagarFianza(carcel);
    }


}

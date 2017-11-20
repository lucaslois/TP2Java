package unitarias;

import exceptions.JugadorNoTieneDineroException;
import modelo.tablero.tipos_casilleros.Carcel;
import modelo.jugador.AccionesDelJugador;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
    @Test
    public void testJugadorCaeEnCarcelYNoPuedeAvanzar() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli");
        carcel.pisar(jugador);
        Assert.assertFalse(jugador.puedeMoverse());
    }

    @Test
    public void testJugadorCaeEnCarcelYEstaPreso() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli");
        carcel.pisar(jugador);
        Assert.assertTrue(jugador.estaPreso());
    }

    @Test // WHITEBOX TEST
    public void testJugadorCaeEnCarcelYDebePasar3Turnos() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli");
        carcel.pisar(jugador);
        Assert.assertEquals(jugador.getTurnosRestantesEnCarcel(), 3);
    }

    @Test
    public void testJugadorPuedePagarFianzaSiEstaEnTurno2o3() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        carcel.pisar(jugador);
        jugador.inicializarTurno(); // PASA EL PRIMER TURNO
        jugador.inicializarTurno(); // PASA EL SEGUNDO TURNO
        accJugador.pagarFianza(carcel);
        Assert.assertTrue(jugador.puedeMoverse());
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorNoPuedePagarFianzaEnturno2o3SeQuedaSinMovimientos() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        jugador.pagar(80000);  // le saco plata
        carcel.pisar(jugador);
        jugador.inicializarTurno(); // PASA EL PRIMER TURNO
        jugador.inicializarTurno(); // PASA EL SEGUNDO TURNO
        accJugador.pagarFianza(carcel);
    }


}

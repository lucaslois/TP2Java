package AlgoPoly;

import exceptions.JugadorNoTieneDineroException;
import modelo.casilleros.Carcel;
import modelo.jugador.AccionesDelJugador;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
    @Test
    public void testJugadorCaeEnCarcelYNoPuedeAvanzar() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Oli");
        carcel.jugadorCayoEnLaCarcel(jugador);
        Assert.assertFalse(jugador.puedeMoverse()); //aca me genero una duda el jugador maneja todos los movmientos
        //o es mejor crear una clase que se solo haga eso.....pero esa clase se justificaria mejor para la
        //parte grafica , nose help me!!!! T.T
    }

    @Test
    public void testJugadorPuedePagarFianzaSiEstaEnTurno2o3() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        carcel.jugadorCayoEnLaCarcel(jugador);
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        accJugador.pagarFianza(carcel);
        Assert.assertTrue(jugador.puedeMoverse());
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorNoPuedePagarFianzaEnturno2o3SeQuedaSinMovimientos() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        jugador.pagar(10000);  // le saco plata
        carcel.jugadorCayoEnLaCarcel(jugador);
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        accJugador.pagarFianza(carcel);
    }


}

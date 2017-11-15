package AlgoPoly;

import modelo.jugador.AccionesDelJugador;
import modelo.casilleros.Carcel;
import modelo.jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
    @Test
    public void testJugadorCaeEnCarcelYNoPuedeAvanzar() {
        Carcel carcel = new Carcel();
        Jugador unJugador = new Jugador("Oli");
        carcel.pisar(unJugador);
        
		Assert.assertFalse(unJugador.puedeMoverse()); 
    }

    @Test
    public void testJugadorPuedePagarFianzaSiEstaEnTurno2o3() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        accJugador.pagarFianza(carcel);
        Assert.assertTrue(jugador.puedeMoverse());
    }

    @Test
    public void testJugadorNoPuedePagarFianzaEnturno2o3SeQuedaSinMovimientos() {
        Carcel carcel = new Carcel();
        Jugador jugador = new Jugador("Kev");
        AccionesDelJugador accJugador = new AccionesDelJugador(jugador);
        jugador.cobrar(10000);  // muy parecido al anterior,solo se cambia esto!!
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        carcel.pisar(jugador);
        accJugador.pagarFianza(carcel);
        Assert.assertFalse(jugador.puedeMoverse());
    }


}

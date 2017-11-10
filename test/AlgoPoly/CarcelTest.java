package AlgoPoly;

import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {
	@Test
	public void testJugadorCaeEnCarcelYNoPuedeAvanzar() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador("Oli");
		
		carcel.pisar(jugador);
		
		Assert.assertFalse(jugador.avanzar());
	}

}

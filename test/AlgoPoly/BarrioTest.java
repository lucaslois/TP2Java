package AlgoPoly;

import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {
	@Test
	public void testJugadorCaeEnBarrioVolversePropietario() {
		Barrio buenosAiresSur=new Barrio(20000);
		Jugador unJugador=new Jugador("Kev");
		buenosAiresSur.pisar(unJugador);
		unJugador.comprar(buenosAiresSur);
		Assert.assertEquals(buenosAiresSur.getPropietario(), unJugador);
		
	}
	
}

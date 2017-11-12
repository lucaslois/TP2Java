package AlgoPoly;

import modelo.Jugador;
import modelo.casilleros.Quini6;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

	@Test
	public void testJugadorCaePorPrimeraVezIncrementaCapitalEn50000() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6("B");
		
		quini.pisar(unJugador);
		
		Assert.assertEquals(unJugador.getDinero(),50000+50000);
	}
	
	@Test
	public void testJugadorCaePorSegundaVezIncrementaCapitalEn30000() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6("B");
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		
		Assert.assertEquals(unJugador.getDinero(),80000+50000);
	}
	
	@Test
	public void testJugadorCaeMasDeDosVecesNoSeIncrementaCapital() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6("B");
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		quini.pisar(unJugador);

		Assert.assertEquals(unJugador.getDinero(),80000+50000);
		
	}
	

}

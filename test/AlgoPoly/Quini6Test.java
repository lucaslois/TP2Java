package AlgoPoly;

import modelo.jugador.Jugador;
import modelo.casilleros.Quini6;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

	@Test
	public void testJugadorCaePorPrimeraVezIncrementaCapitalEn50000() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6();
		
		quini.pisar(unJugador);
		
		Assert.assertEquals(unJugador.getDinero(),150000);
	}
	
	@Test
	public void testJugadorCaePorSegundaVezIncrementaCapitalEn30000() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6();
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		
		Assert.assertEquals(unJugador.getDinero(),180000);
	}
	
	@Test
	public void testJugadorCaeMasDeDosVecesNoSeIncrementaCapital() {
		Jugador unJugador = new Jugador("Oli");
		Quini6 quini = new Quini6();
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		quini.pisar(unJugador);

		Assert.assertEquals(unJugador.getDinero(),180000);
		
	}
	

}

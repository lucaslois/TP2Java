package unitarias;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.tipos_casilleros.Quini6;
import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

	@Test
	public void testJugadorCaePorPrimeraVezIncrementaCapitalEn50000() {
		Tablero tablero = new Tablero();
		Jugador unJugador = new Jugador("Oli", tablero);
		Quini6 quini = new Quini6();
		
		quini.pisar(unJugador);
		
		Assert.assertEquals((int)unJugador.getDinero(),150000);
	}
	
	@Test
	public void testJugadorCaePorSegundaVezIncrementaCapitalEn30000() {
		Tablero tablero = new Tablero();
		Jugador unJugador = new Jugador("Oli", tablero);
		Quini6 quini = new Quini6();
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		
		Assert.assertEquals((int)unJugador.getDinero(),180000);
	}
	
	@Test
	public void testJugadorCaeMasDeDosVecesNoSeIncrementaCapital() {
		Tablero tablero = new Tablero();
		Jugador unJugador = new Jugador("Oli", tablero);
		Quini6 quini = new Quini6();
		quini.pisar(unJugador);
		quini.pisar(unJugador);
		quini.pisar(unJugador);

		Assert.assertEquals((int)unJugador.getDinero(),180000);
		
	}
	

}

package modelo.jugador.estados;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public abstract class EstadoJugador {
	
	public abstract void avanzar(Jugador unJugador, int cantidad);
	
	public abstract void retroceder(Jugador unJugador, int cantidad);
	
	public abstract boolean puedeMoverse();

	public abstract void sumarTurno(Jugador unJugador);

	public abstract boolean estaPreso();

	public abstract int getTurnosRestantesEnCarcel();
}

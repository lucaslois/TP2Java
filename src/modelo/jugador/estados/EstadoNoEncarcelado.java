package modelo.jugador.estados;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;

public class EstadoNoEncarcelado extends EstadoJugador {

	@Override
	public void avanzar(int cantidad, Posicion posicion) {
		posicion.avanzar(cantidad);
		
	}

	@Override
	public void retroceder(int cantidad, Posicion posicion) {
		posicion.retroceder(cantidad);
	}

	@Override
	public boolean puedeMoverse() {
		return true;
	}

	public void sumarTurno(Jugador unJugador) {}

	public boolean estaPreso() {
		return false;
	}

	@Override
	public int getTurnosRestantesEnCarcel() {
		return 0;
	}

}

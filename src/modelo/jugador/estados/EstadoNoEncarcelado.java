package modelo.jugador.estados;

import modelo.jugador.Jugador;

public class EstadoNoEncarcelado extends EstadoJugador {

	@Override
	public void avanzar(Jugador unJugador, int cantidad) {
		if(cantidad == 0) return;
		unJugador.setNodoActual(unJugador.getNodoActual().getNodoSiguiente());
		unJugador.aumentarPaso();
		this.avanzar(unJugador, cantidad -1);
	}

	@Override
	public void retroceder(Jugador unJugador, int cantidad) {
		if(cantidad == 0) return;
		unJugador.setNodoActual(unJugador.getNodoActual().getNodoAnterior());
		unJugador.aumentarPaso();
		this.retroceder(unJugador, cantidad -1);
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

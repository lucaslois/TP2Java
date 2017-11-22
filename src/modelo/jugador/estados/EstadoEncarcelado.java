package modelo.jugador.estados;

import exceptions.JugadorNoPuedeMoverseException;
import modelo.jugador.Jugador;

public class EstadoEncarcelado extends EstadoJugador {

	private static int TURNOS_PRESO = 3;
	private int turnosRestantes;

	public EstadoEncarcelado() {
		this.turnosRestantes = TURNOS_PRESO;
	}

	public void avanzar(Jugador unJugador, int cantidad) {
		throw new JugadorNoPuedeMoverseException();
	}

	public void retroceder(Jugador unJugador, int cantidad) {
		throw new JugadorNoPuedeMoverseException();
	}

	@Override
	public boolean puedeMoverse() {
		return false;
	}

	public void sumarTurno(Jugador unJugador) {
		this.turnosRestantes--;
		if(this.turnosRestantes == 0) {
			unJugador.desencarcelar();
		}
	}

	public boolean estaPreso() {
		return true;
	}

	public int getTurnosRestantesEnCarcel() {
		return this.turnosRestantes;
	}

}

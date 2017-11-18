package modelo.jugador;

import exceptions.JugadorNoPuedeMoverseException;

public class EstadoEncarcelado extends EstadoJugador {

	@Override
	public void avanzar(int unNumero, Posicion posicion) {
		throw new JugadorNoPuedeMoverseException();
		
	}

	@Override
	public void retroceder(int cantidad, Posicion posicion) {
		throw new JugadorNoPuedeMoverseException();
		
	}

	@Override
	public boolean puedeMoverse() {
		return false;
	}

}

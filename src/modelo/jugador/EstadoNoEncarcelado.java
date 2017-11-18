package modelo.jugador;

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

}

package AlgoPoly;
public class Barrio {
	private Jugador propietario;
	private int precioTerreno;
	public Barrio(int nuevoPrecio) {
		this.precioTerreno=nuevoPrecio;
		this.propietario=null;
	}
	public Jugador getPropietario() {
		return this.propietario;
	}
	public void pisar(Jugador jugador){
		propietario=jugador;
	}

}

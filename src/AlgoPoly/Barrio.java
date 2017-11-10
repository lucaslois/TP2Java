package AlgoPoly;
public class Barrio implements Comprable {
	
	private Jugador propietario;
	private int precioTerreno;
	
	public Barrio(int nuevoPrecio) {
		this.precioTerreno=nuevoPrecio;
		this.propietario=null;
	}
	public Jugador getPropietario() {
		return this.propietario;
	}
	
	public void setPropietario(Jugador jugador) {
		this.propietario=jugador;
	}
	
	public int getPrecio() {
		return this.precioTerreno;
	}
	
	public void pisar(Jugador jugador){
		
	}
	

}

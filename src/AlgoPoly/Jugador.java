package AlgoPoly;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private int dinero;
	private ArrayList<Comprable> propiedades;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.dinero = 50000;
		this.propiedades = new ArrayList<Comprable>();
	}
	
	public int obtenerDinero() {
		return this.dinero;
	}
	
	public void cobrar(int monto) {
		this.dinero += monto;
	}

	public void comprar(Comprable unaPropiedad) throws MontoInsuficienteException {
		if(this.dinero<unaPropiedad.getPrecio())throw new MontoInsuficienteException();
		this.dinero -= unaPropiedad.getPrecio();
		this.propiedades.add(unaPropiedad);
		unaPropiedad.setPropietario(this);
		
	}

	public boolean avanzar() {
		return false;
	}
	
	

}

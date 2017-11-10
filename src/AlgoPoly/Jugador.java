package AlgoPoly;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private int dinero;
	private ArrayList<Comprable> propiedades;
	private boolean movimiento;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.dinero = 50000;
		this.propiedades = new ArrayList<Comprable>();
		this.movimiento=true; //el jugador tiene que saber cuando se puedo o no mover, lo asocio a que 
		//tiene que saber las reglas del juego y respetarlas.
	}
	
	public int obtenerDinero() {
		return this.dinero;
	}
	
	public void cobrar(int monto) {
		this.dinero += monto;
	}
	public void pagar(int monto) {
		this.dinero = monto - (this.dinero);
	}

	public void comprar(Comprable unaPropiedad) throws MontoInsuficienteException {
		if(this.dinero<unaPropiedad.getPrecio())throw new MontoInsuficienteException();
		this.dinero -= unaPropiedad.getPrecio();
		this.propiedades.add(unaPropiedad);
		unaPropiedad.setPropietario(this);
		
	}
	public void setMovimiento(boolean dato) {
	//nose me ocurrio otro nombre, tiren ideas pleaseee!! 
		this.movimiento=dato;
	}

	public boolean puedoMoverme() {
		return this.movimiento;
	}
	
}

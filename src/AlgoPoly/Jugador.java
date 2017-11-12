package AlgoPoly;

import java.util.ArrayList;

public class Jugador {
	
	private String nombre;
	private int dinero;
	private ArrayList<Comprable> propiedades;
	private boolean movimiento;
	private int posicion;
	private int numeroObtenido; // numero que tenes al tirar los dados, trato de no poner el nombre de dados XD
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.dinero = 50000;
		this.propiedades = new ArrayList<Comprable>();
		this.movimiento=true; //el jugador tiene que saber cuando se puedo o no mover, lo asocio a que 
		//tiene que saber las reglas del juego y respetarlas.
		this.posicion=0; //hay que ver esto, me causa una duda tremenda;
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
	public int getPosicion() {
		return this.posicion;
	}
	public void setPosicion(int posicionNueva) {
		this.posicion=posicionNueva;
	}
	public int todasMisPropiedades() { //!!!! atentos aca lo hago para que pase la prueba tenemos que cambiar esto 
		return 0;						//mucho muy importante!!
	}
	public int getNumeroObtenedido() {
		return this.numeroObtenido;
	}
	public void setNumeroObtenido(int numeroNuevo) {
		this.numeroObtenido=numeroNuevo;
	}
	
}

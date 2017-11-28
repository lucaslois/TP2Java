package controladores;

import modelo.jugador.Jugador;
import modelo.tablero.Tablero;

public class Usuario {
	private Jugador jugador;
	private String ficha;
	public Usuario(String nombreJugador, String nombreFicha, Tablero tablero) {
		this.jugador=new Jugador(nombreJugador, tablero);
		this.ficha=nombreFicha;	
	}
	public Jugador getJugador() {
		return this.jugador;
	}
	public String getDireccionDeFicha() {
		return this.ficha;
	}
}

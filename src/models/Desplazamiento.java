package models;

import models.casilleros.Casillero;

import java.util.Hashtable;

public class Desplazamiento extends Casillero {
	private Hashtable<Integer,Integer> sumaObtenida; //suma de los dados, podemos charlar el nombre
	public Desplazamiento(String idCasillero) {
		super(idCasillero);
		this.sumaObtenida=new Hashtable<Integer,Integer>();
		}
	public Integer cuantoSeMueve(Jugador nJugador) {
		this.sumaObtenida.put(2, 0);
		this.sumaObtenida.put(3, 1);
		this.sumaObtenida.put(4, 2);
		this.sumaObtenida.put(5, 3);
		this.sumaObtenida.put(6, 4);
		this.sumaObtenida.put(7, (nJugador.obtenerDinero()%7));
		this.sumaObtenida.put(8, (nJugador.obtenerDinero()%8));
		this.sumaObtenida.put(9, (nJugador.obtenerDinero()%9));
		this.sumaObtenida.put(10, (nJugador.obtenerDinero()%10));
		this.sumaObtenida.put(11, (11-nJugador.todasMisPropiedades()));
		this.sumaObtenida.put(12, (12-nJugador.todasMisPropiedades()));
		return sumaObtenida.get(nJugador.getNumeroObtenedido());
	}
	public void pisar(Jugador nJugador ){
		int nPosicion=cuantoSeMueve(nJugador);
		nJugador.setPosicion(nPosicion);
	}
}

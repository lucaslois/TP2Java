package modelo.tablero;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;
import modelo.tablero.tipos_casilleros.Carcel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

// SINGLETON
public class Tablero {
    private ArrayList<Posicion> listaPosiciones;
    private HashMap<Posicion, Casillero> tablero;
    private Posicion posicionCarcel = null;
    private Posicion posicionSalida = null;

    public Tablero() {
        this.tablero = new HashMap<>();
        this.listaPosiciones = new ArrayList<>();
    }

    public Casillero getCasillero(Posicion pos) {
        return this.tablero.get(pos);
    }

    public void crearCasillero(Casillero casillero) {
        Posicion pos = new Posicion();
        this.listaPosiciones.add(pos);
        this.tablero.put(pos, casillero);
    }

    /*public void crearCasillero(Carcel carcel) {
        Casillero retorno = crearCasillero((Casillero) carcel);
        this.posicionCarcel = carcel.getPosicion();
        return retorno;
    }*/

    public void avanzar(Jugador unJugador, int pasos) {
        Posicion pos = unJugador.getPosicion();
        int index = this.listaPosiciones.indexOf(pos);
        int nuevoSitio = index + pasos;
        while(nuevoSitio > this.listaPosiciones.size())
            nuevoSitio -= this.listaPosiciones.size();
        Posicion nuevaPos = this.listaPosiciones.get(nuevoSitio);
        unJugador.setPosicion(nuevaPos);

    }

    public void enviarALaCarcel(Jugador unJugador) {
        Posicion pos = this.posicionCarcel;
        unJugador.setPosicion(pos);
        unJugador.encarcelar();
    }

    public int getCantidadDeCasilleros() {
        return tablero.size();
    }

    public Posicion getPosicionCarcel() {
        return this.posicionCarcel;
    }

    public void colocarJugador(Jugador unJugador) {
        unJugador.setPosicion(this.posicionSalida);
    }

}

package modelo.tablero;

import modelo.jugador.Jugador;
import modelo.jugador.Posicion;
import modelo.tablero.tipos_casilleros.Carcel;

import java.util.ArrayList;

// SINGLETON
public class Tablero {
    private ArrayList<Casillero> tablero;
    private Posicion posicionCarcel = null;
    private Posicion posicionSalida = null;

    public Tablero() {
        this.tablero = new ArrayList<>();

    }

    public Casillero getCasillero(int id) {
        return tablero.get(1);
    }

    public Casillero crearCasillero(Casillero casillero) {
        this.tablero.add(casillero);
        return casillero;
    }

    public Casillero crearCasillero(Carcel carcel) {
        Casillero retorno = crearCasillero((Casillero) carcel);
        this.posicionCarcel = carcel.getPosicion();
        return retorno;
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

    public void avanzar(Jugador unJugador, int pasos) {

    }
}

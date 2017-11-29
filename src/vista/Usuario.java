package vista;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicion;

public class Usuario {
    private Jugador jugador;
    private Ficha ficha;
    private Nodo nodoPosicion;
    private Posicion pos;

    public Usuario(Jugador jugador, Ficha ficha) {
        this.jugador = jugador;
        this.ficha = ficha;
        this.pos = new Posicion();
    }

    public Jugador getJugador() {
        return this.jugador;
    }

    public Posicion getPosicion() {
        return this.pos;
    }

    public Ficha getFicha() {
        return this.ficha;
    }
}

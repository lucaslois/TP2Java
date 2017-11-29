package vista;

import modelo.jugador.Jugador;
import modelo.tablero.ControladorTurnos;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import vista.Casilleros.Ficha;

import java.util.ArrayList;

public class AlgoPoly {
    private static AlgoPoly ourInstance = new AlgoPoly();
    private ArrayList<Usuario> listaJugadores;
    private Tablero tablero;
    private ControladorTurnos controladorTurnos;
    private Jugador jugadorActual;

    public static AlgoPoly getInstance() {
        return ourInstance;
    }

    private AlgoPoly() {
        this.listaJugadores = new ArrayList<>();
        this.tablero = TableroFactory.crearTableroGrafico();
        this.controladorTurnos = new ControladorTurnos();
    }

    public void agregarUsuario(String nombreUsuario, Ficha ficha) {
        Jugador nuevoJugador = new Jugador(nombreUsuario, this.tablero);
        Usuario usuario = new Usuario(nuevoJugador, ficha);
        this.listaJugadores.add(usuario);
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public int getCantidadJugadores() {
        return this.listaJugadores.size();
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public Usuario getUsuarioActual() {
        return listaJugadores.get(0);
    }
}

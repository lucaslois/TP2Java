package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.jugador.Jugador;
import modelo.tablero.ControladorTurnos;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import vista.Casilleros.CasilleroVista;
import vista.Casilleros.Ficha;
import vista.Escenas.mainScene.CampoJuego;
import vista.Escenas.mainScene.PlayerInformation;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgoPoly {
    private static AlgoPoly ourInstance = new AlgoPoly();
    private ArrayList<Usuario> listaUsuarios;
    private Tablero tablero;
    private ControladorTurnos controladorTurnos;
    private Jugador jugadorActual;
    private HashMap<Jugador, Usuario> mapaJugadores;
    private HashMap<Nodo, CasilleroVista> mapaCasillerosVista;


    private PlayerInformation panelPlayerInformation;

    public static AlgoPoly getInstance() {
        return ourInstance;
    }

    private AlgoPoly() {
        this.listaUsuarios = new ArrayList<>();
        this.tablero = TableroFactory.crearTableroGrafico();
        this.controladorTurnos = new ControladorTurnos();
        this.mapaJugadores = new HashMap<>();
        this.mapaCasillerosVista = new HashMap<>();
    }

    public CasilleroVista getCasilleroVista(Nodo nodo) {
        return mapaCasillerosVista.get(nodo);
    }

    public void putMapaCasillerosVista(Nodo key, CasilleroVista value) {
        this.mapaCasillerosVista.put(key, value);
    }

    public void agregarUsuario(String nombreUsuario, Ficha ficha) {
        Jugador nuevoJugador = new Jugador(nombreUsuario, this.tablero);
        Usuario usuario = new Usuario(nuevoJugador, ficha);
        this.listaUsuarios.add(usuario);
        this.controladorTurnos.agregarJugador(nuevoJugador);
        this.mapaJugadores.put(nuevoJugador, usuario);
    }

    public Usuario getUsuario(Jugador unJugador) {
        return this.mapaJugadores.get(unJugador);
    }

    public Tablero getTablero() {
        return this.tablero;
    }

    public int getCantidadJugadores() {
        return this.listaUsuarios.size();
    }

    public Jugador getJugadorActual() {
        return this.controladorTurnos.getJugadorActual();
    }

    public Usuario getUsuarioActual() {
        return getUsuario(this.getJugadorActual());
    }

    public void setJugadorActual(Jugador jugador) { this.jugadorActual = jugador; }

    public void dibujarJugadores() {
        CampoJuego campo = CampoJuego.getInstance(this.tablero);
        campo.refresh();

        for(Usuario user : this.listaUsuarios) {
            Image imagen = user.getFicha().getImage();
            campo.add(new ImageView(imagen), user.getPosicion().getCol(), user.getPosicion().getRow());
        }

        this.panelPlayerInformation.refresh(this.getUsuarioActual());
    }

    public void turnoSiguiente() {
        this.controladorTurnos.cambiarTurno();
    }

    public void setPanelPlayerInformation(PlayerInformation panel) {
        this.panelPlayerInformation = panel;
    }
}

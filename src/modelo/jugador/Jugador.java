package modelo.jugador;

import exceptions.JugadorNoTieneDineroException;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import modelo.jugador.estados.EstadoEncarcelado;
import modelo.jugador.estados.EstadoJugador;
import modelo.jugador.estados.EstadoNoEncarcelado;

import java.util.ArrayList;

public class Jugador {

    private static int DINERO_INICIAL = 100000;

    private String nombre;

    private ControladorPropiedades controladorPropiedades;
    private EstadoJugador objEstadoMoverse; // Patrón State
    private Posicion posicion;
    private int dinero;
    private int numeroObtenido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.objEstadoMoverse = new EstadoNoEncarcelado();
        this.posicion = new Posicion();
        this.controladorPropiedades = new ControladorPropiedades();
    }

    // ########### MÉTODOS DE DINERO ###############

    public int getDinero() {
        return this.dinero;
    }

    public void cobrar(int monto) {
        this.dinero += monto;
    }

    public void pagar(int monto) {
        if(monto > this.dinero)
            throw new JugadorNoTieneDineroException();
        this.dinero -= monto;
    }

    public void comprar(Edificable unaPropiedad) {
        this.pagar(unaPropiedad.getPrecio());
        unaPropiedad.setPropietario(this);
        this.controladorPropiedades.comprar(unaPropiedad);
    }

    // ########### FIN MÉTODOS DE DINERO ###############

    // ########### MÉTODOS DE POSICIÓN ###############

    public void setPuedeMoverse(EstadoJugador estado) {
        this.objEstadoMoverse = estado;
    }

    public boolean puedeMoverse() {
        return this.objEstadoMoverse.puedeMoverse();
    }

    public int getPosicion() {
        return this.posicion.getPosicion();
    }

    public void setPosicion(Posicion posicionNueva) {
        this.posicion = posicionNueva;
    }

    public void avanzar(int cantidad)
    {
        this.objEstadoMoverse.avanzar(cantidad,this.posicion);
    }

    public void retroceder(int cantidad) {
        this.objEstadoMoverse.retroceder(cantidad,this.posicion);
    }

    // ########### FIN MÉTODOS DE POSICIÓN ###############

    // ########### MÉTODOS DE PROPIEDADES/TERRENOS ###############

    public int getCantidadTotalPropiedades() {
        return this.controladorPropiedades.getCantidadTotalPropiedades();
    }

    public ArrayList<Edificable> getPropiedades()
    {
        return this.controladorPropiedades.getPropiedades();
    }

    public boolean esDuenioDePropiedad(Comprable barrio) {
        return this.controladorPropiedades.tienePropiedad(barrio);
    }

    // ########### FIN MÉTODOS DE PROPIEDADES/TERRENOS ###############

    // ########### MÉTODOS ETC ###############

    public int getNumeroObtenedido() {
        return this.numeroObtenido;
    }

    public void setNumeroObtenido(int numeroNuevo) {
        this.numeroObtenido = numeroNuevo;
    }

    public void enviarALaCarcel() {
        int posicionCarcel = 0;
        this.posicion.setPosicion(posicionCarcel);
        this.encarcelar();
    }

    public void encarcelar() {
        this.objEstadoMoverse = new EstadoEncarcelado();
    }

    public void desencarcelar() {
        this.objEstadoMoverse = new EstadoNoEncarcelado();
    }

    /**
     * Este método debe llamarse siempre que comienza el turno del jugador. Se encarga de inicializar ciertos valores que pueden afectar al turno del jugador,
     * por ejemplo, checkea si el jugador pasa su último turno en la cárcel.
     */
    public void inicializarTurno() {
        this.objEstadoMoverse.sumarTurno(this);
    }

    public int getTurnosRestantesEnCarcel() {
        return this.objEstadoMoverse.getTurnosRestantesEnCarcel();
    }

    public boolean estaPreso() {
        return this.objEstadoMoverse.estaPreso();
    }
}

package modelo.jugador;

import exceptions.JugadorNoTieneDineroException;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
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
    private Tablero tablero;
    private Nodo nodoActual;
    private int dinero;
    private int ultimaTiradaDados;
    private int cantidadDePasosDados;

    public Jugador(String nombre, Tablero tablero) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.objEstadoMoverse = new EstadoNoEncarcelado();
        this.nodoActual = tablero.getNodoSalida();
        this.controladorPropiedades = new ControladorPropiedades();
        this.cantidadDePasosDados = 0;
        this.tablero = tablero;
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

    public Nodo getNodoActual() {
        return this.nodoActual;
    }

    public void setNodoActual(Nodo posicionNueva) {
        this.nodoActual = posicionNueva;
    }

    public void aumentarPaso() {
        this.cantidadDePasosDados++;
    }

    public void avanzar(int cantidad)
    {
        this.objEstadoMoverse.avanzar(this, cantidad);
    }

    public void retroceder(int cantidad) {
        this.objEstadoMoverse.retroceder(this, cantidad);
    }

    public int getCantidadDePasosDados() {
        return this.cantidadDePasosDados;
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
        return this.ultimaTiradaDados;
    }

    public void setUltimaTiradaDados(int numeroNuevo) {
        this.ultimaTiradaDados = numeroNuevo;
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

    public void enviarALaCarcel() {
        this.nodoActual = this.tablero.getNodoCarcel();
        this.encarcelar();
    }
}

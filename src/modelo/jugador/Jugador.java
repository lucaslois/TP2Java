package modelo.jugador;

import exceptions.JugadorNoPuedeMoverseException;
import exceptions.JugadorNoTieneDineroException;
import modelo.casilleros.*;

import java.util.ArrayList;

public class Jugador {

    private static int DINERO_INICIAL = 50000;

    private String nombre;
    private int dinero;
    private ControladorPropiedades controladorPropiedades;
    private EstadoJugador objEstadoMoverse;
    private Posicion posicion;
    private int numeroObtenido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.objEstadoMoverse = new EstadoNoEncarcelado();
        this.posicion = new Posicion();
        this.controladorPropiedades = new ControladorPropiedades();
    }

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

    public void setPuedeMoverse(EstadoJugador estado) {
        this.objEstadoMoverse = estado;
    }

    public boolean puedeMoverse() {
        return this.objEstadoMoverse.puedeMoverse();
    }

    public int getPosicion() {
        return this.posicion.getPosicion();
    }

    public void setPosicion(int posicionNueva) {
        this.posicion.setPosicion(posicionNueva);
    }

    public void avanzar(int cantidad)
    {
        
        this.objEstadoMoverse.avanzar(cantidad,this.posicion);
    }


    public void retroceder(int cantidad) {
        this.objEstadoMoverse.retroceder(cantidad,this.posicion);
    }

    // TODO: Programar metodo de jugador getCantidadTotalPropiedades() para conocer cuantas propiedades tiene.
    public int getCantidadTotalPropiedades() {
        return this.controladorPropiedades.getCantidadTotalPropiedades();
    }

    public int getNumeroObtenedido() {
        return this.numeroObtenido;
    }

    public void setNumeroObtenido(int numeroNuevo) {
        this.numeroObtenido = numeroNuevo;
    }

    public ArrayList<Edificable> getPropiedades()
    {
        return this.controladorPropiedades.getPropiedades();
    }

    public void encarcelar() {
        Tablero tablero = Tablero.getInstance();
        int posicionCarcel = tablero.getPosicionCarcel();
        this.setPosicion(posicionCarcel);
        this.objEstadoMoverse = new EstadoEncarcelado();
    }

    public boolean esDuenioDePropiedad(Comprable barrio) {
        return this.controladorPropiedades.tienePropiedad(barrio);
    }
}

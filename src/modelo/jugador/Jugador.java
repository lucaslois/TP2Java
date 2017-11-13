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
    private boolean puedeMoverse;
    private Posicion posicion;
    private int numeroObtenido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.puedeMoverse = true;
        this.posicion = new Posicion();
        this.controladorPropiedades = new ControladorPropiedades();
    }

    public int getDinero() {
        return this.dinero;
    }

    public void pagar(int monto) {
        this.dinero += monto;
    }

    public void cobrar(int monto) {
        if(monto > this.dinero)
            throw new JugadorNoTieneDineroException();
        this.dinero -= monto;
    }

    public void comprar(Edificable unaPropiedad) {
        this.cobrar(unaPropiedad.getPrecio());
        unaPropiedad.setPropietario(this);
        this.controladorPropiedades.comprar(unaPropiedad);
    }

    public void setPuedeMoverse(boolean dato) {
        this.puedeMoverse = dato;
    }

    public boolean puedeMoverse() {
        return this.puedeMoverse;
    }

    public int getPosicion() {
        return this.posicion.getPosicion();
    }

    public void setPosicion(int posicionNueva) {
        this.posicion.setPosicion(posicionNueva);
    }

    public void avanzar(int cantidad)
    {
        if(!this.puedeMoverse())
            throw new JugadorNoPuedeMoverseException();
        this.posicion.avanzar(cantidad);
    }


    public void retroceder(int cantidad) {
        if(!this.puedeMoverse())
            throw new JugadorNoPuedeMoverseException();
        this.posicion.retroceder(cantidad);
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
        this.puedeMoverse = false;
    }

    public boolean esDuenioDePropiedad(Comprable barrio) {
        return this.controladorPropiedades.tienePropiedad(barrio);
    }
}

package modelo;

import exceptions.JugadorNoPuedeMoverseException;
import exceptions.JugadorNoTieneDineroException;
import modelo.casilleros.Comprable;
import modelo.casilleros.Tablero;

import java.util.ArrayList;

public class Jugador {

    private static int DINERO_INICIAL = 50000;

    private String nombre;
    private int dinero;
    private ArrayList<Comprable> propiedades; // TODO: REVISAR, El array con interfaz Comprable no permite implementar otros metodos.
    private boolean puedeMoverse;
    private Posicion posicion;
    private int numeroObtenido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.propiedades = new ArrayList<>();
        this.puedeMoverse = true;
        this.posicion = new Posicion();
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

    public void comprar(Comprable unaPropiedad) {
        this.cobrar(unaPropiedad.getPrecio());
        this.propiedades.add(unaPropiedad);
        unaPropiedad.setPropietario(this);
    }

    public void setPuedeMoverse(boolean dato) {
        //nose me ocurrio otro nombre, tiren ideas pleaseee!!
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
        int total = 0;
        return total;
    }

    public int getNumeroObtenedido() {
        return this.numeroObtenido;
    }

    public void setNumeroObtenido(int numeroNuevo) {
        this.numeroObtenido = numeroNuevo;
    }

    public ArrayList<Comprable> getPropiedades()
    {
        return this.propiedades;
    }

    public void encarcelar() {
        Tablero tablero = Tablero.getInstance();
        int posicionCarcel = tablero.getPosicionCarcel();
        this.setPosicion(posicionCarcel);
    }

}

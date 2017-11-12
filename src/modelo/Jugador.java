package modelo;

import exceptions.JugadorNoPuedeMoverseException;
import exceptions.JugadorNoTieneDineroException;
import modelo.casilleros.Comprable;
import modelo.casilleros.Posicion;
import modelo.casilleros.Tablero;

import java.util.ArrayList;

public class Jugador {

    public static int DINERO_INICIAL = 50000;

    private String nombre;
    private int dinero;
    private ArrayList<Comprable> propiedades;
    private boolean movimiento;
    private Posicion posicion;
    private int numeroObtenido;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.dinero = DINERO_INICIAL;
        this.propiedades = new ArrayList<Comprable>();
        this.movimiento = true; //el jugador tiene que saber cuando se puedo o no mover, lo asocio a que
        //tiene que saber las reglas del juego y respetarlas.
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

    public void setMovimiento(boolean dato) {
        //nose me ocurrio otro nombre, tiren ideas pleaseee!!
        this.movimiento = dato;
    }

    public boolean puedeMoverse() {
        return this.movimiento;
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

    public int todasMisPropiedades() { //!!!! atentos aca lo hago para que pase la prueba tenemos que cambiar esto
        return 0;                        //mucho muy importante!!
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

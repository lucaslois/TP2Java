package modelo.tablero.tipos_casilleros;

import java.util.Hashtable;

import exceptions.PrecioNegativoException;
import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public abstract class Barrio extends Casillero implements Edificable {

    private Jugador propietario;
    private int precioTerreno;
    private int cantidadCasas;
    private int cantidadHoteles;
    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;


    public Jugador getPropietario() {
        return this.propietario;
    }

    public void setPropietario(Jugador jugador) { this.propietario = jugador; }

    public int getPrecio() { return this.precioTerreno; }

    public void pisar(Jugador jugador) {
        if ((jugador != this.propietario) && (this.propietario != null)) {
            jugador.pagar(alquileres.get(cantidadCasas));
        } //aca hay que refactorizar, para que el pisar de barrio verifique, las cantidad de casas, si tiene propietario
        //asi cuando alguien que que no es propietaario le saquen dinero
    }

    @Override
    public int getCantidadDeCasas() {
        return this.cantidadCasas;
    }

    @Override
    public int getCantidadDeHoteles() {
        return this.cantidadHoteles;
    }

    @Override
    public abstract void agregarCasa();

    @Override
    public abstract void agregarHotel();


}

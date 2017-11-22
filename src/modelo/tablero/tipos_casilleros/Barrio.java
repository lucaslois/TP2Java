package modelo.tablero.tipos_casilleros;

import java.util.Hashtable;

import exceptions.PrecioNegativoException;
import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public abstract class Barrio extends Casillero implements Edificable {

    private Jugador propietario;
    private int precioTerreno;



    public Barrio(int nuevoPrecio){
        if (nuevoPrecio < 0)
            throw new PrecioNegativoException();
        this.precioTerreno = nuevoPrecio;
        this.propietario = null;

    }


    public Jugador getPropietario() {
        return this.propietario;
    }

    public void setPropietario(Jugador jugador) { this.propietario = jugador; }

    public int getPrecio() { return this.precioTerreno; }



    @Override
    public abstract int getCantidadDeCasas();

    @Override
    public abstract int getCantidadDeHoteles();
    @Override
    public abstract void agregarCasa();


    @Override
    public abstract void agregarHotel();

}

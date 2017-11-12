package modelo.casilleros;

import exceptions.PrecioNegativoException;
import modelo.Jugador;

public class Barrio extends Casillero implements Comprable {

    private Jugador propietario;
    private int precioTerreno;
    private int cantidadCasas;
    private int cantidadHoteles;

    public Barrio(int nuevoPrecio, String idCasilla) {
        super(idCasilla);
        if (nuevoPrecio < 0)
            throw new PrecioNegativoException();
        this.precioTerreno = nuevoPrecio;
        this.propietario = null;
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
    }

    public Jugador getPropietario() {
        return this.propietario;
    }

    public void setPropietario(Jugador jugador) {
        this.propietario = jugador;
    }

    public int getPrecio() {
        return this.precioTerreno;
    }

    public void pisar(Jugador jugador) {

    }
}

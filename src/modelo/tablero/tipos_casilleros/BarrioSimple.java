package modelo.tablero.tipos_casilleros;

import exceptions.PrecioNegativoException;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class BarrioSimple extends Barrio {

    private Jugador propietario;
    private int precioTerreno;
    private int cantidadCasas;
    private int cantidadHoteles;
    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;

    public BarrioSimple(int nuevoPrecio,int precio0, int precio1,int precio2,int precio3) {
        if (nuevoPrecio < 0)
            throw new PrecioNegativoException();
        this.precioTerreno = nuevoPrecio;
        this.propietario = null;
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
        this.precioCasa=precio0;
        this.precioHotel=precio1;
        this.alquileres = new Hashtable<Integer, Integer>();
        this.alquileres.put(0, precio2);
        this.alquileres.put(1, precio3);
    }

    //@Override
    public void agregarCasa() {
        this.propietario.pagar(this.precioCasa);
        this.cantidadCasas++;
    }


    @Override
    public void agregarHotel() {//hay que sacar esto aca porque BarrioSimple no tiene agregarHotel pero es complicado con las interfaces
        if (this.cantidadCasas==0) {
            this.propietario.pagar(this.precioHotel);
            this.cantidadHoteles++;
            this.cantidadCasas++;//en pagar pedimos por la cantidad de casas del diccionario y en la posicion 3 esta el valor para 1 hotel
        }

    }


}

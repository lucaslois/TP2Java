package modelo.tablero.tipos_casilleros;

import exceptions.PrecioNegativoException;
import exceptions.PropiedadNoPuedeConstruirHotelException;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class BarrioSimple extends Barrio {

    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;
    private int cantidadCasas;
    private int cantidadHoteles;

    public BarrioSimple(int nuevoPrecio,int precio0, int precio1,int precio2,int precio3) {
        super(nuevoPrecio);
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
        this.precioCasa=precio0;
        this.precioHotel=precio1;
        this.alquileres = new Hashtable<Integer, Integer>();
        this.alquileres.put(0, precio2);
        this.alquileres.put(1, precio3);
    }

    public void pisar(Jugador jugador) {
        if ((jugador != this.getPropietario()) && (this.getPropietario() != null)) {
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
    public void agregarCasa() {
        this.getPropietario().pagar(this.precioCasa);
        this.cantidadCasas++;
    }


    @Override
    public void agregarHotel() {//hay que sacar esto aca porque BarrioSimple no tiene agregarHotel pero es complicado con las interfaces
        throw new PropiedadNoPuedeConstruirHotelException();

    }

}

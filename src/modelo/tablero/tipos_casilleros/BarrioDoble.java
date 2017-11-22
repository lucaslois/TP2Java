package modelo.tablero.tipos_casilleros;

import exceptions.JugadorNoEsDuenioDeAmbasPropiedades;
import exceptions.PrecioNegativoException;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class BarrioDoble extends Barrio {

    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;
    private int cantidadCasas;
    private int cantidadHoteles;

    private BarrioDoble par;

    public BarrioDoble(int nuevoPrecio,int precio0, int precio1,int precio2,int precio3,int precio4,int precio5) {
        super(nuevoPrecio);
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
        this.precioCasa=precio0;
        this.precioHotel=precio1;
        this.alquileres = new Hashtable<Integer, Integer>();
        this.alquileres.put(0, precio2);
        this.alquileres.put(1, precio3);
        this.alquileres.put(2, precio4);
        this.alquileres.put(3, precio5);
        this.par = null;
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
        if(getPropietario().esDuenioDePropiedad(par)) {
            this.getPropietario().pagar(this.precioCasa);
            this.cantidadCasas++;
        }
        else{
            throw new JugadorNoEsDuenioDeAmbasPropiedades();
        }
    }

    public BarrioDoble setPar(BarrioDoble par){
        this.par = par;
        return this;
    }

    @Override
    public void agregarHotel() {
        if (this.cantidadCasas==2) {
            this.getPropietario().pagar(this.precioHotel);
            this.cantidadHoteles++;
            this.cantidadCasas++;//en pagar pedimos por la cantidad de casas del diccionario y en la posicion 3 esta el valor para 1 hotel
        }

    }
}

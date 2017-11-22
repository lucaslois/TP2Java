package modelo.tablero.tipos_casilleros;

import exceptions.JugadorNoEsDuenioDeAmbasPropiedades;
import exceptions.PrecioNegativoException;
import modelo.jugador.Jugador;

import java.util.Hashtable;

public class BarrioDoble extends Barrio {

    private Jugador propietario;
    private int precioTerreno;
    private int cantidadCasas;
    private int cantidadHoteles;
    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;

    private BarrioDoble par;

    public BarrioDoble(int nuevoPrecio,int precio0, int precio1,int precio2,int precio3,int precio4,int precio5) {
        if (nuevoPrecio < 0)
            throw new PrecioNegativoException();
        this.precioTerreno = nuevoPrecio;
        this.propietario = null;
        this.cantidadCasas = 0;
        this.cantidadHoteles = 0;
        this.precioCasa=precio0;
        this.precioHotel=precio1;
        this.par = null;
        this.alquileres = new Hashtable<Integer, Integer>();
        this.alquileres.put(0, precio2);
        this.alquileres.put(1, precio3);
        this.alquileres.put(2, precio4);
        this.alquileres.put(3, precio5);
    }


    @Override
    public void agregarCasa() {
        if(getPropietario().esDuenioDePropiedad(par)) {
            this.propietario.pagar(this.precioCasa);
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
            this.propietario.pagar(this.precioHotel);
            this.cantidadHoteles++;
            this.cantidadCasas++;//en pagar pedimos por la cantidad de casas del diccionario y en la posicion 3 esta el valor para 1 hotel
        }

    }
}

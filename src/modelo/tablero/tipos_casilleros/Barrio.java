package modelo.tablero.tipos_casilleros;

import java.util.Hashtable;

import exceptions.PrecioNegativoException;
import modelo.tablero.Casillero;
import modelo.jugador.Jugador;

public class Barrio extends Casillero implements Edificable {

    private Jugador propietario;
    private int precioTerreno;
    private int cantidadCasas;
    private int cantidadHoteles;
    private int precioCasa;
    private int precioHotel;
    private Hashtable<Integer, Integer> alquileres;

    public Barrio(int nuevoPrecio,int precio0, int precio1,int precio2,int precio3,int precio4,int precio5) {
        if (nuevoPrecio < 0)
            throw new PrecioNegativoException();
        this.precioTerreno = nuevoPrecio;
        this.propietario = null;
        this.cantidadCasas = 0;
        this.cantidadHoteles = 2;
        this.precioCasa=precio0;
        this.precioHotel=precio1;
        this.alquileres = new Hashtable<Integer, Integer>();
        this.alquileres.put(0, precio2);
        this.alquileres.put(1, precio3);
        this.alquileres.put(2, precio4);
        this.alquileres.put(3, precio5);    
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
    	if((jugador!=this.propietario)&&(this.propietario!=null)) {
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
    	this.propietario.pagar(this.precioCasa);
        this.cantidadCasas++;
    }

    @Override
    public void agregarHotel() {
    	if (this.cantidadCasas==2) {
    		this.propietario.pagar(this.precioHotel);
    		this.cantidadHoteles++;
    	}
        
    }
}

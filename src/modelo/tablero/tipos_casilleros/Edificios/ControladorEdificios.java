package modelo.tablero.tipos_casilleros;

import exceptions.LimiteDeCasasException;
import modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class EstadoEdificable {

    // precio de los alquileres

    private List<Integer> precios;
    private int precioAlquilerHotel;
    private int cantidadDeCasas;
    private int cantidadDeHoteles;
    private int precioConstruccionCasa;
    private int precioConstruccionHotel;

    public EstadoEdificable(int precioAlqUnaCasa, int precioAlqDosCasas, int precioAlqHotel) {

        this.precios = new ArrayList<Integer>();
        this.precios.add(precioAlqUnaCasa);
        this.precios.add(precioAlqDosCasas);
        this.precioAlquilerHotel = precioAlqHotel;

        this.cantidadDeCasas = 0;
        this.cantidadDeHoteles = 0;

    }


    @Override
    public int getPrecioAlquiler() {
        if (this.cantidadDeHoteles == 0 && this.cantidadDeCasas==0) return 0;
        if (this.cantidadDeHoteles == 0) return (precios.get(this.cantidadDeCasas));
        return precioAlquilerHotel;
    }

    @Override
    public void construirCasa(Jugador jugador) {
        if (cantidadDeCasas < 2) {
            jugador.pagar(this.precioConstruccionCasa);
            cantidadDeCasas ++;
        }
        // si llegó hasta acá es porque tiene dos casas y no puede construir mas
        throw new LimiteDeCasasException();
    }

    @Override
    public void construirHotel(Jugador jugador) {
        if(cantidadDeCasas != 2){
            throw new ConstruirHotelException();
        }
        jugador.pagar(this.precioConstruccionHotel);
        cantidadDeCasas = 0;
        cantidadDeHoteles = 1;
    }
}

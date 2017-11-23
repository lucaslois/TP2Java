package modelo.tablero.tipos_casilleros.Edificios;

import exceptions.LimiteDeCasasException;
import modelo.jugador.Jugador;

import java.util.ArrayList;
import java.util.List;

public class ControladorEdificios {

    // precio de los alquileres

    private EsquemaPrecio esquema;
    private Edificio edificio;
    private int cantidadCasas;

    public ControladorEdificios(EsquemaPrecio esquema) {
        this.esquema = esquema;
        this.edificio = new CeroCasas(esquema);
    }

    public int getPrecioAlquiler() {
        return this.edificio.getPrecioDeAlquiler();
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void agregarCasa() {
        this.edificio.agregarCasaAControlador(this);
    }

    public void agregarHotel() {
        this.edificio.agregarHotelAControlador(this);
    }

    public int getCantidadHoteles() {
        return this.edificio.getCantidadDeHoteles();
    }

    public int getCantidadCasas() {
        return this.edificio.getCantidadDeCasas();
    }

    public int getPrecioConstruirCasa(){
        return esquema.getPrecioConstruirCasa();
    }

    public int getPrecioContruirHotel(){
        return esquema.getPrecioConstruirHotel();
    }
}

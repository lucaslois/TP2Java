package modelo.tablero.tipos_casilleros.Edificios;

import exceptions.LimiteDeCasasException;

public class Hotel extends Edificio {
    public Hotel(EsquemaPrecio esquema) {
        super(esquema);
    }

    @Override
    public int getPrecioDeAlquiler() {
        return this.esquema.getPrecioAlquilerHotel();
    }

    @Override
    public void agregarCasaAControlador(ControladorEdificios controlador) {
        throw new LimiteDeCasasException();
    }

    @Override
    public void agregarHotelAControlador(ControladorEdificios controlador) {
        throw new LimiteDeCasasException(); // Cambiar excepcion
    }

    @Override
    public int getCantidadDeHoteles() {
        return 1;
    }

    @Override
    public int getCantidadDeCasas() {
        return 0;
    }

    public int getPrecioDeConstruccion() {
        return this.esquema.getPrecioConstruirCasa() * 2 + this.esquema.getPrecioConstruirHotel();
    }
}

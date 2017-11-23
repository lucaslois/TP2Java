package modelo.tablero.tipos_casilleros.Edificios;

import exceptions.LimiteDeCasasException;

public class UnaCasa extends Edificio {
    public UnaCasa(EsquemaPrecio esquema) {
        super(esquema);
    }

    @Override
    public int getPrecioDeAlquiler() {
        return this.esquema.getPrecioAlquilerUnaCasa();
    }

    public void agregarCasaAControlador(ControladorEdificios controlador) {
        controlador.setEdificio(new DosCasas(esquema));
    }

    public void agregarHotelAControlador(ControladorEdificios controlador) {
        throw new LimiteDeCasasException(); // cambiar excepcion
    }

    @Override
    public int getCantidadDeHoteles() {
        return 0;
    }

    @Override
    public int getCantidadDeCasas() {
        return 1;
    }
}

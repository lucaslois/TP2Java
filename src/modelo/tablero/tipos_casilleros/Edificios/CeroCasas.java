package modelo.tablero.tipos_casilleros.Edificios;

import exceptions.LimiteDeCasasException;

public class CeroCasas extends Edificio {
    public CeroCasas(EsquemaPrecio esquema) {
        super(esquema);
    }

    @Override
    public int getPrecioDeAlquiler() {
        return esquema.getPrecioAlquilerCeroCasas();
    }

    public void agregarCasaAControlador(ControladorEdificios controlador) {
        controlador.setEdificio(new UnaCasa(esquema));
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
        return 0;
    }
}

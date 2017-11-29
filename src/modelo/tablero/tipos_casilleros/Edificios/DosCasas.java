package modelo.tablero.tipos_casilleros.Edificios;

import exceptions.LimiteDeCasasException;

public class DosCasas extends Edificio {
    public DosCasas(EsquemaPrecio esquema) {
        super(esquema);
    }

    @Override
    public int getPrecioDeAlquiler() {
        return this.esquema.getPrecioAlquilerDosCasas();
    }

    public void agregarCasaAControlador(ControladorEdificios controlador) {
        throw new LimiteDeCasasException();
    }

    public void agregarHotelAControlador(ControladorEdificios controlador) {
        controlador.setEdificio(new Hotel(esquema));
    }

    @Override
    public int getCantidadDeHoteles() {
        return 0;
    }

    @Override
    public int getCantidadDeCasas() {
        return 2;
    }

    public int getPrecioDeConstruccion() {
        return this.esquema.getPrecioConstruirCasa() * 2;
    }
}

package modelo.tablero.tipos_casilleros.Edificios;

public class UnaCasa extends Edificio {
    public UnaCasa(EsquemaPrecio esquema) {
        super(esquema);
    }

    @Override
    public int getPrecioDeAlquiler() {
        return this.esquema.getPrecioAlquilerUnaCasa();
    }
}

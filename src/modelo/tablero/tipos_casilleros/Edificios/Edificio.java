package modelo.tablero.tipos_casilleros.Edificios;

public abstract class Edificio {

    protected EsquemaPrecio esquema;
    private int cantidadDeHoteles;

    public Edificio(EsquemaPrecio esquema) {
        this.esquema = esquema;
    }

    public abstract int getPrecioDeAlquiler();

    public abstract void agregarCasaAControlador(ControladorEdificios controlador);
    public abstract void agregarHotelAControlador(ControladorEdificios controlador);

    public abstract int getCantidadDeHoteles();
    public abstract int getCantidadDeCasas();

    public abstract int getPrecioDeConstruccion();
}

package modelo.tablero.tipos_casilleros;


public interface Edificable extends Comprable {

    int getCantidadDeCasas();

    int getCantidadDeHoteles();

    void agregarCasa();

    void agregarHotel();
}

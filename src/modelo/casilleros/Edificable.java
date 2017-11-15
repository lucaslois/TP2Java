package modelo.casilleros;


public interface Edificable extends Comprable {

    int getCantidadDeCasas();

    int getCantidadDeHoteles();

    void agregarCasa();

    void agregarHotel();
}

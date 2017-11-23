package modelo.tablero.tipos_casilleros;


import modelo.jugador.Jugador;

public interface Edificable extends Comprable {

    int getCantidadDeCasas();

    int getCantidadDeHoteles();

    void agregarCasa(Jugador jugador);

    void agregarHotel(Jugador jugador);
}

package integracion;

import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.jugador.Jugador;
import org.junit.Test;

public class testJugadorTablero {
    @Test
    public void testJugadorEmpiezaEnTableroYAvanza5Casillas() {
        Jugador unJugador = new Jugador("Lucky");
        Tablero tablero = TableroFactory.crearTablero();
        tablero.colocarJugador(unJugador);
        tablero.avanzar(unJugador, 5);
    }
}

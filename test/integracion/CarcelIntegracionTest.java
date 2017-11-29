package integracion;

import modelo.jugador.Jugador;
import modelo.tablero.ControladorTurnos;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import org.junit.Assert;
import org.junit.Test;

public class CarcelIntegracionTest {

    @Test
    public void testJugadorCaeEnLaCarcelYPor3TurnosNoPuedeJugar(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador1 = new Jugador("Oli", tablero);
        Jugador jugador2 = new Jugador("Matilda",tablero);
        Jugador jugador3 = new Jugador("Pirula",tablero);
        ControladorTurnos controlador = new ControladorTurnos();

        controlador.agregarJugador(jugador1);
        controlador.agregarJugador(jugador2);
        controlador.agregarJugador(jugador3);

        jugador1.enviarALaCarcel();


        Assert.assertEquals(jugador2,controlador.getJugadorActual());
        Assert.assertEquals(2,jugador1.getTurnosRestantesEnCarcel());


    }

}

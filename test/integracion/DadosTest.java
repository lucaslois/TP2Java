package integracion;

import modelo.jugador.Jugador;
import modelo.jugador.Dados;
import modelo.tablero.ControladorTurnos;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import org.junit.Assert;
import org.junit.Test;

public class DadosTest {

    @Test
    public void testJugadorTiraDobleYPuedeVolverAAvanzar(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador1 = new Jugador("Oli", tablero);
        Jugador jugador2 = new Jugador("Matilda",tablero);
        Jugador jugador3 = new Jugador("Pirula",tablero);
        ControladorTurnos controlador = new ControladorTurnos();

        controlador.agregarJugador(jugador1);
        controlador.agregarJugador(jugador2);
        controlador.agregarJugador(jugador3);

        jugador1.setTiroDoble(true); //significa que con los dados saco doble
        Jugador jugador = controlador.getJugadorActual();
        controlador.cambiarTurno();

        Assert.assertEquals(jugador,controlador.getJugadorActual());//al sacar doble vuelve a ser el siguiente
       // TODO: REARMAR
    }

    @Test
    public void testJugadorTiraDosVecesDobleYPuedeVolverAJugar(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador1 = new Jugador("Oli", tablero);
        Jugador jugador2 = new Jugador("Matilda",tablero);
        Jugador jugador3 = new Jugador("Pirula",tablero);
        ControladorTurnos controlador = new ControladorTurnos();

        controlador.agregarJugador(jugador1);
        controlador.agregarJugador(jugador2);
        controlador.agregarJugador(jugador3);

        jugador1.setTiroDoble(true); //significa que con los dados saco doble
        controlador.getJugadorActual();//para que se actualice
        controlador.cambiarTurno();

        jugador1.setTiroDoble(true); //significa que con los dados saco doble
        Jugador jugador = controlador.getJugadorActual();
        controlador.cambiarTurno();

        Assert.assertNotEquals(jugador,controlador.getJugadorActual());
    }

    @Test
    public void testJugadorTiraDadosYAvanzaLoQueDiceLosDados(){
        Tablero tablero = TableroFactory.crearTablero();
        Jugador jugador = new Jugador("Oli", tablero);

        int cantidad = jugador.tirarDados();
        jugador.avanzar(cantidad);

        Assert.assertEquals(cantidad,jugador.getCantidadDePasosDados());

    }


}

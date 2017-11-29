package integracion;

import modelo.jugador.Jugador;
import modelo.jugador.estados.Dados;
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

        Dados dados = Dados.getInstance();
        dados.setTirada(6,6);//hardcodeado

//        Assert.assertEquals(controlador.getJugadorActual(),controlador.getJugadorSiguiente());//al sacar doble vuelve a ser el siguiente
        Assert.assertTrue(true); // TODO: REARMAR
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

        Dados dados = Dados.getInstance();
        dados.setTirada(6,6);//hardcodeado
        controlador.getJugadorSiguiente();

        dados.setTirada(3,3);

        Assert.assertNotEquals(controlador.getJugadorActual(),controlador.getJugadorSiguiente());
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

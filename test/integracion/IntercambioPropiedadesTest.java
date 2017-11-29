package integracion;


import exceptions.JugadorNoTieneDineroException;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.BarrioDoble;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import org.junit.Assert;
import org.junit.Test;

public class IntercambioPropiedadesTest {

    @Test
    public void testJugadorIntercambiaPropiedadConOtroJugadorYUnTercerJugadorCaeYElDineroLoCobraElNuevoDuenio(){
        Tablero tablero=TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Oli", tablero);
        Jugador otroJugador = new Jugador("EvilOli",tablero);
        unJugador.avanzar(7);
        BarrioSimple santaFe= (BarrioSimple) (unJugador.getNodoActual()).getCasillero();

        santaFe.pisar(unJugador);
        unJugador.comprar(santaFe);
        otroJugador.avanzar(2);
        BarrioDoble baSur = (BarrioDoble)(otroJugador.getNodoActual().getCasillero());
        baSur.pisar(otroJugador);
        otroJugador.comprar(baSur);
        unJugador.intercambiarPropiedad(santaFe,otroJugador,baSur);

        Jugador tercerJugador = new Jugador("Juan",tablero);
        tercerJugador.avanzar(7);
        int Dinero = (int)otroJugador.getDinero();
        santaFe.pisar(tercerJugador);

        Assert.assertEquals((int)otroJugador.getDinero(),Dinero + 1500);
    }

    @Test
    public void testJugadorIntercambiaPropiedadConEdificacionesConOtroJugadorYLasCasasSonRemovidasUnTercerJugadorCaeYElDineroLoCobraElNuevoDuenio() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Oli", tablero);
        Jugador otroJugador = new Jugador("EvilOli", tablero);
        unJugador.avanzar(7);
        BarrioSimple santaFe = (BarrioSimple) (unJugador.getNodoActual()).getCasillero();

        santaFe.pisar(unJugador);
        unJugador.comprar(santaFe);
        santaFe.agregarCasa(unJugador);//cambia esto a la anterior
        otroJugador.avanzar(2);
        BarrioDoble baSur = (BarrioDoble) (otroJugador.getNodoActual().getCasillero());
        baSur.pisar(otroJugador);
        otroJugador.comprar(baSur);
        unJugador.intercambiarPropiedad(santaFe,otroJugador, baSur);

        Jugador tercerJugador = new Jugador("Juan", tablero);
        tercerJugador.avanzar(7);
        int Dinero = (int) otroJugador.getDinero();
        santaFe.pisar(tercerJugador);

        Assert.assertEquals((int) otroJugador.getDinero(), Dinero + 1500);
    }

    /*@Test
    public void testJugadorNoTieneDineroParaPagarYPagaConUnaPropiedad() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador unJugador = new Jugador("Oli", tablero);
        Jugador otroJugador = new Jugador("EvilOli", tablero);
        unJugador.avanzar(7);
        BarrioSimple santaFe = (BarrioSimple) (unJugador.getNodoActual()).getCasillero();

        santaFe.pisar(unJugador);
        unJugador.comprar(santaFe);
        santaFe.agregarCasa(unJugador);
        otroJugador.avanzar(2);
        BarrioDoble baSur = (BarrioDoble) (otroJugador.getNodoActual().getCasillero());
        baSur.pisar(otroJugador);
        otroJugador.comprar(baSur);
        otroJugador.pagar(80000);
        otroJugador.avanzar(5);
        try{
            santaFe.pisar(otroJugador);
        }
        catch(JugadorNoTieneDineroException exception){
            otroJugador.intercambiarPropiedad(baSur,unJugador,null);//en forma de pago le da una propiedad
        }

        Jugador tercerJugador = new Jugador("Juan", tablero);
        tercerJugador.avanzar(2);
        int Dinero = (int) unJugador.getDinero();
        baSur.pisar(tercerJugador);

        Assert.assertEquals((int) unJugador.getDinero(), Dinero + 2000);
    }*/




}

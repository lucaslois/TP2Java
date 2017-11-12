package AlgoPoly;

import modelo.casilleros.Posicion;
import org.junit.Test;

// TODO: PRUEBAS CON NUMERACIO CIRCULAR - IGNORAR
public class PosicionTest {
    @Test
    public void testPosicionValida() {
        int avanzo = 20;
        Posicion pos = new Posicion();
        int actual = pos.posicionActual;
        pos.avanzar(avanzo);

        System.out.println("ESTOY EN "+ actual +" VOY A "+ pos.posicionActual +" LUEGO DE AVANZAR "+ avanzo);
    }

    @Test
    public void testPosicionValida2() {
        int avanzo = 4;
        Posicion pos = new Posicion();
        pos.posicionActual = 18;
        int actual = pos.posicionActual;
        pos.avanzar(avanzo);

        System.out.println("ESTOY EN "+ actual +" VOY A "+ pos.posicionActual +" LUEGO DE AVANZAR "+ avanzo);
    }
}

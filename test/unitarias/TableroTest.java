package unitarias;

import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.tablero.tipos_casilleros.Carcel;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testCreoTableroDe5CasillerosYRecorroDeFormaCircular() {
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(new Barrio(4500));
        tablero.agregarCasillero(new Barrio(4500));
        tablero.agregarCasillero(new Barrio(4500));
        tablero.agregarCasillero(new Barrio(4500));
        Carcel carcel = new Carcel();
        Nodo nodoCarcel = new Nodo(carcel);
        tablero.agregarNodo(nodoCarcel);

        Assert.assertEquals(nodoCarcel, tablero.getNodoSalida().getNodoAnterior());
    }

}

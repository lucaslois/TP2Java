package unitarias;

import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import modelo.tablero.tipos_casilleros.Carcel;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

    @Test
    public void testCreoTableroDe5CasillerosYRecorroDeFormaCircular() {
        Tablero tablero = new Tablero();
        EsquemaPrecio esquema = new EsquemaPrecio();
        esquema.setPrecioAlquilerUnaCasa(0)
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(0)
                .setPrecioConstruirHotel(0)
                .setPrecioAlquilerCeroCasas(0);
        tablero.agregarCasillero(new BarrioSimple(4500,esquema));
        tablero.agregarCasillero(new BarrioSimple(4500,esquema));
        tablero.agregarCasillero(new BarrioSimple(4500,esquema));
        tablero.agregarCasillero(new BarrioSimple(4500,esquema));
        Carcel carcel = new Carcel();
        Nodo nodoCarcel = new Nodo(carcel);
        tablero.agregarNodo(nodoCarcel);

        Assert.assertEquals(nodoCarcel, tablero.getNodoSalida().getNodoAnterior());
    }

}

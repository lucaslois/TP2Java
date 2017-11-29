package integracion;

import exceptions.JugadorNoTieneDineroException;
import modelo.jugador.Jugador;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;
import org.junit.Test;

public class JugadorVendePropiedades {

    @Test
    public void testJugadorCaeEnCasilleroQueGeneraGastoYDebeVenderPropiedadesParaPagarlo() {
        Tablero tablero = TableroFactory.crearTablero();
        Jugador propietario = new Jugador("Lucky", tablero);
        Jugador visitante = new Jugador("Magalí", tablero);

        // ASIGNO PROPIEDADES A CADA JUGADOR

        EsquemaPrecio esquema0 = new EsquemaPrecio();
        esquema0.setPrecioConstruirCasa(200)
                .setPrecioConstruirHotel(500)
                .setPrecioAlquilerCeroCasas(85000)
                .setPrecioAlquilerUnaCasa(100)
                .setPrecioAlquilerDosCasas(120)
                .setPrecioAlquilerHotel(200);

        BarrioSimple barrio0 = new BarrioSimple(4500, esquema0);

        propietario.comprar(barrio0);

        EsquemaPrecio esquema1 = new EsquemaPrecio();
        esquema1.setPrecioConstruirCasa(200)
                .setPrecioConstruirHotel(500)
                .setPrecioAlquilerCeroCasas(50)
                .setPrecioAlquilerUnaCasa(100)
                .setPrecioAlquilerDosCasas(120)
                .setPrecioAlquilerHotel(200);
        BarrioSimple barrio1 = new BarrioSimple(50000, esquema1);

        EsquemaPrecio esquema2 = new EsquemaPrecio();
        esquema2.setPrecioConstruirCasa(200)
                .setPrecioConstruirHotel(500)
                .setPrecioAlquilerCeroCasas(50)
                .setPrecioAlquilerUnaCasa(100)
                .setPrecioAlquilerDosCasas(120)
                .setPrecioAlquilerHotel(200);
        BarrioSimple barrio2 = new BarrioSimple(50000, esquema2);

        visitante.comprar(barrio1);
        visitante.comprar(barrio2);

        try {
            barrio0.pisar(visitante);
        }
        catch(JugadorNoTieneDineroException e) {
            visitante.vender(barrio1);
            visitante.vender(barrio2);
        }

        barrio0.pisar(visitante);
    }
}

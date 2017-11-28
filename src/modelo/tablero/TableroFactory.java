package modelo.tablero;

import modelo.tablero.tipos_casilleros.*;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;

public class TableroFactory {
    public static Tablero crearTablero() {
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(new Salida());
        tablero.agregarCasillero(new Quini6());
        EsquemaPrecio esquemaBaSur = new EsquemaPrecio();
        esquemaBaSur.setPrecioAlquilerUnaCasa(3000)
                .setPrecioAlquilerDosCasas(3500)
                .setPrecioAlquilerHotel(5000)
                .setPrecioConstruirCasa(5000)
                .setPrecioConstruirHotel(8000)
                .setPrecioAlquilerCeroCasas(2000);
        BarrioDoble baSur = new BarrioDoble(20000, esquemaBaSur);

        EsquemaPrecio esquemaBaNorte = new EsquemaPrecio();
        esquemaBaNorte.setPrecioAlquilerUnaCasa(3500)
                .setPrecioAlquilerDosCasas(4000)
                .setPrecioAlquilerHotel(6000)
                .setPrecioConstruirCasa(5500)
                .setPrecioConstruirHotel(9000)
                .setPrecioAlquilerCeroCasas(2500);
        BarrioDoble baNorte = new BarrioDoble(25000,esquemaBaNorte);
        baSur.setPar(baNorte);
        baNorte.setPar(baSur);
        tablero.agregarCasillero(baSur);//BA Sur
        tablero.agregarCasillero(baNorte);//BA Norte

        tablero.agregarCasillero(new Carcel());

        EsquemaPrecio esquemaCordobaSur = new EsquemaPrecio();
        esquemaCordobaSur.setPrecioAlquilerUnaCasa(1500)
                .setPrecioAlquilerDosCasas(2500)
                .setPrecioAlquilerHotel(3000)
                .setPrecioConstruirCasa(2000)
                .setPrecioConstruirHotel(3000)
                .setPrecioAlquilerCeroCasas(1000);
        BarrioDoble cordobaSur = new BarrioDoble(18000,esquemaCordobaSur);

        EsquemaPrecio esquemaCordobaNorte = new EsquemaPrecio();
        esquemaCordobaNorte .setPrecioAlquilerUnaCasa(1800)
                .setPrecioAlquilerDosCasas(2900)
                .setPrecioAlquilerHotel(3500)
                .setPrecioConstruirCasa(2200)
                .setPrecioConstruirHotel(3500)
                .setPrecioAlquilerCeroCasas(1300);
        BarrioDoble cordobaNorte = new BarrioDoble(20000,esquemaCordobaNorte);
        tablero.agregarCasillero(cordobaSur.setPar(cordobaNorte));//Cordoba Sur
        tablero.agregarCasillero(cordobaNorte.setPar(cordobaSur));//Cordoba Norte


        EsquemaPrecio esquemaSantaFe = new EsquemaPrecio();
        esquemaSantaFe.setPrecioAlquilerUnaCasa(3500)
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(4000)
                .setPrecioConstruirHotel(0)
                .setPrecioAlquilerCeroCasas(1500);
        BarrioSimple santaFe = new BarrioSimple (15000, esquemaSantaFe);
        tablero.agregarCasillero(santaFe);//Santa Fe

        EsquemaPrecio esquemaSaltaSur = new EsquemaPrecio();
        esquemaSaltaSur.setPrecioAlquilerUnaCasa(3250)
                .setPrecioAlquilerDosCasas(3850)
                .setPrecioAlquilerHotel(5500)
                .setPrecioConstruirCasa(4500)
                .setPrecioConstruirHotel(7500)
                .setPrecioAlquilerCeroCasas(2000);
        BarrioDoble saltaSur = new BarrioDoble(23000,esquemaSaltaSur);

        EsquemaPrecio esquemaSaltaNorte = new EsquemaPrecio();
        esquemaSaltaNorte.setPrecioAlquilerUnaCasa(3250)
                .setPrecioAlquilerDosCasas(3850)
                .setPrecioAlquilerHotel(5500)
                .setPrecioConstruirCasa(4500)
                .setPrecioConstruirHotel(7500)
                .setPrecioAlquilerCeroCasas(2000);
        BarrioDoble saltaNorte = new BarrioDoble(23000,esquemaSaltaNorte);
        tablero.agregarCasillero(saltaSur.setPar(saltaNorte));//Salta Sur
        tablero.agregarCasillero(saltaNorte.setPar(saltaSur));//Salta Norte
        tablero.agregarCasillero(new Policia());

        EsquemaPrecio esquemaNeuquen = new EsquemaPrecio();
        esquemaNeuquen.setPrecioAlquilerUnaCasa(3800)
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(4800)
                .setPrecioConstruirHotel(0)
                .setPrecioAlquilerCeroCasas(1800);
        tablero.agregarCasillero(new BarrioSimple(17000,esquemaNeuquen));//Neuquen

        EsquemaPrecio esquemaTucuman = new EsquemaPrecio();
        esquemaTucuman.setPrecioAlquilerUnaCasa(4500)//ESTA SERIA LA CASITA DE TUC
                .setPrecioAlquilerDosCasas(0)
                .setPrecioAlquilerHotel(0)
                .setPrecioConstruirCasa(700)
                .setPrecioConstruirHotel(0)
                .setPrecioAlquilerCeroCasas(2500);
        tablero.agregarCasillero(new BarrioSimple(25000,esquemaTucuman));//Tucuman
        return tablero;
    }//esos numeros todos feos son los alquileres, se nesecitan para hacer las pruebas
}

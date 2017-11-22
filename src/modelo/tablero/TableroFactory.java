package modelo.tablero;

import modelo.tablero.tipos_casilleros.*;

public class TableroFactory {
    public static Tablero crearTablero() {
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(new Salida());
        tablero.agregarCasillero(new Quini6());
        BarrioDoble baSur = new BarrioDoble(20000,5000,8000,2000,3000,3500,5000);
        BarrioDoble baNorte = new BarrioDoble(25000,5500,9000,2500,3500,4000,6000);
        tablero.agregarCasillero(baSur.setPar(baNorte));//BA Sur
        tablero.agregarCasillero(baNorte.setPar(baSur));//BA Norte
        tablero.agregarCasillero(new Carcel());
        BarrioDoble cordobaSur = new BarrioDoble(18000,2000,3000,1000,1500,2500,3000);
        BarrioDoble cordobaNorte = new BarrioDoble(20000,2200,3500,1300,1800,2900,3500);
        tablero.agregarCasillero(cordobaSur.setPar(cordobaNorte));//Cordoba Sur
        tablero.agregarCasillero(cordobaNorte.setPar(cordobaSur));//Cordoba Norte
        tablero.agregarCasillero(new BarrioSimple(15000,4000,0,1500,3500));//Santa Fe
        BarrioDoble saltaSur = new BarrioDoble(2000,4500,7500,2000,3250,3850,5500);
        BarrioDoble saltaNorte = new BarrioDoble(2000,4500,7500,2000,3250,3850,5500);
        tablero.agregarCasillero(saltaSur.setPar(saltaNorte));//Salta Sur
        tablero.agregarCasillero(saltaNorte.setPar(saltaSur));//Salta Norte
        tablero.agregarCasillero(new Policia());
        tablero.agregarCasillero(new BarrioSimple(17000,4800,0,1800,3800));//Neuquen
        tablero.agregarCasillero(new BarrioSimple(25000,7000,0,2500,4500));//Tucuman
        return tablero;
    }//esos numeros todos feos son los alquileres, se nesecitan para hacer las pruebas
}

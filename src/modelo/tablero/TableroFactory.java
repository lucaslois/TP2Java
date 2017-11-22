package modelo.tablero;

import modelo.tablero.tipos_casilleros.*;

public class TableroFactory {
    public static Tablero crearTablero() {
        Tablero tablero = new Tablero();
        tablero.agregarCasillero(new Salida());
        tablero.agregarCasillero(new Quini6());
        tablero.agregarCasillero(new Barrio(20000,5000,8000,2000,3000,3500,5000));//BA Sur
        tablero.agregarCasillero(new Barrio(25000,5500,9000,2500,3500,4000,6000));//BA Norte
        tablero.agregarCasillero(new Carcel());
        tablero.agregarCasillero(new Barrio(18000,2000,3000,1000,1500,2500,3000));//Cordoba Sur
        tablero.agregarCasillero(new Barrio(20000,2200,3500,1300,1800,2900,3500));//Cordoba Norte
        tablero.agregarCasillero(new Barrio(15000,4000,0,1500,3500,0,0));//Santa Fe
        tablero.agregarCasillero(new Barrio(2000,4500,7500,2000,3250,3850,5500));//Salta Norte
        tablero.agregarCasillero(new Barrio(2000,4500,7500,2000,3250,3850,5500));//Salta Sur
        tablero.agregarCasillero(new Policia());
        tablero.agregarCasillero(new Barrio(17000,4800,0,1800,3800,0,0));//Neuquen
        tablero.agregarCasillero(new Barrio(25000,7000,0,2500,4500,0,0));//Tucuman
        return tablero;
    }//esos numeros todos feos son los alquileres, se nesecitan para hacer las pruebas
}

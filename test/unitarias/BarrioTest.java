package unitarias;

import exceptions.JugadorNoEsDuenioDeAmbasPropiedades;
import exceptions.JugadorNoTieneDineroException;
import exceptions.PrecioNegativoException;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Barrio;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.BarrioDoble;
import modelo.tablero.tipos_casilleros.BarrioSimple;
import org.junit.Assert;
import org.junit.Test;

public class BarrioTest {
    @Test(expected = PrecioNegativoException.class)
    public void testCreoUnBarrioConPrecioNegativoLanzaError() {
        Barrio barrio = new BarrioSimple(-200,0,0,0,0);
    }

    @Test
    public void testJugadorCaeEnCasilleroCompraTerrenoYJugadorEsPropietarioDeTerreno() {
        Tablero tablero = TableroFactory.crearTablero();
        BarrioSimple barrio = new BarrioSimple(20000,0,0,0,0);
        Jugador unJugador = new Jugador("Kev", tablero);
        barrio.pisar(unJugador);
        unJugador.comprar(barrio);
        Assert.assertEquals(barrio.getPropietario(), unJugador);
    }

    @Test
    public void testJugadorCaseEnCasilleroCompraTerrenoYTerrenoApareceEnLaListaDePropiedadesDeJugador() {
        Tablero tablero = TableroFactory.crearTablero();
        Barrio barrio = new BarrioSimple(20000,0,0,0,0);
        Jugador unJugador = new Jugador("Lucky", tablero);
        barrio.pisar(unJugador);
        unJugador.comprar(barrio);
        Assert.assertTrue(unJugador.esDuenioDePropiedad(barrio));
    }

    @Test(expected = JugadorNoTieneDineroException.class)
    public void testJugadorCaeEnCasilleroYCompraTerrenoPeroNoTieneDinero() {
        Tablero tablero = TableroFactory.crearTablero();
        BarrioSimple barrio = new BarrioSimple(120000,0,0,0,0);
        Jugador unJugador = new Jugador("Lucky", tablero);

        unJugador.comprar(barrio);
    }
    @Test
    public void testJugadorTieneBASurYNorteContruyeCasaSuDineroSeDecrementa5000() {
    	Tablero tablero=TableroFactory.crearTablero();
    	Jugador unJugador = new Jugador("Kev", tablero);
    	unJugador.avanzar(2);
    	BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();//BA sur
    	baSur.pisar(unJugador);										
    	unJugador.comprar(baSur);
    	unJugador.avanzar(1);
    	BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
    	baNorte.pisar(unJugador);
    	unJugador.comprar(baNorte);
    	int Dinero=unJugador.getDinero();
    	baSur.agregarCasa();
    	Assert.assertEquals(unJugador.getDinero(), Dinero-5000);
    }
    @Test
    public void testJugadorTieneBASurYNorteConCasasCaeNuevoJugadorSobreAlgunaZonaSuDineroSeDecrementa3000() {
    	Tablero tablero=TableroFactory.crearTablero();
    	Jugador unJugador = new Jugador("Kev", tablero);
    	Jugador unJugador2=new Jugador("EvilKev",tablero);
    	unJugador.avanzar(2);
    	BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
    	baSur.pisar(unJugador);										
    	unJugador.comprar(baSur);
    	unJugador.avanzar(1);
    	BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
    	baNorte.pisar(unJugador);
    	unJugador.comprar(baNorte);
    	baSur.agregarCasa();
    	baNorte.agregarCasa();
    	int Dinero=unJugador2.getDinero();//dinero que tiene antes de pasar por casillero
    	unJugador2.avanzar(2);
    	baSur.pisar(unJugador2);
    	Assert.assertEquals(unJugador2.getDinero(),Dinero-3000);
    	}
    @Test 
    public void testJugadorTieneBASurYNorteCon2Casasy1RespectivamenteCaeNuevoJugadorSobreAlgunaZonaSuDineroSeDecrementa3500() {
    	Tablero tablero=TableroFactory.crearTablero();
    	Jugador unJugador = new Jugador("Kev", tablero);
    	Jugador unJugador2=new Jugador("EvilKev",tablero);
    	unJugador.avanzar(2);
    	BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
    	baSur.pisar(unJugador);										
    	unJugador.comprar(baSur);
    	unJugador.avanzar(1);
    	BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
    	baNorte.pisar(unJugador);
    	unJugador.comprar(baNorte);
    	baSur.agregarCasa();
    	baSur.agregarCasa();
    	baNorte.agregarCasa();
    	int Dinero=unJugador2.getDinero();//dinero que tiene antes de pasar por casillero
    	unJugador2.avanzar(2);
    	baSur.pisar(unJugador2);
    	Assert.assertEquals(unJugador2.getDinero(),Dinero-3500);
    	
    }
    @Test
    public void testJugadorTieneBaSurYBaNorteSinCapacidadMaximaDeCasasIntentaContruirHotelSuDineroNoSeDecrementa() {
    	Tablero tablero=TableroFactory.crearTablero();
    	Jugador unJugador = new Jugador("Kev", tablero);
    	unJugador.avanzar(2);
    	BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
    	baSur.pisar(unJugador);										
    	unJugador.comprar(baSur);
    	unJugador.avanzar(1);
    	BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
    	baNorte.pisar(unJugador);
    	unJugador.comprar(baNorte);
    	baNorte.agregarCasa();
    	baSur.agregarCasa();
    	int Dinero=unJugador.getDinero();//dinero que tiene antes de pasar por casillero
    	baSur.agregarHotel();
    	Assert.assertEquals(unJugador.getDinero(), Dinero);
    }
    @Test
    public void testJugadorTieneBaSurYBaNorteConCapacidadMaximaDeCasasIntentaContruirHotelSuDineroSeDecrementa8000() {
    	Tablero tablero=TableroFactory.crearTablero();
    	Jugador unJugador = new Jugador("Kev", tablero);//esto si esta loco tenemos que hablar sobre esto, no verifico las 4 casas
    	unJugador.avanzar(2);//solo 2 en buanos aires sur, no quiero modificar mucho el codigo
    	BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
    	baSur.pisar(unJugador);										
    	unJugador.comprar(baSur);
    	unJugador.avanzar(1);
    	BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
    	baNorte.pisar(unJugador);
    	unJugador.comprar(baNorte);
    	baNorte.agregarCasa();
    	baSur.agregarCasa();
    	baSur.agregarCasa();
    	int Dinero=unJugador.getDinero();//dinero que tiene antes de pasar por casillero
    	baSur.agregarHotel();
    	Assert.assertEquals(unJugador.getDinero(), Dinero-8000);
    	}

	@Test
	public void testJugadorTieneBaSurYBaNorteConCapacidadMaximaDeCasasContruyeUnHotelSuDineroSeDecrementa8000() {
		Tablero tablero=TableroFactory.crearTablero();
		Jugador otroJugador = new Jugador("Oli",tablero);
		Jugador unJugador = new Jugador("EvilOli", tablero);//esto si esta loco tenemos que hablar sobre esto, no verifico las 4 casas
		unJugador.avanzar(2);//solo 2 en buanos aires sur, no quiero modificar mucho el codigo
		BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
		baSur.pisar(unJugador);
		unJugador.comprar(baSur);
		unJugador.avanzar(1);
		BarrioDoble baNorte=(BarrioDoble)(unJugador.getNodoActual()).getCasillero();//Ba Norte
		baNorte.pisar(unJugador);
		unJugador.comprar(baNorte);
		baNorte.agregarCasa();
		baSur.agregarCasa();
		baSur.agregarCasa();
		int Dinero=otroJugador.getDinero();//dinero que tiene antes de pasar por casillero
		baSur.agregarHotel();
		otroJugador.avanzar(2);
		baSur.pisar(otroJugador);
		Assert.assertEquals(otroJugador.getDinero(), Dinero-5000);
	}

	//TODO: FALTA PRUEBA 8. QUE ES REPETIR LO ANTERIOR PARA CORDOBA Y SALTA

	@Test
	public void testJugadorTieneSantaFeYConstruyeUnaCasaYSuDineroSeDecremento5000(){
		Tablero tablero=TableroFactory.crearTablero();
		Jugador unJugador = new Jugador("Oli", tablero);
		unJugador.avanzar(7);
		BarrioSimple santaFe=(BarrioSimple) (unJugador.getNodoActual()).getCasillero();//Santa Fe
		santaFe.pisar(unJugador);
		unJugador.comprar(santaFe);
		unJugador.avanzar(1);
		int Dinero=unJugador.getDinero();
		santaFe.agregarCasa();
		Assert.assertEquals(unJugador.getDinero(), Dinero-4000);
	}

	@Test
	public void testJugadorTieneTucumanConstruyeLaCasitaDeTucuman() {
		Tablero tablero=TableroFactory.crearTablero();
		Jugador otroJugador = new Jugador("Oli",tablero);
		Jugador unJugador = new Jugador("EvilOli", tablero);//esto si esta loco tenemos que hablar sobre esto, no verifico las 4 casas
		unJugador.avanzar(12);//Tucuman
		BarrioSimple tucuman=(BarrioSimple) (unJugador.getNodoActual()).getCasillero();
		tucuman.pisar(unJugador);
		unJugador.comprar(tucuman);
		tucuman.agregarCasa();//queda feo porque enrealidad es un edificio historico
		int Dinero=otroJugador.getDinero();//dinero que tiene antes de pasar por casillero
		otroJugador.avanzar(12);
		tucuman.pisar(otroJugador);
		Assert.assertEquals(otroJugador.getDinero(), Dinero-4500);
	}

	@Test(expected = JugadorNoEsDuenioDeAmbasPropiedades.class)
	public void testJugadorCompraSoloUnaDeLasPropiedadesDoblesYQuierePonerUnaCasaYSeLanzaLaExcepcion(){
		Tablero tablero=TableroFactory.crearTablero();
		Jugador unJugador = new Jugador("Oli", tablero);//esto si esta loco tenemos que hablar sobre esto, no verifico las 4 casas
		unJugador.avanzar(2);//solo 2 en buanos aires sur, no quiero modificar mucho el codigo
		BarrioDoble baSur=(BarrioDoble) (unJugador.getNodoActual()).getCasillero();
		baSur.pisar(unJugador);
		unJugador.comprar(baSur);
		baSur.agregarCasa();
	}


	
}



package modelo.casilleros;

import modelo.jugador.Jugador;

import java.util.Hashtable;

public class AvanceDinamico extends Casillero {
    private Hashtable<Integer, Integer> sumaObtenida; //suma de los dados, podemos charlar el nombre

    public AvanceDinamico() {
        this.sumaObtenida = new Hashtable<Integer, Integer>();
    }

    public int cuantoSeMueve(Jugador unJugador) {
    	int dados = unJugador.getNumeroObtenedido();
    	for (int i=2; i<=6;i+=1) sumaObtenida.put(i, dados-2);//nose me ocurrio otra opcion para dividirlo en 3
    	
		for(int i=7;i<=10;i+=1) sumaObtenida.put(i,unJugador.getDinero()%dados );
		
		for(int i=11;i<=12;i+=1) sumaObtenida.put(i,dados-unJugador.getCantidadTotalPropiedades() );
		
        return sumaObtenida.get(dados);
    }

    public void pisar(Jugador unJugador) {
        int nPosicion = cuantoSeMueve(unJugador);
        unJugador.avanzar(nPosicion);
    }
}

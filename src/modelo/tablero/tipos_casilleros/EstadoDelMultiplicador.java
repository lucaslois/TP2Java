package modelo.tablero.tipos_casilleros;

import modelo.jugador.Jugador;

public class EstadoDelMultiplicador {

    private int multiplicador;

    public EstadoDelMultiplicador(int multiplicador){
        this.multiplicador = multiplicador;

    }

    public void pisar(Jugador jugador){
        int dados = jugador.getNumeroObtenedido();
        jugador.pagar(multiplicador * dados);
    }

}
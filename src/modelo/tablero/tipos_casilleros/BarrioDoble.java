package modelo.tablero.tipos_casilleros;

import exceptions.JugadorNoEsDuenioDeAmbasPropiedades;
import exceptions.PrecioNegativoException;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.Edificios.ControladorEdificios;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;

import java.util.Hashtable;

public class BarrioDoble extends Barrio {

    private ControladorEdificios controladorEdificios;
    private BarrioDoble par;

    public BarrioDoble(int nuevoPrecio, EsquemaPrecio esquema) {
        super(nuevoPrecio);
        this.controladorEdificios = new ControladorEdificios(esquema);
        this.par = null;
    }

    public void pisar(Jugador jugador) {
        if (jugador != this.getPropietario() && this.getPropietario() != null) {
            jugador.pagar(this.controladorEdificios.getPrecioAlquiler());
        }
        // TODO: Verificar que ocurre si se pisa algo que no tiene dueño asignado.
    }

    @Override
    public int getCantidadDeCasas() {
        return this.controladorEdificios.getCantidadCasas();
    }

    @Override
    public int getCantidadDeHoteles() {
        return this.controladorEdificios.getCantidadHoteles();
    }

    @Override
    public void agregarCasa(Jugador jugador) {
        if(getPropietario().esDuenioDePropiedad(par)) {
            jugador.pagar(controladorEdificios.getPrecioConstruirCasa());
            this.controladorEdificios.agregarCasa();

        }
        else{
            throw new JugadorNoEsDuenioDeAmbasPropiedades();
        }
    }

    public BarrioDoble setPar(BarrioDoble par){
        this.par = par;
        return this;
    }

    @Override
    public void agregarHotel(Jugador jugador) {
        if (this.controladorEdificios.getCantidadCasas() == 2) {
            jugador.pagar(controladorEdificios.getPrecioContruirHotel());
            this.controladorEdificios.agregarHotel();
        }
    // esto debería lanzar una excepciónL
    }
}

package modelo.tablero.tipos_casilleros;

import exceptions.CantidadInsuficienteDeCasasException;
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
        if(this.getPropietario().esDuenioDePropiedad(this.par)) {
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
        //if (this.getPropietario().esDuenioDePropiedad(par)) HACER ESTO

        if (par.getCantidadDeCasas() == 2) { // le pido al otro terreno que tenga dos casitas
            this.controladorEdificios.agregarHotel(); // acá es donde controla si este terreno no tiene la cantidad de casa suficientes.
            jugador.pagar(controladorEdificios.getPrecioContruirHotel());
        }
        else{
            throw new CantidadInsuficienteDeCasasException();
        }
    }
}

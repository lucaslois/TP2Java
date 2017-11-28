package modelo.tablero.tipos_casilleros;

import exceptions.LimiteDeCasasException;
import exceptions.PrecioNegativoException;
import exceptions.PropiedadNoPuedeConstruirHotelException;
import modelo.jugador.Jugador;
import modelo.tablero.tipos_casilleros.Edificios.ControladorEdificios;
import modelo.tablero.tipos_casilleros.Edificios.EsquemaPrecio;

import java.util.Hashtable;

public class BarrioSimple extends Barrio {
    private ControladorEdificios controladorEdificios;

    public BarrioSimple(int precio, EsquemaPrecio esquema) {
        super(precio);
        this.controladorEdificios = new ControladorEdificios(esquema);
    }

    public void pisar(Jugador jugador) {
        if (jugador != this.getPropietario() && this.getPropietario() != null) {
            jugador.pagar(this.controladorEdificios.getPrecioAlquiler());
            this.getPropietario().cobrar(this.controladorEdificios.getPrecioAlquiler());
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
        if(this.controladorEdificios.getCantidadCasas() == 1) throw new LimiteDeCasasException(); // los barrios simples sólo tienen una casa
        jugador.pagar(controladorEdificios.getPrecioConstruirCasa());
        this.controladorEdificios.agregarCasa();
    }

    @Override
    public void agregarHotel(Jugador jugador) {
        throw new PropiedadNoPuedeConstruirHotelException();
    }

    @Override
    public void eliminarEdificaciones() {
        this.controladorEdificios.eliminarEdificaciones();
    }

}

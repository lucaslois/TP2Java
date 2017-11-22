package modelo.jugador;

import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;

import java.util.ArrayList;

public class ControladorPropiedades {
    private ArrayList<Edificable> terrenos;
   // private ArrayList<Servicios> servicios;

    public ControladorPropiedades() {
        this.terrenos = new ArrayList<Edificable>();
    }

    public void comprar(Edificable unaPropiedad) {
        terrenos.add(unaPropiedad);
    }

    public ArrayList<Edificable> getPropiedades() {
        return this.terrenos;
    }

    public int getCantidadTotalPropiedades() {
        int total = 0;
        for(Edificable prop : this.terrenos) {
            total++;
            total += prop.getCantidadDeCasas() + prop.getCantidadDeHoteles();
        }
        return total;
    }

    public boolean tienePropiedad(Comprable barrio) {
        return this.terrenos.contains(barrio);
    }
}

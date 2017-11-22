package modelo.jugador;

import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import modelo.tablero.tipos_casilleros.NoEdificable;

import java.util.ArrayList;

public class ControladorPropiedades {
    private ArrayList<Edificable> terrenos;
   private ArrayList<NoEdificable> servicios;

    public ControladorPropiedades() {

        this.terrenos = new ArrayList<Edificable>();
        this.servicios = new ArrayList<NoEdificable>();
    }

    public void comprar(Edificable unaPropiedad) {
        terrenos.add(unaPropiedad);
    }

    public void comprar(NoEdificable unServicio){ servicios.add(unServicio);}

    public ArrayList<Edificable> getPropiedades() {
        return this.terrenos;
    }

    public int getCantidadTotalPropiedades() {
        int total = 0;
        for(Edificable prop : this.terrenos) {
            total++;
            total += prop.getCantidadDeCasas() + prop.getCantidadDeHoteles();
        }
        total += this.servicios.size();
        return total;
    }

    public boolean tienePropiedad(Comprable propiedad) {

        return this.terrenos.contains(propiedad) || this.servicios.contains(propiedad);
    }
}

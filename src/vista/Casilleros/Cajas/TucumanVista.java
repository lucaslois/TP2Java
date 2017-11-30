package vista.Casilleros.Cajas;

import javafx.scene.image.Image;
import modelo.jugador.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.tipos_casilleros.Comprable;
import modelo.tablero.tipos_casilleros.Edificable;
import modelo.tablero.tipos_casilleros.NoEdificable;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.CajaVista;
import vista.Escenas.mainScene.PlayerInformation;
import vista.Usuario;

import javax.swing.*;

public class TucumanVista extends CajaVista {

    public TucumanVista(Casillero casillero) {
        super(casillero);
        this.setImage(new Image("File:src/vista/assets/images/casilleros/Tablero_15.jpg"));
    }

    public void pisar(Jugador unJugador) {
        Comprable comprable = ((Comprable) this.casillero);
        if(comprable.getPropietario() != null && comprable.getPropietario() != unJugador) {
            Jugador propietario = comprable.getPropietario();
            JOptionPane.showMessageDialog(null, "Has caido en "+ comprable.getNombre() + " y es propiedad de " + propietario.getNombre() + ". Debes pagar el alquiler!");
        }
        this.casillero.pisar(unJugador);
    }

    @Override
    public void mostrarOpciones(Usuario usuario, PlayerInformation panelInformacion) {
        AlgoPoly algoPoly = AlgoPoly.getInstance();
        Comprable comprable = (Comprable) this.casillero;
        if(comprable.getPropietario() != null) {
            panelInformacion.setDisableComprarButton(true);
        }
        else {
            panelInformacion.setDisableComprarButton(false);
        }
    }

    @Override
    public void esCompradoPor(Jugador jugador) {
        jugador.comprar((Edificable) this.casillero);
        JOptionPane.showMessageDialog(null, "Has comprado Tucumán por $" + ((Comprable) this.casillero).getPrecio() + ".");
    }
}

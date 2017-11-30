package vista.Escenas.mainScene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import vista.AlgoPoly;
import vista.Casilleros.Cajas.*;

public class CampoJuego extends GridPane {
    private static CampoJuego instance;
    private Tablero tablero;


    public static CampoJuego getInstance(Tablero tablero) {
        if(instance == null)
            instance = new CampoJuego(tablero);
        return instance;
    }

    private CampoJuego(Tablero tablero) {
        this.tablero = tablero;
        this.refresh();
    }

    public void refresh() {
        Nodo nodoSalida = tablero.getNodoSalida();
        Nodo nodoActual = nodoSalida;
        AlgoPoly algo = AlgoPoly.getInstance();

        // ## FILA DE ABAJO //

        // ### CREO LA SALIDA
        CajaVista salidaVista = new SalidaVista(nodoSalida.getCasillero());
        this.add(salidaVista.getPanel(), 5, 5);
        salidaVista.setPosicion(5, 5);
        algo.putMapaCasillerosVista(nodoSalida, salidaVista);

        // ### CREO EL QUINI6
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista quini6Vista = new Quini6Vista(nodoActual.getCasillero());
        this.add(quini6Vista.getPanel(), 4, 5);
        quini6Vista.setPosicion(4, 5);
        algo.putMapaCasillerosVista(nodoActual, quini6Vista);

        // ### CREO BUENOS AIRES SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista buenosAiresSurVista = new BuenosAiresSurVista(nodoActual.getCasillero());
        this.add(buenosAiresSurVista.getPanel(), 3, 5);
        buenosAiresSurVista.setPosicion(3, 5);
        algo.putMapaCasillerosVista(nodoActual, buenosAiresSurVista);

        // ### CREO EDESUR
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista edesurVista = new EdesurVista(nodoActual.getCasillero());
        this.add(edesurVista.getPanel(), 2, 5);
        edesurVista.setPosicion(2, 5);
        algo.putMapaCasillerosVista(nodoActual, edesurVista);

        // ### CREO BUENOS AIRES NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista buenosAiresNorteVista = new BuenosAiresNorteVista(nodoActual.getCasillero());
        this.add(buenosAiresNorteVista.getPanel(), 1, 5);
        buenosAiresNorteVista.setPosicion(1, 5);
        algo.putMapaCasillerosVista(nodoActual, buenosAiresNorteVista);

        // ### CREO CARCEL
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista carcelVista = new CarcelVista(nodoActual.getCasillero());
        this.add(carcelVista.getPanel(), 0, 5);
        carcelVista.setPosicion(0, 5);
        algo.putMapaCasillerosVista(nodoActual, carcelVista);

        // ##  FIN FILA DE ABAJO //

        // ##  FILA DE LA IZQUIERDA //

        // ### CREO CORDOBA SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista cordobaSurVista = new CordobaSurVista(nodoActual.getCasillero());
        this.add(cordobaSurVista.getPanel(), 0, 4);
        cordobaSurVista.setPosicion(0, 4);
        algo.putMapaCasillerosVista(nodoActual, cordobaSurVista);

        // ### CREO AVANCE DINAMICO
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista avanceDinamicoVista = new AvanceDinamicoVista(nodoActual.getCasillero());
        this.add(avanceDinamicoVista.getPanel(), 0, 3);
        avanceDinamicoVista.setPosicion(0, 3);
        algo.putMapaCasillerosVista(nodoActual, avanceDinamicoVista);

        // ### CREO SUBTE
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista subeVista = new SubteVista(nodoActual.getCasillero());
        this.add(subeVista.getPanel(), 0, 2);
        subeVista.setPosicion(0, 2);
        algo.putMapaCasillerosVista(nodoActual, subeVista);

        // ### CREO CORDOBA NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista cordobaNorteVista = new CordobaNorteVista(nodoActual.getCasillero());
        this.add(cordobaNorteVista.getPanel(), 0, 1);
        cordobaNorteVista.setPosicion(0, 1);
        algo.putMapaCasillerosVista(nodoActual, cordobaNorteVista);

        // ### CREO IMPUESTO
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista impuestoVista = new ImpuestoVista(nodoActual.getCasillero());
        this.add(impuestoVista.getPanel(), 0, 0);
        impuestoVista.setPosicion(0, 0);
        algo.putMapaCasillerosVista(nodoActual, impuestoVista);

        // ### CREO SANTA FE
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista santaFeVista = new SantaFeVista(nodoActual.getCasillero());
        this.add(santaFeVista.getPanel(), 1, 0);
        santaFeVista.setPosicion(1, 0);
        algo.putMapaCasillerosVista(nodoActual, santaFeVista);

        // ### CREO AYSA
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista aysaVista = new AysaVista(nodoActual.getCasillero());
        this.add(aysaVista.getPanel(), 2, 0);
        aysaVista.setPosicion(2, 0);
        algo.putMapaCasillerosVista(nodoActual, aysaVista);

        // ### CREO SALTA NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista saltaNorteVista = new SaltaNorteVista(nodoActual.getCasillero());
        this.add(saltaNorteVista.getPanel(), 3, 0);
        saltaNorteVista.setPosicion(3, 0);
        algo.putMapaCasillerosVista(nodoActual, saltaNorteVista);

        // ### CREO SALTA SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista saltaSurVista = new SaltaSurVista(nodoActual.getCasillero());
        this.add(saltaSurVista.getPanel(), 4, 0);
        saltaSurVista.setPosicion(4, 0);
        algo.putMapaCasillerosVista(nodoActual, saltaSurVista);

        // ### CREO POLICIA
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista policiaVista = new PoliciaVista(nodoActual.getCasillero());
        this.add(policiaVista.getPanel(), 5, 0);
        policiaVista.setPosicion(5, 0);
        algo.putMapaCasillerosVista(nodoActual, policiaVista);

        // ### CREO TREN
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista trenVista = new TrenVista(nodoActual.getCasillero());
        this.add(trenVista.getPanel(), 5, 1);
        trenVista.setPosicion(5, 1);
        algo.putMapaCasillerosVista(nodoActual, trenVista);

        // ### CREO NEUQEN
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista nequenVista = new NeuquenVista(nodoActual.getCasillero());
        this.add(nequenVista.getPanel(), 5, 2);
        nequenVista.setPosicion(5, 2);
        algo.putMapaCasillerosVista(nodoActual, nequenVista);

        // ### CREO RETROCESO DINAMICO
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista retrocesoVista = new RetrocesoDinamicoVista(nodoActual.getCasillero());
        this.add(retrocesoVista.getPanel(), 5, 3);
        retrocesoVista.setPosicion(5, 3);
        algo.putMapaCasillerosVista(nodoActual, retrocesoVista);

        // ### CREO TUCUMAN
        nodoActual = nodoActual.getNodoSiguiente();
        CajaVista tucumanVista = new TucumanVista(nodoActual.getCasillero());
        this.add(tucumanVista.getPanel(), 5, 4);
        tucumanVista.setPosicion(5, 4);
        algo.putMapaCasillerosVista(nodoActual, tucumanVista);

        this.add(new ImageView(new Image("File:src/vista/assets/images/casilleros/Tablero_08.jpg")), 1, 1, 4, 4);
    }
}

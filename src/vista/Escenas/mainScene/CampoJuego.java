package vista.Escenas.mainScene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import vista.AlgoPoly;
import vista.Casilleros.CasilleroVista;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicion;

import java.util.HashMap;

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
        CasilleroVista salidaVista = new CasilleroVista(nodoSalida.getCasillero());
        salidaVista.setImage("File:src/vista/assets/images/casilleros/Tablero_21.jpg");
        this.add(salidaVista.getPanel(), 5, 5);
        salidaVista.setPosicion(5, 5);
        algo.putMapaCasillerosVista(nodoSalida, salidaVista);

        // ### CREO EL QUINI6
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista quini6Vista = new CasilleroVista(nodoActual.getCasillero());
        quini6Vista.setImage("File:src/vista/assets/images/casilleros/Tablero_20.jpg");
        this.add(quini6Vista.getPanel(), 4, 5);
        quini6Vista.setPosicion(4, 5);
        algo.putMapaCasillerosVista(nodoActual, quini6Vista);

        // ### CREO BUENOS AIRES SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista buenosAiresSurVista = new CasilleroVista(nodoActual.getCasillero());
        buenosAiresSurVista.setImage("File:src/vista/assets/images/casilleros/Tablero_19.jpg");
        this.add(buenosAiresSurVista.getPanel(), 3, 5);
        buenosAiresSurVista.setPosicion(3, 5);
        algo.putMapaCasillerosVista(nodoActual, buenosAiresSurVista);

        // ### CREO EDESUR
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista edesurVista = new CasilleroVista(nodoActual.getCasillero());
        edesurVista.setImage("File:src/vista/assets/images/casilleros/Tablero_18.jpg");
        this.add(edesurVista.getPanel(), 2, 5);
        edesurVista.setPosicion(2, 5);
        algo.putMapaCasillerosVista(nodoActual, edesurVista);

        // ### CREO BUENOS AIRES NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista buenosAiresNorteVista = new CasilleroVista(nodoActual.getCasillero());
        buenosAiresNorteVista.setImage("File:src/vista/assets/images/casilleros/Tablero_17.jpg");
        this.add(buenosAiresNorteVista.getPanel(), 1, 5);
        buenosAiresNorteVista.setPosicion(1, 5);
        algo.putMapaCasillerosVista(nodoActual, buenosAiresNorteVista);

        // ### CREO CARCEL
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista carcelVista = new CasilleroVista(nodoActual.getCasillero());
        carcelVista.setImage("File:src/vista/assets/images/casilleros/Tablero_16.jpg");
        this.add(carcelVista.getPanel(), 0, 5);
        carcelVista.setPosicion(0, 5);
        algo.putMapaCasillerosVista(nodoActual, carcelVista);

        // ##  FIN FILA DE ABAJO //

        // ##  FILA DE LA IZQUIERDA //

        // ### CREO CORDOBA SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista cordobaSurVista = new CasilleroVista(nodoActual.getCasillero());
        cordobaSurVista.setImage("File:src/vista/assets/images/casilleros/Tablero_14.jpg");
        this.add(cordobaSurVista.getPanel(), 0, 4);
        cordobaSurVista.setPosicion(0, 4);
        algo.putMapaCasillerosVista(nodoActual, cordobaSurVista);

        // ### CREO AVANCE DINAMICO
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista avanceDinamicoVista = new CasilleroVista(nodoActual.getCasillero());
        avanceDinamicoVista.setImage("File:src/vista/assets/images/casilleros/Tablero_12.jpg");
        this.add(avanceDinamicoVista.getPanel(), 0, 3);
        avanceDinamicoVista.setPosicion(0, 3);
        algo.putMapaCasillerosVista(nodoActual, avanceDinamicoVista);

        // ### CREO SUBTE
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista subeVista = new CasilleroVista(nodoActual.getCasillero());
        subeVista.setImage("File:src/vista/assets/images/casilleros/Tablero_10.jpg");
        this.add(subeVista.getPanel(), 0, 2);
        subeVista.setPosicion(0, 2);
        algo.putMapaCasillerosVista(nodoActual, subeVista);

        // ### CREO CORDOBA NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista cordobaNorteVista = new CasilleroVista(nodoActual.getCasillero());
        cordobaNorteVista.setImage("File:src/vista/assets/images/casilleros/Tablero_07.jpg");
        this.add(cordobaNorteVista.getPanel(), 0, 1);
        cordobaNorteVista.setPosicion(0, 1);
        algo.putMapaCasillerosVista(nodoActual, cordobaNorteVista);

        // ### CREO IMPUESTO
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista impuestoVista = new CasilleroVista(nodoActual.getCasillero());
        impuestoVista.setImage("File:src/vista/assets/images/casilleros/Tablero_01.jpg");
        this.add(impuestoVista.getPanel(), 0, 0);
        impuestoVista.setPosicion(0, 0);
        algo.putMapaCasillerosVista(nodoActual, impuestoVista);

        // ### CREO SANTA FE
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista santaFeVista = new CasilleroVista(nodoActual.getCasillero());
        santaFeVista.setImage("File:src/vista/assets/images/casilleros/Tablero_02.jpg");
        this.add(santaFeVista.getPanel(), 1, 0);
        santaFeVista.setPosicion(1, 0);
        algo.putMapaCasillerosVista(nodoActual, santaFeVista);

        // ### CREO AYSA
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista aysaVista = new CasilleroVista(nodoActual.getCasillero());
        aysaVista.setImage("File:src/vista/assets/images/casilleros/Tablero_03.jpg");
        this.add(aysaVista.getPanel(), 2, 0);
        aysaVista.setPosicion(2, 0);
        algo.putMapaCasillerosVista(nodoActual, aysaVista);

        // ### CREO SALTA NORTE
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista saltaNorteVista = new CasilleroVista(nodoActual.getCasillero());
        saltaNorteVista.setImage("File:src/vista/assets/images/casilleros/Tablero_04.jpg");
        this.add(saltaNorteVista.getPanel(), 3, 0);
        saltaNorteVista.setPosicion(3, 0);
        algo.putMapaCasillerosVista(nodoActual, saltaNorteVista);

        // ### CREO SALTA SUR
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista saltaSurVista = new CasilleroVista(nodoActual.getCasillero());
        saltaSurVista.setImage("File:src/vista/assets/images/casilleros/Tablero_05.jpg");
        this.add(saltaSurVista.getPanel(), 4, 0);
        saltaSurVista.setPosicion(4, 0);
        algo.putMapaCasillerosVista(nodoActual, saltaSurVista);

        // ### CREO POLICIA
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista policiaVista = new CasilleroVista(nodoActual.getCasillero());
        policiaVista.setImage("File:src/vista/assets/images/casilleros/Tablero_06.jpg");
        this.add(policiaVista.getPanel(), 5, 0);
        policiaVista.setPosicion(5, 0);
        algo.putMapaCasillerosVista(nodoActual, policiaVista);

        // ### CREO TREN
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista trenVista = new CasilleroVista(nodoActual.getCasillero());
        trenVista.setImage("File:src/vista/assets/images/casilleros/Tablero_09.jpg");
        this.add(trenVista.getPanel(), 5, 1);
        trenVista.setPosicion(5, 1);
        algo.putMapaCasillerosVista(nodoActual, trenVista);

        // ### CREO NEUQEN
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista nequenVista = new CasilleroVista(nodoActual.getCasillero());
        nequenVista.setImage("File:src/vista/assets/images/casilleros/Tablero_11.jpg");
        this.add(nequenVista.getPanel(), 5, 2);
        nequenVista.setPosicion(5, 2);
        algo.putMapaCasillerosVista(nodoActual, nequenVista);

        // ### CREO RETROCESO DINAMICO
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista retrocesoVista = new CasilleroVista(nodoActual.getCasillero());
        retrocesoVista.setImage("File:src/vista/assets/images/casilleros/Tablero_13.jpg");
        this.add(retrocesoVista.getPanel(), 5, 3);
        retrocesoVista.setPosicion(5, 3);
        algo.putMapaCasillerosVista(nodoActual, retrocesoVista);

        // ### CREO TUCUMAN
        nodoActual = nodoActual.getNodoSiguiente();
        CasilleroVista tucumanVista = new CasilleroVista(nodoActual.getCasillero());
        tucumanVista.setImage("File:src/vista/assets/images/casilleros/Tablero_15.jpg");
        this.add(tucumanVista.getPanel(), 5, 4);
        tucumanVista.setPosicion(5, 4);
        algo.putMapaCasillerosVista(nodoActual, tucumanVista);

        this.add(new ImageView(new Image("File:src/vista/assets/images/casilleros/Tablero_08.jpg")), 1, 1, 4, 4);
    }
}

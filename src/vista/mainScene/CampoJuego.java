package vista.mainScene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modelo.tablero.Casillero;
import modelo.tablero.Nodo;
import modelo.tablero.Tablero;
import modelo.tablero.TableroFactory;
import modelo.tablero.tipos_casilleros.Salida;
import vista.Casilleros.CasilleroVista;
import vista.Casilleros.Ficha;
import vista.Casilleros.Posicionador;

public class CampoJuego extends GridPane {
    public CampoJuego() {
        Ficha ficha = new Ficha("file:src/vista/assets/images/ficha_01.png");
        Tablero tablero = TableroFactory.crearTablero();
        Nodo nodo = tablero.getNodoSalida();
        Nodo iterator = nodo.getNodoSiguiente();
        Posicionador pos = new Posicionador();
        while(nodo != iterator) {
            CasilleroVista salida = new CasilleroVista();
            salida.setImage("File:src/vista/assets/images/casilleros/Tablero_21.jpg");
            this.add(salida.getPanel(), pos.getRow(), pos.getCol());
            System.out.println("COL: " + pos.getCol() + " ROW: " + pos.getRow());
            pos.next();
            iterator = iterator.getNodoSiguiente();
        }
/*
        // FILA DE ABAJO
        CasilleroVista salida = new CasilleroVista();
        salida.setImage("File:src/vista/assets/images/casilleros/Tablero_21.jpg");
        salida.addFicha(ficha);
        CasilleroVista quini6 = new CasilleroVista();
        quini6.setImage("File:src/vista/assets/images/casilleros/Tablero_20.jpg");
        CasilleroVista barrio1 = new CasilleroVista();
        barrio1.setImage("File:src/vista/assets/images/casilleros/Tablero_19.jpg");
        CasilleroVista edesur = new CasilleroVista();
        edesur.setImage("File:src/vista/assets/images/casilleros/Tablero_18.jpg");
        CasilleroVista barrio2 = new CasilleroVista();
        barrio2.setImage("File:src/vista/assets/images/casilleros/Tablero_17.jpg");
        CasilleroVista carcel = new CasilleroVista();
        carcel.setImage("File:src/vista/assets/images/casilleros/Tablero_16.jpg");

        // COLUMNA IZQUIERDA
        CasilleroVista barrio3 = new CasilleroVista();
        barrio3.setImage("File:src/vista/assets/images/casilleros/Tablero_14.jpg");
        CasilleroVista avance = new CasilleroVista();
        avance.setImage("File:src/vista/assets/images/casilleros/Tablero_12.jpg");
        CasilleroVista subte = new CasilleroVista();
        subte.setImage("File:src/vista/assets/images/casilleros/Tablero_10.jpg");
        CasilleroVista barrio4 = new CasilleroVista();
        barrio4.setImage("File:src/vista/assets/images/casilleros/Tablero_07.jpg");
        CasilleroVista impuesto = new CasilleroVista();
        impuesto.setImage("File:src/vista/assets/images/casilleros/Tablero_01.jpg");

        // FILA TOP
        CasilleroVista barrio5 = new CasilleroVista();
        barrio5.setImage("File:src/vista/assets/images/casilleros/Tablero_02.jpg");
        CasilleroVista aysa = new CasilleroVista();
        aysa.setImage("File:src/vista/assets/images/casilleros/Tablero_03.jpg");
        CasilleroVista barrio6 = new CasilleroVista();
        barrio6.setImage("File:src/vista/assets/images/casilleros/Tablero_04.jpg");
        CasilleroVista barrio7 = new CasilleroVista();
        barrio7.setImage("File:src/vista/assets/images/casilleros/Tablero_05.jpg");
        CasilleroVista policia = new CasilleroVista();
        policia.setImage("File:src/vista/assets/images/casilleros/Tablero_06.jpg");

        // COLUMNA RIGHT
        CasilleroVista tren = new CasilleroVista();
        tren.setImage("File:src/vista/assets/images/casilleros/Tablero_10.jpg");
        CasilleroVista barrio8 = new CasilleroVista();
        barrio8.setImage("File:src/vista/assets/images/casilleros/Tablero_11.jpg");
        CasilleroVista retroceso = new CasilleroVista();
        retroceso.setImage("File:src/vista/assets/images/casilleros/Tablero_13.jpg");
        CasilleroVista barrio9 = new CasilleroVista();
        barrio9.setImage("File:src/vista/assets/images/casilleros/Tablero_15.jpg");

        this.add(salida.getPanel(), 5, 5);
        this.add(quini6.getPanel(), 4, 5);
        this.add(barrio1.getPanel(), 3, 5);
        this.add(edesur.getPanel(), 2, 5);
        this.add(barrio2.getPanel(), 1, 5);
        this.add(carcel.getPanel(), 0, 5);

        this.add(barrio3.getPanel(), 0, 4);
        this.add(avance.getPanel(), 0, 3);
        this.add(subte.getPanel(), 0, 2);
        this.add(barrio4.getPanel(), 0, 1);
        this.add(impuesto.getPanel(), 0, 0);

        this.add(barrio5.getPanel(), 1, 0);
        this.add(aysa.getPanel(), 2, 0);
        this.add(barrio6.getPanel(), 3, 0);
        this.add(barrio7.getPanel(), 4, 0);
        this.add(policia.getPanel(), 5, 0);

        this.add(tren.getPanel(), 5, 1);
        this.add(barrio8.getPanel(), 5, 2);
        this.add(retroceso.getPanel(), 5, 3);
        this.add(barrio9.getPanel(), 5, 4);*/

        //this.add(new ImageView(new Image("File:src/vista/assets/images/casilleros/Tablero_08.jpg")), 1, 1, 4, 4);
    }
}

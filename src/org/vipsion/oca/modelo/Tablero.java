package org.vipsion.oca.modelo;

import java.util.ArrayList;
import java.util.List;
/**
 * Crea un tablero que contendrá una lista de Casillas
 *
 * @author Alvaro Perez
 * @see Casilla
 */
public class Tablero {

    private List<Casilla> casillas;
    private final int numCasillas;

    /**
     * Crea un objeto de tipo tablero y le asigna las casillas "Oca" y Fin
     */
    public Tablero() {
        this.numCasillas = 63;
        this.casillas = new ArrayList<>();
        for (int i = 0; i < numCasillas; i++) {
            this.casillas.add(new Casilla(i + 1));
        }
        casillas.set(8, new Oca(9, 5));
        casillas.set(17, new Oca(18, 5));
        casillas.set(26, new Oca(27, 5));
        casillas.set(35, new Oca(36, 5));
        casillas.set(44, new Oca(45, 5));
        casillas.set(53, new Oca(54, 5));
        casillas.set(4, new Oca(5, 4));
        casillas.set(13, new Oca(14, 4));
        casillas.set(22, new Oca(23, 4));
        casillas.set(65, new CasillaDado(25));
        casillas.set(65, new CasillaDado(31));
        casillas.set(31, new Oca(32, 4));
        casillas.set(40, new Oca(41, 4));
        casillas.set(49, new Oca(50, 4));
        casillas.set(54, new OcaFin(59, 4));
        casillas.set(62, new Fin(63));
    }

    /**
     * Metodo que mueve la ficha del jugador una cantidad de posiciones pasado por parametro
     * 
     * @param ficha Objeto de tipo Ficha que pertenece a Jugador
     * @param numDado Numero generado aleatoriamente mediante el metodo {@link Dado#dameNumero()}
     */
    public void mueveFicha(Ficha ficha, int numDado) {

        int numCasilla = ficha.getPosicion() + numDado;

        if (numCasilla > numCasillas) {
            numCasilla = (numCasillas - ((ficha.getPosicion() + numDado) - numCasillas));
        }
        casillas.get(numCasilla - 1).posaFicha(ficha);
    }

}

package org.vipsion.oca.modelo;
/**
 * Configura la posicion de las distintas casillas pertenecientes al tablero
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author Alvaro Perez
 * @see Tablero
 * @see Ficha
 */
public class Casilla {

    protected int posicion;
    
    /**
     * Inicializa la casilla a la posicion pasada como parametro
     * @param posicion numero que representa una posicion en el tablero
     */
    public Casilla(int posicion) {
        this.posicion = posicion;
    }
    
    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
    
    public int getPosicion(){
        return this.posicion;
    }
    /**
     * Posiciona la ficha en la casilla indicada por <code>Juego</code>
     * @param ficha Objeto que se encarga de devolver los valores de la posicion
     * en la que se encuentra, turnos extra y si ha terminado o no
     */
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion);
    }

}

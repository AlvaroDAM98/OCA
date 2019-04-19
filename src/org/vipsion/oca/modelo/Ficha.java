package org.vipsion.oca.modelo;
/**
 * Se encarga de crear la ficha del jugador, almacena la posicion y los turnos
 * extra que tienen.
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 * 
 * @author Alvaro Perez
 * @see Jugador
 */
public class Ficha {

    private int posicion;
    private int turnosExtra;
    private Boolean fin;
    // private int turnosSinTirar; 

    /**
     * Devuelve el valor de fin, si <code>true</code> la partida se termina, si 
     * <code>false</code> la partida continua
     * 
     * @return <code>true</code> si la ficha llega a la ultima posicion del tablero 
     * <code>false</code> si no ha llegado ninguna todavía
     */
    public Boolean getFin() {
        return fin;
    }
    /**
     * asigna un valor al atributo booleano fin
     * @param fin atributo que controla el final de la partida
     */
    public void setFin(Boolean fin) {
        this.fin = fin;
    }
    /**
     * Inicializa la ficha en la primera posicion sin turnos extra y con el atributo fin
     * en <code>false</code>
     */
    public Ficha() {
        posicion = 1;
        fin = false;
        turnosExtra = 0;
    }
    /**
     * Devuelve la posicion de la ficha
     * @return la posicon actual en la que se encuentra la ficha
     */
    public int getPosicion() {
        return posicion;
    }
    /**
     * Asigna una posicion a la ficha
     * @param posicion atributo que controla la posicion de la ficha en el tablero
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    /**
     * Devuelve la cantidad de turnos extra que tiene un jugador
     * @return el numero de turnos extra
     */
    public int getTurnosExtra() {
        return turnosExtra;
    }
    /**
     * Asigna una cantidad pasada por parametro a turnosExtra
     * @param turnosExtra Numero de turnos extra que tendrá un jugador
     */
    public void setTurnosExtra(int turnosExtra) {
        this.turnosExtra = turnosExtra;
    }
    /**
     * Disminuye en 1 la cantidad de turnos extra que tenga un jugador, en caso de que tenga
     */
    public void decrementaTurnosExtra() {
        turnosExtra--;
    }

}

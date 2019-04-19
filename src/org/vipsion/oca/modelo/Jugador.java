package org.vipsion.oca.modelo;
/**
 * Controla los turnos de cada jugador
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author Alvaro Perez
 * @see Dado
 * @see Ficha
 * @see Tablero
 */
public class Jugador {

    private final Ficha ficha;
    private int ultimoValorDado;
    /**
     * Inicializa Jugador con un objeto <code>Ficha</code>
     */
    public Jugador() {
        this.ficha = new Ficha();
    }
    /**
     * Metodo que guarda el ultimo valor dado por el dado y mueve la ficha del
     * jugador mediante el metodo {@link Tablero#mueveFicha} y devuelve la posicion
     * de la ficha
     * 
     * @param tablero Objeto de la clase <code>Tablero</code>
     * @return La posicion en la que se ha quedado la ficha del jugador despues del
     * movimiento
     */
    public int juegaTurno(Tablero tablero) {
        ultimoValorDado = Dado.dameNumero();
        tablero.mueveFicha(ficha, ultimoValorDado);
        return ficha.getPosicion();
    }
    /**
     * Devuelve la ultima posicion de la ficha
     * @return Numero que representa la ultima posicion en la que estuvo la ficha
     */
    public int getUltimoValorDado() {
        return ultimoValorDado;
    }
    /**
     * Actualiza el valor de Dado
     * @param ultimoValorDado ultimo valor dado por Dado
     * @see Dado
     */
    public void setUltimoValorDado(int ultimoValorDado) {
        this.ultimoValorDado = ultimoValorDado;
    }
    /**
     * Devuelve la ultima posicion de la ficha
     * @return Numero que representa la ultima posicion en la que estuvo la ficha
     */
    public int getUltimaPosicionTablero() {
        return ficha.getPosicion();
    }
    /**
     * Metodo que devuelve la cantidad de turnos extra que tiene un jugador
     * 
     * @see Jugador
     * @see Ficha
     * @return numero de turnos extra que pertenecen al jugador
     */
    public int getTurnosExtra() {
        return (ficha.getTurnosExtra());
    }
    /**
     * Metodo que disminuye la cantidad de turnos extra de un jugador
     * El metodo decrementa el contador de uno en uno
     * @see Ficha#decrementaTurnosExtra()
     */
    public void decrementaTurnosExtra() {
        ficha.decrementaTurnosExtra();
    }
    /**
     * Devuelve el estado actual del atributo fin de la clase Ficha
     * @see Ficha#getFin()
     * 
     * @see Ficha 
     * @return un booleano que indica el estado de la partida
     */
    public Boolean esGanador() {
        return ficha.getFin();
    }
}

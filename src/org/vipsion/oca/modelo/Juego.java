package org.vipsion.oca.modelo;

import java.util.ArrayList;
import java.util.List;
import org.vipsion.oca.controlador.Coordinador;
/**
 *  Juego es una clase que configura la partida.
 * 
 *  <p>Asigna un numero de jugadores y los guarda en <code>jugadores</code>.
 *  Controla los turnos de los jugadores.
 *  Crea un Objeto Tablero.
 *  Crea un Coordinador que actua de intermediario.</p>
 * 
 *  @author Alvaro Perez
 *  @version 0.1
 *  @see Tablero
 *  @see Jugador
 *  @see Coordinador
 */
public class Juego {

    private Coordinador coordinador;
    private final List<Jugador> jugadores;
    private int turno = 0;
    private final Tablero tablero;
    private final int numJugadores = 2;

    /**
     * Crea un nuevo juego con dos jugadores
     */
    public Juego() {
        jugadores = new ArrayList<>();
        tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }
    /**
     * asigna un cordinador a la clase
     * @see Coordinador
     * @param coordinador se encarga de organizar las peticiones provenientes de
     * diferentes clases
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    /**
     * Controla los turnos entre los jugadores de la partida
     * <p>
     * en caso de que el jugador tenga mas de un turno seguido el metodo 
     * decrementará el numero de <code>turnosExtra</code>
     * @see Jugador#getTurnosExtra
     * @see Jugador#decrementaTurnosExtra
     * @return un numero que representa el siguiente turno de la partida
     */
    public int sigTurno() {
        int sigTurno;
        sigTurno = (turno + 1) % numJugadores;
        if (jugadores.get(turno).getTurnosExtra() > 0) {
            sigTurno = turno;
            jugadores.get(turno).decrementaTurnosExtra();
        }
        return (sigTurno);
    }
    /**
     * devuelve el numero del siguiente turno
     * @return un numero que representa el <code>turno</code>
     */
    public int avanzaTurno() {
        turno = sigTurno();
        return turno;
    }
    /**
     * asigna un turno a la clase <code>Juego</code>
     * @param turno es el numero representativo del turno
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }
    /**
     * Devuelve el turno actual de Juego
     * @return el turno actual
     */
    public int getTurno() {
        return (turno);
    }
    
    /**
     * Devuelve el ultimo valor que ha salido en el dado
     * @see Jugador#getUltimoValorDado
     * @return el ultima valor del dado
     */
    public int ultimoValorDado() {
        return jugadores.get(turno).getUltimoValorDado();
    }

    /**
     * Devuelve la posicion en la que se encuentra la ficha perteneciente a turno
     * @see Jugador#getUltimaPosicionTablero
     * @return un numero que representa la posicion de la ultima ficha movida
     */
    public int ultimaPosicionTablero() {
        return jugadores.get(turno).getUltimaPosicionTablero();
    }
    
    /**
     * Llama al metodo <code>juegaTurno</code> de la clase Jugador
     * 
     * <p>El metrodo se encarga de lanzar un numero aleatorio con el metodo 
     * <code>dameNumero()</code> perteneciente a Dado
     * @see Jugador#juegaTurno
     * @see Dado
     */
    public void juega() {
        jugadores.get(turno).juegaTurno(tablero);
    }
    
    /**
     * Devuelve el estado actual de la partida
     * @return Devuelve <code>true</code> si un jugador ha alcanzado la ultima posicion y
     *<code>false</code> en caso contrario 
     */
    public Boolean esFin() {
        return jugadores.get(turno).esGanador();
    }
}

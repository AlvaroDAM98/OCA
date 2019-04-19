package org.vipsion.oca.controlador;

import org.vipsion.oca.modelo.Juego;
import org.vipsion.oca.vista.OcaGUI;

/**
 * Sirve para intermediar entre las peticiones provenientes
 * del GUI (vistas) y los objetos que implementan la lógica de la aplicación
 * (Modelo).
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author Ivan
 * @see Juego
 * @see GUI
 * @see <a href="https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador">MVC</a>
 */
public class Coordinador {

    private OcaGUI GUI;

    private Juego juego;

    /**
     * Asocia al objeto a cargo del GUI con este coordinador
     *
     * @param GUI Objeto a cargo del GUI (Vista)
     */
    public void setGUI(OcaGUI GUI) {
        this.GUI = GUI;
    }

    /**
     * Asocia al objeto a cargo de la lógica del juego con este coordinador
     *
     * @param juego Objeto a cargo de la lógica del juego (Modelo)
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    /**
     * Inicia la partida
     */
    public void inicia() {
        int turnoInicio = juego.getTurno();
        GUI.sigTurno(turnoInicio);
    }

    /**
     *Manda una orden al juego para jugar el turno
     */
    public void juega() {
        juego.juega();
        int posicionTablero = juego.ultimaPosicionTablero();
        int valorDado = juego.ultimoValorDado();
        int turno = juego.getTurno();
        GUI.setValorDado(turno, valorDado);
        GUI.setPosicionTablero(turno, posicionTablero);
        if (juego.esFin()) {
            GUI.setGanador(turno);
        } else {
            int sigTurno = juego.avanzaTurno();
            GUI.sigTurno(sigTurno);
        }
    }

}

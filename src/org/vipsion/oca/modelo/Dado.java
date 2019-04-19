package org.vipsion.oca.modelo;
/**
 * Se encarga de dar un numero al jugador para que mueva ficha
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author Alvaro Perez
 * @see Jugador
 */
public class Dado {
    /**
     * Genera un numero aleatorio entre 1 y 6
     * @return un numero aleatorio comprendido entre 1 y 6
     */
    static public int dameNumero() {
        return (int) (Math.random() * 6) + 1;
    }
}

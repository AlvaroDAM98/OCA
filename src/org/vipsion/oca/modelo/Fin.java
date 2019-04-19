package org.vipsion.oca.modelo;
/**
 * Controla el inicio y el final de la partida
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author Alvaro Perez
 * @see Casilla
 * @see Ficha
 */
public class Fin extends Casilla {

    /**
     * crea un objeto Fin con la posicion pasada por parametro
     * @param posicion Hace referencia a la Casilla en la que se encuentra
     */
    public Fin(int posicion) {
        super(posicion);
    }
    /**
     * Cambia el valor de <code>Ficha#setFin(Boolean)</code> a <code>true</code>
     * lo que finaliza la partidaç
     * 
     * @param ficha Objeto de tipo Ficha
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setFin(true);
    }
}

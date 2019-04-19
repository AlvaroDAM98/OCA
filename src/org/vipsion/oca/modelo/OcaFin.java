package org.vipsion.oca.modelo;
/**
 * Controla el final de la partida
 *
 * @author Alvaro Perez
 * @see Jugador
 * @see Ficha
 * @see Casilla
 */
public class OcaFin extends Casilla {

    private final int desplazamiento;
    
    /**
     * Inicializa OcaFin a los valores pasados por parametros haciendo uso de la
     * superclase y el atributo <code>desplazamiento</code>
     * @param posicion posicion actual de la ficha
     * @param desplazamiento cantidad salida del metodo {@link Dado#dameNumero()}
     */
    public OcaFin(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
    }

    /**
     * Mueve la ficha del jugador y controla el final del turno
     * @see Ficha
     * @param ficha Objeto de tipo Ficha
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setFin(true);
    }
}

package org.vipsion.oca.modelo;
/**
 * Mueve la ficha del jugador
 *
 * @author Alvaro Perez
 * @see Casilla
 * @see Ficha
 */
public class Oca extends Casilla {

    private final int desplazamiento;
    private final int turnosExtra;
    /**
     * Inicializa la clase a los valores pasados por parametro
     * Se le asigna un turno por defecto
     * 
     * @param posicion posicion actual de la ficha
     * @param desplazamiento cantidad salida del metodo {@link Dado#dameNumero()}
     */
    public Oca(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
        this.turnosExtra = 1;
    }
    /**
     * Metodo que mueve la ficha sumando los dos parametros dados a la hora de 
     * inicializar la clase
     * @see Ficha
     * @param ficha Objeto de tipo ficha
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setTurnosExtra(turnosExtra);
    }
}

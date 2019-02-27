package org.vipsion.oca.modelo;

public class Oca extends Casilla {

    private int desplazamiento;
    private int turnosExtra = 1;

    public Oca(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
    }

    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setTurnosExtra(turnosExtra);
        
        // TODO: 
    }

    // TODO: implementar posaFicha
}

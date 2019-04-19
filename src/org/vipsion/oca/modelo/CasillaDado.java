/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vipsion.oca.modelo;

public class CasillaDado extends Casilla{

    int desplazamiento;
    
    public CasillaDado(int posicion) {
        super(posicion);
    }
/**
 * Metodo que mueve la Ficha pasada como parametro un numero predefinido de posiciones
 * @param ficha indica la ficha que se esta utilizando en ese momento.
 */   
public void posaFicha(Ficha ficha){
    desplazamiento = Dado.dameNumero();
    ficha.setPosicion(posicion + desplazamiento);
}    
    
}

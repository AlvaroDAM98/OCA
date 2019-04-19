/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vipsion.oca.modelo;

public class CasillaDado extends Casilla{

    int desplazamiento;
    
    public CasillaDado(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
    }
   
public void posaFicha(Ficha ficha){
    ficha.setPosicion(posicion + desplazamiento);
}    
    
}

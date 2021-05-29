/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;

/**
 *
 * @author Esteban
 */
public class Sala implements Serializable{
    private int numSala;
    private String tipo;
    private int precio;

    public Sala(int numSala, String tipo, int precio) {
        this.numSala = numSala;
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public Sala() {
        this.numSala = 0;
        this.precio = 0;
        this.tipo = "";
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Sala{" + "numSala=" + numSala + ", tipo=" + tipo + ", precio=" + precio + '}';
    }
}

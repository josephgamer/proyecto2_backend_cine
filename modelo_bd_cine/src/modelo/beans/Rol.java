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
public class Rol implements Serializable{
    private int numRol;
    private String descripcion;

    public Rol(int numRol, String descripcion) {
        this.numRol = numRol;
        this.descripcion = descripcion;
    }

    public Rol() {
        this.descripcion = "";
        this.numRol = 0;
    }  

    public int getNumRol() {
        return numRol;
    }

    public void setNumRol(int numRol) {
        this.numRol = numRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" + "numRol=" + numRol + ", descripcion=" + descripcion + '}';
    }
}

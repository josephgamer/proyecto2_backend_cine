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
public class Tiquete implements Serializable{
    private int numTiquete;
    private Usuario usuario;
    private Proyeccion proyeccion;
    private int asiento;
    private int totalPagar;

    public Tiquete(int numTiquete, Usuario usuario, Proyeccion proyeccion, int asiento, int totalPagar) {
        this.numTiquete = numTiquete;
        this.usuario = usuario;
        this.proyeccion = proyeccion;
        this.asiento = asiento;
        this.totalPagar = totalPagar;
    }

    public Tiquete() {
        this.numTiquete = 0;
        this.usuario = new Usuario();
        this.proyeccion = new Proyeccion();
        this.asiento = 0;
        this.totalPagar = 0;
    }

    public int getNumTiquete() {
        return numTiquete;
    }

    public void setNumTiquete(int numTiquete) {
        this.numTiquete = numTiquete;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "numTiquete=" + numTiquete + ", usuario=" + usuario + ", proyeccion=" + proyeccion + ", asiento=" + asiento + ", totalPagar=" + totalPagar + '}';
    }
 
}

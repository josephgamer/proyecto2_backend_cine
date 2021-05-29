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
public class Proyeccion implements Serializable{
    private int numProyeccion;
    private Pelicula pelicula;
    private Horario horario;
    private Sala sala;

    public Proyeccion(int numProyeccion, Pelicula pelicula, Horario horario, Sala sala) {
        this.numProyeccion = numProyeccion;
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala = sala;
    }
    
    public Proyeccion() {
        this.horario = new Horario();
        this.numProyeccion = 0;
        this.pelicula = new Pelicula();
        this.sala = new Sala();
    }

    public int getNumProyeccion() {
        return numProyeccion;
    }

    public void setNumProyeccion(int numProyeccion) {
        this.numProyeccion = numProyeccion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "numProyeccion=" + numProyeccion + ", pelicula=" + pelicula + ", horario=" + horario + ", sala=" + sala + '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Esteban
 */
public class Pelicula implements Serializable{
    private int numpelicula;
    private String descripcion;
    private byte[] imagen;
    private ImageIcon foto = new ImageIcon();

    public Pelicula() {
        this.descripcion = "";
        this.imagen = new byte[1];
        this.numpelicula = 0;
    }

    public Pelicula(int numpelicula, String descripcion, byte[] imagen) {
        this.numpelicula = numpelicula;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getNumpelicula() {
        return numpelicula;
    }

    public void setNumpelicula(int numpelicula) {
        this.numpelicula = numpelicula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon foto) {
        this.foto = foto;
    }
    
}

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
public class Login implements Serializable{
    private Usuario usuario;
    private int clave;

    public Login(Usuario usuario, int clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public Login() {
        this.clave = 0;
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Login{" + "usuario=" + usuario + ", clave=" + clave + '}';
    }
}

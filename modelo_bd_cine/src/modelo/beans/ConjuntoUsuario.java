/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoUsuario implements Serializable {

    private UsuarioDAO user;

    public ConjuntoUsuario() {
        this.user = null;
        try {
            this.user = new UsuarioDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public Usuario obtenerRol(String id) {
        List<Usuario> existe = null;
        try {
            existe = user.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Usuario u : existe) {
            if (u.getIdUsuario().equals(id)) {
                return u;
            }
        }
        return null;
    }
    
    public void agregar(Usuario usuario) throws SQLException, IOException {
        user.add(usuario.getIdUsuario(), usuario);
    }

}

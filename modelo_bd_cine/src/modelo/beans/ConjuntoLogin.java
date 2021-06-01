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
import modelo.dao.LoginDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoLogin implements Serializable {

    private LoginDAO user;

    public ConjuntoLogin() {
        this.user = null;
        try {
            this.user = new LoginDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public boolean existeUsuario(String id, int clave) {
        List<Login> existe = null;
        try {
            existe = user.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Login u : existe) {
            if (u.getClave() == clave && u.getUsuario().getIdUsuario().equals(id)) {
                return true;
            }
        }
        return false;
    }
}

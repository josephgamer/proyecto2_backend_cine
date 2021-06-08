/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.SalaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoSala implements Serializable{
    SalaDAO sala;
    
    public ConjuntoSala() {
        this.sala = null;
        try {
            this.sala = new SalaDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void agregarSala(Sala value) {
        try {
            this.sala.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoSala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

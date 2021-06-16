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
import modelo.dao.ProyeccionDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoProyeccion implements Serializable{
    
    ProyeccionDAO proye;
    
    public ConjuntoProyeccion() {
        try {
            this.proye = new ProyeccionDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProyeccion(Proyeccion value) {
        try {
            this.proye.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

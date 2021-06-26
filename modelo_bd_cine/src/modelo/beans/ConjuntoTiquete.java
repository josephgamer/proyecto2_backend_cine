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
import modelo.dao.TiqueteDAO;

/**
 *
 * @author YENDRI
 */
public class ConjuntoTiquete implements Serializable {
    
    TiqueteDAO tiquete;
    
    public ConjuntoTiquete() {
        try {
            this.tiquete = new TiqueteDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarTiquete(Tiquete value) {
        try {
            this.tiquete.add(0, value);
        } catch (SQLException | IOException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

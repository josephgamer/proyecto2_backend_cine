/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelo.dao.PeliculaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoPelicula {
    
    private static final String PATRON_IMAGEN
            = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    private static final Pattern PATRON = Pattern.compile(PATRON_IMAGEN);
    PeliculaDAO pelicula;
    
    public ConjuntoPelicula() {
        try {
            this.pelicula = new PeliculaDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarPelicula(Pelicula value) {
        try {
            this.pelicula.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean validar(final String nombreArchivo) {
        Matcher matcher = PATRON.matcher(nombreArchivo);
        return matcher.matches();
    }
    
}

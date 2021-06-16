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
import javax.xml.bind.JAXBException;
import modelo.dao.SalaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    
    public String datosJSON() throws JAXBException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(allSalas());
    }
    
    public List<Sala> allSalas() {
        List<Sala> all = null;
        try {
            all = this.sala.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoSala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoSala.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    public String verSalas() {
        StringBuilder r = new StringBuilder();
        List<Sala> result = this.allSalas();
        for (Sala s : result) {
            r.append(String.format("\t\t\t<option size = '1' value = '%d'>\n", s.getNumSala()));
            r.append(String.format(s.getTipo()));
            r.append(String.format("\t\t\t</option>\n"));

        }
        return r.toString();
    }
}

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
import modelo.dao.HorarioDAO;
import java.util.logging.Logger;
import modelo.dao.MaxHorarioDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoHorario implements Serializable{
    
    HorarioDAO horario;
    MaxHorarioDAO mh;
    
    public ConjuntoHorario() {
        try {
            this.horario = new HorarioDAO();
            this.mh = new MaxHorarioDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addSchedule(Horario value) {
        try {
            this.horario.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoHorario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int returnLastHorario() throws IOException {
        try {
            return this.mh.listAll().get(0);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoHorario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}

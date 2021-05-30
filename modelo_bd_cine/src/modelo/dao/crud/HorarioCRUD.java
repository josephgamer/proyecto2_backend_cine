/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

/**
 *
 * @author Esteban
 */
public class HorarioCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        return LIST_ALL;
    }

    @Override
    public String getAddCmd() {
        return ADDSCHEDULE;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_SCHEDULE;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String ADDSCHEDULE = "insert into horario(dia,hora)"
            + " values(?, ?);";
    
    protected static final String LIST_ALL = "select num_horario,dia, hora "
            + "from horario;";
    
    protected static final String UPDATE_SCHEDULE = 
            "update horario set dia = ?, hora = ? where num_horario = ?;";
    
}

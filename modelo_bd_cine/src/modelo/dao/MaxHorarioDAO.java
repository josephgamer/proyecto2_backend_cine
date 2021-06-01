/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsMaxHorarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dao.crud.MaxHorarioCRUD;

/**
 *
 * @author Esteban
 */
public class MaxHorarioDAO extends AbsMaxHorarioDAO<Integer, Integer>{

    public MaxHorarioDAO() throws Exception {
        super(new MaxHorarioBD(), new MaxHorarioCRUD());
    }
    
    @Override
    public Integer getRecord(ResultSet rs) throws SQLException {
        return rs.getInt("max(num_horario)");
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Integer value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Integer value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsHorarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Horario;
import modelo.dao.crud.HorarioCRUD;

/**
 *
 * @author Esteban
 */
public class HorarioDAO extends AbsHorarioDAO<Integer, Horario>{
    
    public HorarioDAO() throws Exception {
        super(new HorarioBD(), new HorarioCRUD());
    }

    @Override
    public Horario getRecord(ResultSet rs) throws SQLException {
        Horario horario = new Horario();
        horario.setDia(rs.getDate("dia"));
        horario.setHora(rs.getInt("hora"));
        horario.setNumHorario(rs.getInt("num_horario"));
        return horario;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        stm.setDate(1, new java.sql.Date(value.getDia().getTime()));
        stm.setInt(2, value.getHora());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        stm.setDate(1, new java.sql.Date(value.getDia().getTime()));
        stm.setInt(2, value.getHora());
        stm.setInt(3, id);
    }
    
}

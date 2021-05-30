/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsSalaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Sala;
import modelo.dao.crud.SalaCRUD;

/**
 *
 * @author Esteban
 */
public class SalaDAO extends AbsSalaDAO<Integer, Sala>{
    
    public SalaDAO() throws Exception {
        super(new SalaBD(), new SalaCRUD());
    }

    @Override
    public Sala getRecord(ResultSet rs) throws SQLException {
        Sala sala = new Sala();
        sala.setNumSala(rs.getInt("num_sala"));
        sala.setTipo(rs.getString("tipo"));
        sala.setPrecio(rs.getInt("precio"));
        return sala;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Sala value) throws SQLException {
        stm.setString(1, value.getTipo());
        stm.setInt(2, value.getPrecio());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Sala value) throws SQLException {
        stm.setString(1, value.getTipo());
        stm.setInt(2, value.getPrecio());
        stm.setInt(3, id);
    }
    
}

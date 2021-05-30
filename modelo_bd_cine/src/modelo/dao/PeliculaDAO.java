/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsPeliculaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Pelicula;
import modelo.dao.crud.PeliculaCRUD;

/**
 *
 * @author Esteban
 */
public class PeliculaDAO extends AbsPeliculaDAO<Integer, Pelicula>{
    
    public PeliculaDAO() throws Exception {
        super(new PeliculaBD(), new PeliculaCRUD());
    }

    @Override
    public Pelicula getRecord(ResultSet rs) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setDescripcion(rs.getString("nombre"));
        pelicula.setNumpelicula(rs.getInt("num_pelicula"));
        pelicula.setImagen(rs.getBytes("foto"));
        return pelicula;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Pelicula value) throws SQLException {
        stm.setBytes(1, value.getImagen());
        stm.setString(2, value.getDescripcion());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Pelicula value) throws SQLException {
        stm.setBytes(1, value.getImagen());
        stm.setString(2, value.getDescripcion());
        stm.setInt(3, id);
    }
}

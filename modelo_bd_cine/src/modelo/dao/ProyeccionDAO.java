/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsProyeccionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Horario;
import modelo.beans.Pelicula;
import modelo.beans.Proyeccion;
import modelo.beans.Sala;
import modelo.dao.crud.ProyeccionCRUD;

/**
 *
 * @author Esteban
 */
public class ProyeccionDAO extends AbsProyeccionDAO<Integer, Proyeccion>{
    
    public ProyeccionDAO() throws Exception {
        super(new ProyeccionBD(), new ProyeccionCRUD());
    }


    @Override
    public Proyeccion getRecord(ResultSet rs) throws SQLException {
        Proyeccion proyeccion = new Proyeccion();
        Pelicula pelicula = new Pelicula();
        Horario horario = new Horario();
        Sala sala = new Sala();
        pelicula.setDescripcion(rs.getString("nombre"));
        pelicula.setEntrada(rs.getBinaryStream("foto"));
        pelicula.setNumpelicula(rs.getInt("pelicula_num"));
        horario.setDia(rs.getDate("dia"));
        horario.setHora(rs.getInt("hora"));
        horario.setNumHorario(rs.getInt("horario_num"));
        sala.setNumSala(rs.getInt("sala_num_sala"));
        sala.setPrecio(rs.getInt("precio"));
        sala.setTipo(rs.getString("tipo"));
        proyeccion.setNumProyeccion(rs.getInt("num_proyeccion"));
        proyeccion.setPelicula(pelicula);
        proyeccion.setHorario(horario);
        proyeccion.setSala(sala);
        
        return proyeccion;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Proyeccion value) throws SQLException {
        stm.setInt(1, value.getPelicula().getNumpelicula());
        stm.setInt(2, value.getHorario().getNumHorario());
        stm.setInt(3, value.getSala().getNumSala());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Proyeccion value) throws SQLException {
        stm.setInt(1, value.getPelicula().getNumpelicula());
        stm.setInt(2, value.getHorario().getNumHorario());
        stm.setInt(3, value.getSala().getNumSala());
        stm.setInt(4, id);
    }
    
}

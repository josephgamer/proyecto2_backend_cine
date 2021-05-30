/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsTiqueteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Horario;
import modelo.beans.Pelicula;
import modelo.beans.Proyeccion;
import modelo.beans.Sala;
import modelo.beans.Tiquete;
import modelo.beans.Usuario;
import modelo.dao.crud.TiqueteCRUD;

/**
 *
 * @author Esteban
 */
public class TiqueteDAO extends AbsTiqueteDAO<Integer, Tiquete>{
    
    public TiqueteDAO() throws Exception {
        super(new TiqueteBD(), new TiqueteCRUD());
    }

    @Override
    public Tiquete getRecord(ResultSet rs) throws SQLException {
        Tiquete tiquete = new Tiquete();
        Usuario user = new Usuario();
        Pelicula peli = new Pelicula();
        Horario horario = new Horario();
        Sala sala = new Sala();
        Proyeccion proyeccion = new Proyeccion();
        user.setIdUsuario(rs.getString("usuario_id"));
        peli.setDescripcion(rs.getString("nombre"));
        horario.setDia(rs.getDate("dia"));
        horario.setHora(rs.getInt("hora"));
        sala.setPrecio(rs.getInt("precio"));
        sala.setTipo(rs.getString("tipo"));
        proyeccion.setHorario(horario);
        proyeccion.setPelicula(peli);
        proyeccion.setSala(sala);
        tiquete.setNumTiquete(rs.getInt("num_tiquete"));
        tiquete.setAsiento(rs.getInt("asiento"));
        tiquete.setTotalPagar(rs.getInt("totalPagar"));
        tiquete.setUsuario(user);
        tiquete.setProyeccion(proyeccion);
        return tiquete;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Tiquete value) throws SQLException {
        stm.setString(1, value.getUsuario().getIdUsuario());
        stm.setInt(2, value.getProyeccion().getNumProyeccion());
        stm.setInt(3, value.getAsiento());
        stm.setInt(4, value.getTotalPagar());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Tiquete value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

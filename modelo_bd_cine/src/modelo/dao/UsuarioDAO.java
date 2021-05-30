/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsUsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Rol;
import modelo.beans.Usuario;
import modelo.dao.crud.UsuarioCRUD;

/**
 *
 * @author Esteban
 */
public class UsuarioDAO extends AbsUsuarioDAO<String, Usuario>{
    
    public UsuarioDAO() throws Exception {
        super(new UsuarioBD(), new UsuarioCRUD());
    }

    @Override
    public Usuario getRecord(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        Rol rol = new Rol();
        rol.setNumRol(rs.getInt("rol_id"));
        user .setIdUsuario(rs.getString("id_usuario"));
        user.setNombre(rs.getString("nombre"));
        user.setApellido(rs.getString("apellido"));
        user.setRol(rol);
        return user;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Usuario value) throws SQLException {
        stm.setString(1, id);
        stm.setInt(2, value.getRol().getNumRol());
        stm.setString(3, value.getNombre());
        stm.setString(4, value.getApellido());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Usuario value) throws SQLException {
        stm.setInt(1, value.getRol().getNumRol());
        stm.setString(2, value.getNombre());
        stm.setString(3, value.getApellido());
        stm.setString(4, id);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsLoginDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Login;
import modelo.beans.Usuario;
import modelo.dao.crud.LoginCRUD;

/**
 *
 * @author Esteban
 */
public class LoginDAO extends AbsLoginDAO<Integer, Login> {

    public LoginDAO() throws Exception {
        super(new LoginBD(), new LoginCRUD());
    }
    
    @Override
    public Login getRecord(ResultSet rs) throws SQLException {
        Login login = new Login();
        Usuario user = new Usuario();
        user.setIdUsuario(rs.getString("usuario_id"));
        login.setClave(rs.getInt("clave"));
        login.setUsuario(user);
        return login;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Login value) throws SQLException {
        stm.setInt(1, value.getClave());
        stm.setString(2, value.getUsuario().getIdUsuario());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Login value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

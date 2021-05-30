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
public class UsuarioCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        return LIST_ALL;
    }

    @Override
    public String getAddCmd() {
        return ADD_USUARIO;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_USUARIO;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String ADD_USUARIO = "insert into usuario(id_usuario,rol_id,nombre,apellido)"
            + " values(?, ?, ?, ?);";
    
    protected static final String LIST_ALL = "select id_usuario,rol_id, nombre,apellido "
            + "from usuario;";
    
    protected static final String UPDATE_USUARIO = 
            "update usuario set nombre = ?, apellido = ? where id_usuario = ?;";
    
}

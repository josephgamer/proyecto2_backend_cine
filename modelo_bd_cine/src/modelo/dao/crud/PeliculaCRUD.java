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
public class PeliculaCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        return LIST_ALL;
    }

    @Override
    public String getAddCmd() {
        return ADD_PELICULA;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_PELICULA;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String ADD_PELICULA = "insert into pelicula(foto,nombre)"
            + " values(?, ?);";
    
    protected static final String LIST_ALL = "select num_pelicula,foto, nombre "
            + "from pelicula;";
    
    protected static final String UPDATE_PELICULA = 
            "update pelicula set foto = ?, nombre = ? where num_pelicula = ?;";
    
}

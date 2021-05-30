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
public class ProyeccionCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        return LIST_ALL;
    }

    @Override
    public String getAddCmd() {
        return ADD_PROYECCION;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_PROYECCION;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String ADD_PROYECCION = "insert into proyeccion(pelicula_num,horario_num,sala_num_sala)"
            + " values(?, ?, ?);";
    
    protected static final String LIST_ALL = "select num_proyeccion,pelicula_num, horario_num, sala_num_sala "
            + "from proyeccion;";
    
    protected static final String UPDATE_PROYECCION = 
            "update proyeccion set pelicula_num = ?, horario_num = ?, sala_num_sala = ? where num_proyeccion = ?;";
    
}

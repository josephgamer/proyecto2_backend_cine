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
public class TiqueteCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_ALL;
    }

    @Override
    public String getAddCmd() {
        return ADD_TIQUETE;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static final String ADD_TIQUETE = "insert into tiquete(usuario_id,proyeccion_num,asiento,totalPagar)"
            + " values(?, ?, ?, ?);";

    protected static final String LIST_ALL 
            = "select ti.id_tiquete, ti.usuario_id, ti.asiento,ti.totalPagar,pel.nombre, h.dia,h.hora,\n"
            + "sa.precio, sa.tipo from tiquete ti inner join proyeccion pr on \n"
            + "ti.proyeccion_num = pr.num_proyeccion inner join pelicula pel on \n"
            + "pr.pelicula_num = pel.num_pelicula inner join horario h on pr.horario_num = h.num_horario \n"
            + "inner join sala sa on pr.sala_num_sala = sa.num_sala;";

    /*protected static final String UPDATE_SCHEDULE
            = "update horario set dia = ?, hora = ? where num_horario = ?;";*/

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.db.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.IOUtilities;

/**
 *
 * @author Esteban
 */
public abstract class AbsPeliculaDAO<K, V> implements DAO <K, V> {
    private final Database db;
    private final AbstractCRUD crud;

    public AbsPeliculaDAO(Database db, AbstractCRUD crud) {
        this.db = db;
        this.crud = crud;
    }

    @Override
    public List<V> listAll() throws SQLException, IOException {
       List<V> r = new ArrayList<>();
        try (Connection cnx = db.getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getListAllCmd())) {
            while (rs.next()) {
                r.add(getRecord(rs));
            }
        }
        return r;
    }

    @Override
    public void add(K id, V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public V retrieve(K id) throws SQLException, IOException {
        V r = null;
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getRetrieveCmd())) {
            stm.clearParameters();
            setIdParameter(stm, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = getRecord(rs);
                    /*try (OutputStream out = response.getOutputStream()) {
                        response.setContentType(r.getTipo());
                        IOUtilities.copy(rs.getBinaryStream(4), out);
                    } catch (IOException ex) {
                        System.err.printf("Excepción: '%s'%n", ex.getMessage());
                        throw ex;
                    }*/
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return r;
    }

    @Override
    public void update(K id, V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            setUpdateParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void delete(K id) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract V getRecord(ResultSet rs) throws SQLException;

    public abstract void setAddParameters(PreparedStatement stm, K id, V value)
            throws SQLException;

    public abstract void setUpdateParameters(PreparedStatement stm, K id, V value)
            throws SQLException;
    
    public abstract void setIdParameter(PreparedStatement stm, K id) throws SQLException;
    
    public AbstractCRUD getCRUD() {
        return crud;
    }
}

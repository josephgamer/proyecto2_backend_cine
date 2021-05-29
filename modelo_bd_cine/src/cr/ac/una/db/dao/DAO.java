/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.db.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Esteban
 */
public interface DAO<K, V> {
    public List<V> listAll() throws SQLException, IOException;

    // CRUD         (IMEC)
    // C(reate)     I(nsertar)
    // R(etrieve)   C(onsultar)
    // U(pdate)     M(odificar)
    // D(elete)     E(liminar)
    //
    public void add(K id, V value) throws SQLException, IOException;

    public V retrieve(K id) throws SQLException, IOException;

    public void update(K id, V value) throws SQLException, IOException;

    public void delete(K id) throws SQLException, IOException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Esteban
 */
public class PeliculaBD extends Database{
    public PeliculaBD() throws IOException {
        System.out.println(this);
        InputStream in = getClass().getResourceAsStream("/modelo/dao/cine.properties");
        loadConfiguration(in);
    }
}

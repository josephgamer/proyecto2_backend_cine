/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_bd_cine;

import cr.ac.una.db.Database;
import modelo.beans.ConjuntoPelicula;
import modelo.dao.MaxHorarioBD;

/**
 *
 * @author Esteban
 */
public class Modelo_bd_cine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Database db = new MaxHorarioBD() {
            };
            System.out.println(db);

            //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //ProfesorDAO bd = new ProfesorDAO();
            //MatriculaDAO bd = new MatriculaDAO();
            //Matricula value = new Matricula();
            //Estudiante e = new Estudiante();
            //e.setId_estudiante(122223333);
            //value.setEstudiante_id(e);
            //System.out.println(bd.listAll().size());
            //mostrarListaCursos(bd);
            /*EspecialidadDAO bd = new EspecialidadDAO();
            ConjuntoEspecialidad ce = new ConjuntoEspecialidad();
            Profesor p = new Profesor();
            p.setId_profesor(4567);*/
            ConjuntoPelicula bd = new ConjuntoPelicula();
            System.out.println(ConjuntoPelicula.getTablaGaleria(bd, 2));
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.ProyeccionDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoProyeccion implements Serializable{
    
    ProyeccionDAO proye;
    
    public ConjuntoProyeccion() {
        try {
            this.proye = new ProyeccionDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProyeccion(Proyeccion value) {
        try {
            this.proye.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Pelicula returnPelicula(int id) {
        List<Proyeccion> result = cartelera();
        for (Proyeccion p : result) {
            if (p.getPelicula().getNumpelicula() == id) {
                return p.getPelicula();
            }
        }
        return new Pelicula();
    }
    
    public String getTablaProyeccion(int imgsPorFila) throws SQLException, IOException {
        System.out.printf("Construyendo tabla con %d imágenes por fila..%n", imgsPorFila);

        StringBuilder r = new StringBuilder();
        r.append("<table class=\"cartelera\">");
        r.append("<thead></thead>");
        r.append("<tbody>");

        r.append("<tr>");
        int k = 0;
        List<Proyeccion> items = cartelera();
        Iterator<Proyeccion> i = items.iterator();
        while (i.hasNext()) {
            Proyeccion item = i.next();
            System.out.printf("Cargando imagen: %d %n", item.getPelicula().getNumpelicula());
            r.append("<td class=\"thumb\">");
            
            // Observe que el método NO carga las imágenes directamente.
            // En lugar de eso, el método genera el código HTML necesario para que el browser
            // solicite el archivo correspondiente a través del Servlet, que envía los
            // datos en el formato correcto.
            r.append(String.format(
                    "<p><img src=\"VerProyeccion?numPelicula=%d\" /></p> ",
                    item.getPelicula().getNumpelicula()));
            r.append(String.format("<p>Nombre: %s</p>", item.getPelicula().getDescripcion()));
            r.append(String.format("<p>Hora: %d</p>",item.getHorario().getHora()));
            r.append(String.format("<p>Día: %s</p>", item.getHorario().getDia()));
            r.append(String.format("<p>Precio: %d</p>", item.getSala().getPrecio()));
            r.append(String.format("<p>Tipo Sala: %s</p>", item.getSala().getTipo()));
            r.append(String.format("<p><button class = '%s' type='%s' onclick='%s' >%s</button></p>",
                    "btn","button","mostrar(4);","Butacas"));
            r.append(String.format("<p><button class = '%s' type='%s' value = '%d' name = '%s'>%s</button></p>"
                    , "btn","submit", item.getNumProyeccion(), "proyeccion","Comprar"));
            
            r.append("</td>");
            k++;
            if (((k % imgsPorFila) == 0) && i.hasNext()) {
                r.append("</tr>\n<tr>");
            }
        }

        r.append("</tr>");
        r.append("</tbody>");
        r.append("</table>");
        return r.toString();
    }

    public static String getTablaProyeccion(ConjuntoProyeccion galeria, int imgsPorFila) throws SQLException, IOException {
        return galeria.getTablaProyeccion(imgsPorFila);
    }
    
    public List<Proyeccion> cartelera() {
        try {
            return this.proye.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoProyeccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

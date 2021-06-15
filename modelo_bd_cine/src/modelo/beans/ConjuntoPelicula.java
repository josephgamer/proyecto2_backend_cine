/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.xml.bind.JAXBException;
import modelo.dao.PeliculaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoPelicula implements Serializable{
    
    private static final String PATRON_IMAGEN
            = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
    private static final Pattern PATRON = Pattern.compile(PATRON_IMAGEN);
    PeliculaDAO pelicula;
    
    public ConjuntoPelicula() {
        try {
            this.pelicula = new PeliculaDAO();
        } catch (Exception ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarPelicula(Pelicula value) {
        try {
            this.pelicula.add(0, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pelicula> listarPelis() {
        List<Pelicula> result = null;
        List<Pelicula> pelis = new ArrayList<>();
        try {
            result = pelicula.listAll();
            for (Pelicula peli : result) {
                byte[] bi = peli.getImagen();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
                    peli.setFoto(imgi);
                    pelis.add(peli);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pelis;
    }
    
    public String datosJSON() throws JAXBException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(listarPelis());
    }
    
    public Pelicula retrievePelicula(int id) {
        Pelicula r = null;
        try {
            r = this.pelicula.retrieve(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public String getTablaGaleria(int imgsPorFila) throws SQLException, IOException {
        System.out.printf("Construyendo tabla con %d imágenes por fila..%n", imgsPorFila);

        StringBuilder r = new StringBuilder();
        r.append("<table class=\"gallery\">");
        r.append("<thead></thead>");
        r.append("<tbody>");

        r.append("<tr>");
        int k = 0;
        List<Pelicula> items = this.pelicula.listAll();
        Iterator<Pelicula> i = items.iterator();
        while (i.hasNext()) {
            Pelicula item = i.next();
            System.out.printf("Cargando imagen: %d (%s)%n", item.getNumpelicula());
            r.append("<td class=\"thumb\">");
            
            // Observe que el método NO carga las imágenes directamente.
            // En lugar de eso, el método genera el código HTML necesario para que el browser
            // solicite el archivo correspondiente a través del Servlet, que envía los
            // datos en el formato correcto.
            r.append(String.format(
                    "<p><img alt=\"%s\" src=\"VerPelis?numPelicula=%d\" /></p> ",
                    item.getNumpelicula()));
            
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

    public static String getTablaGaleria(ConjuntoPelicula galeria, int imgsPorFila) throws SQLException, IOException {
        return galeria.getTablaGaleria(imgsPorFila);
    }
    
    public static boolean validar(final String nombreArchivo) {
        Matcher matcher = PATRON.matcher(nombreArchivo);
        return matcher.matches();
    }
    
}

package MateriaCRUD;

import DAO.MateriaDAO;
import DTO.Materia;
import Utilerias.Conexion;
import controller.servlets.ExamenCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarMateria extends HttpServlet {
    Conexion conn = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MateriaDAO dao = new MateriaDAO();
        List listaDatos = null;
        try {
            listaDatos = dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {        
               out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Mostrar Preguntas</title>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <!-- Bootstrap -->"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"logo\">  "
                    + "</div>"
                    + "    "
                    + "<div class=\"panel-heading text-center\"> <h1>Materias Registradas</h1> </div>"
                    + ""
                    + ""
                    + "<div class=\"table-responsive\">"
                    + "<table  class=\"table table-hover table-striped  table-bordered table-condensed\">"
                    + "<tr class=\"active\"> "
                       +"<th>Id</th>"
                    + "<th>Nombre </th>"
                    + "<th>Numero de creditos</th>"           
                    + "<th>Accion</th>"
                    + "</tr>");
            if (listaDatos != null) {
                for (Object object : listaDatos) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Materia) object).getIdmateria()+ ">");
//                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"LoadALL\" >");
                    out.print("<tr class=\"active\" >"
                            + "<td><div >" + ((Materia) object).getIdmateria()+ "</div></td>"
                            + "<td><div >" + ((Materia) object).getNombre()+ "</div></td>"
                            + "<td><div >" + ((Materia) object).getCreditos()+ "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"MateriaModificarVista\" formmethod=\"post\">" 
                            +"<input type=\"submit\" value=\"eliminar\" formaction=\"MateriaEliminar\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
            }
            
           
            out.println("</table>"
                    +"</div>"
                    + "<br>"
                    + "<p align=\"center\">"
                    + "<a   href=\"MateriaAgregarVista\">" + "<img src=\"./Imagenes/agregar.png\" class=\"chico\"> " + "</a>"
                    + "</body>"
                    + "</p>"
                    + "</html>");
            
        } finally {
            out.close();
        }
    }
	
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumnoCRUD;

import DAO.AlumnoDAO;
import DTO.Alumno;
import Utilerias.Conexion;
import controller.CRUD.AlumnoCRUD;
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

/**
 *
 * @author Pwned
 */
public class AlumnoMostrar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion conn = new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String retorno = request.getParameter("retorno");

        AlumnoDAO dao = new AlumnoDAO();
        List listItems = null;
        try {
            listItems = dao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>alumnos Registrados</title>"
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
                    + "<div class=\"panel-heading text-center\"> <h1>Alumnos Registrados</h1> </div>"
                    + ""
                    + ""
                    + "<div class=\"table-responsive\">"
                    + "<table  class=\"table table-hover table-striped  table-bordered table-condensed\">"
                    + "<tr class=\"active\"> "
                 + "<th>Matricula</th>"
                    + "<th>Nombre</th>"
                    + "<th>Paterno</th>"
                    + "<th>Materno</th>"
                    + "<th>Fecha</th>"
                    + "<th>Calle</th>"
                    + "<th>Colonia</th>"
                    + "<th>Numero</th>"
                    + "<th>C.P.</th>"
                    + "<th>Sexo</th>"
                    + "<th>E-mail</th>"
                    + "<th>idCarrera</th>"
                    + "<th>Accion</th>"
                    + "</tr>");
                 if (listItems != null) {
                for (Object object : listItems) {
                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Alumno) object).getMatriculaa() + ">");
                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");

                    out.print("<tr class=\"active\" >"
                            + "<td><div >" + ((Alumno) object).getMatriculaa() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getNombre() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getPaterno() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getMaterno() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getFechan() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getCalle() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getColonia() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getNum() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getCp() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getSexo() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getEmail() + "</div></td>"
                            + "<td><div >" + ((Alumno) object).getIdcarrera() + "</div></td>"
                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"AlumnoModficarVista\" formmethod=\"post\">"
                            +"<input type=\"submit\" value=\"eliminar\" formaction=\"AlumnoEliminar\" formmethod=\"post\">" + "</td>"
                            + "</tr>");
                    out.print("</form>");
                }
                 }
          
           
            out.println("</table>"
                    +"</div>"
                    + "<br>"
                    + "<p align=\"center\">"
                    + "<a   href=\"AlumnoAgregarVista\">" + "<img src=\"./Imagenes/agregar.png\" class=\"chico\"> " + "</a>"
                    + "</body>"
                    + "</p>"
                    + "</html>");
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Alumno</title>");
//            
//            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
//            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
//            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Alumnos registrados:</h1>");
//            out.println("<table style=\"border: navy dashed\">"
//                    + "<thead>"
//                    + "<tr>"
//                    + "<th>Matricula</th>"
//                    + "<th>Nombre</th>"
//                    + "<th>Paterno</th>"
//                    + "<th>Materno</th>"
//                    + "<th>Fecha</th>"
//                    + "<th>Calle</th>"
//                    + "<th>Colonia</th>"
//                    + "<th>Numero</th>"
//                    + "<th>C.P.</th>"
//                    + "<th>Sexo</th>"
//                    + "<th>E-mail</th>"
//                    + "<th>idCarrera</th>"
//                    + "</tr>"
//                    + "</thead>"
//                    + "<tbody>");
//            if (retorno != null) {
//                out.print(retorno);
//            }
//            if (listItems != null) {
//                for (Object object : listItems) {
//                    out.println("<form ><input type=\"hidden\" name=\"idItem\"  value=" + ((Alumno) object).getMatriculaa() + ">");
//                    out.println("<input type=\"hidden\" name=\"accion\"  value=\"read\" >");
//
//                    out.print("<tr>"
//                            + "<td><div >" + ((Alumno) object).getMatriculaa() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getNombre() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getPaterno() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getMaterno() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getFechan() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getCalle() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getColonia() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getNum() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getCp() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getSexo() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getEmail() + "</div></td>"
//                            + "<td><div >" + ((Alumno) object).getIdcarrera() + "</div></td>"
//                            + "<td>" + "<input type=\"submit\" value=\"editar\" formaction=\"AlumnoModificarVista\" formmethod=\"post\">" + "</td>"
//                            + "<td>" + "<input type=\"submit\" value=\"eliminar\" formaction=\"AlumnoEiminar\" formmethod=\"post\">" + "</td>"
//                            + "</tr>");
//                    out.print("</form>");
//                }
//                 }
//
//            out.println("</tbody>"
//                    + "</table>");
//            out.println("<br><form  >");
//            out.println("<input type=\"hidden\" name=\"accion\"  value=\"createR\" >");
//            out.println("<input type=\"submit\" value=\"Nuevo\" formaction=\"AlumnoAgregarVista\" formmethod=\"post\">");
//            out.print("</form>");
//            //out.println("<a href=\"login.html\"><input type=\"submit\" value=\"return\"></a> ");
//            out.println("</body>");
//            out.println("</html>");
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

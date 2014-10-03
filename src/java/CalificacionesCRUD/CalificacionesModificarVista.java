/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalificacionesCRUD;

import DAO.CalificacionesDAO;
import DTO.Calificaciones;
import Utilerias.CargaSelect;
import Utilerias.Conexion;
import controller.CRUD.CalificacionesCRUD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class CalificacionesModificarVista extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */Conexion conn = new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String key=request.getParameter("idItem");
        Calificaciones dto = new Calificaciones(), dto2 = null;
        dto.setIdcalificaciones(Integer.parseInt(key));

        CalificacionesDAO dao = new CalificacionesDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CalificacionesCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("CalificacionesCRUD");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "	<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "    <title> Inicio de Sesión </title>\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    <!-- Bootstrap -->\n"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">\n"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">\n"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>\n"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>    \n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<div class=\"logo\">  \n"
                    + "</div>\n"
                    + "    \n"
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"CalificacionesModificar\" method=\"post\">     \n"
                    +"<input type=\"hidden\" value=" + dto2.getIdcalificaciones() + " name=\"idItem\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "    <h2>Registro de Usuario</h2>\n"
                    + "\n"
                    + "    <div class=\"line\" text-center></div>\n"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Id: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" disabled name=\"puntuaje\" id=\"matricula\" value=\""+dto2.getIdcalificaciones()+"\">  "
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Puntuaje: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"puntuaje\" id=\"matricula\" value=\""+dto2.getPuntaje()+"\">                    \n"
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Matricula Alumno: </LABEL>            \n"
                    +CargaSelect.conAlumno((int)dto2.getMatriculaa())//+ "            <INPUT style=\"text-align:center\" type=\"text\" name=\"matriculaa\" id=\"nombre\">                    \n"
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >MatriculaProfesor: </LABEL>\n"
                    +CargaSelect.conProfesor((int) dto2.getMatriculap())//+ "             <INPUT  style=\"text-align:center\"  type=\"text\" name=\"matriculap\" id=\"paterno\"> \n"
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">id Examen: </LABEL>\n"
                    +CargaSelect.conExamen(dto2.getIdexamen())//+ "                <INPUT  style=\"text-align:center\" type=\"text\" name=\"idexamen\" id=\"materno\">  \n"
                    + "\n"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>    \n"
                    + "</form>\n"
                    + "    <a href=\"login.html\">	\n"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\"></a>\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "");
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

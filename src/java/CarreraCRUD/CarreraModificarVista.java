/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CarreraCRUD;

import DAO.CarreraDAO;
import DTO.Carrera;
import Utilerias.Conexion;
import controller.CRUD.CarreraCRUD;
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
public class CarreraModificarVista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("idItem");
        Carrera dto = new Carrera(), dto2 = null;
        dto.setIdcarrera(Integer.parseInt(key));

        CarreraDAO dao = new CarreraDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarreraCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("CarreraMostrar");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>\n"
                    + "	<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "    <title> Registro Carrera</title>\n"
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
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"CarreraModificar\" method=\"post\">     \n"
                    + "    <input type=\"hidden\" value=\"" + dto2.getIdcarrera() + "\"   name=\"idItem\" >\n"
                    + "                           <input type=\"hidden\" value=\"update\" name=\"accion\" >\n"
                    + "    <h2>Registro de Carrera</h2>\n"
                    + "\n"
                    + "    <div class=\"line\" text-center></div>\n"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">ID: </LABEL> \n"
                    + "            <INPUT style=\"text-align:center\" disable type=\"text\" name=\"id\" value=\""+ dto2.getIdcarrera() + "\"id=\"id\"> "
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Nombre: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"nombre\" value=" + dto2.getNombre()+ " id=\"matricula\">                    \n"
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Duración: </LABEL>  \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"duracion\" id=\"matricula\" value=" + dto2.getDuracion()+ ">                    \n"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>    \n"
                    + "</form>\n"
                    + "    <a href=\"login.html\">	\n"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\"></a>\n"
                    + "</body>\n"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

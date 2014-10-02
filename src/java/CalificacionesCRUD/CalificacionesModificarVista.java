/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CalificacionesCRUD;

import DAO.CalificacionesDAO;
import DTO.Calificaciones;
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalificacionesUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CalificacionesCRUD\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getIdcalificaciones() + " name=\"idCalificaciones\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>puntuaje: </td>\n"
                    + "        				<td><input type=\"text\" name=\"puntuaje\" value=" + dto2.getPuntaje() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>matriculaa</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"matriculaa\" value=" + dto2.getMatriculaa() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>matriculap:</td>\n"
                    + "        				<td><input type=\"text\" name=\"matriculap\" value=" + dto2.getMatriculap() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>idExamen:</td>\n"
                    + "        				<td><input type=\"text\" name=\"idexamen\" value=" + dto2.getIdexamen() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td colspan=\"2\" align=\"Center\"><input type=\"submit\" value=\"Update\"></td>\n"
                    + "        			</tr>\n"
                    + "        		</tbody>\n"
                    + "        	</table>\n"
                    + "        	</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
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

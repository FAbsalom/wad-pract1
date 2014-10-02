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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Conexion conn=new Conexion();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String key =request.getParameter("idItem");
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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CarreraUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n" 
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"CarreraModificar\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getIdcarrera() + " name=\"idCarrera\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>id: </td>\n"
                    + "        				<td><input disable type=\"text\" name=\"id\" value=" + dto2.getIdcarrera() + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>nombre</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=" + dto2.getNombre()+ "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td>duracion:</td>\n"
                    + "        				<td><input type=\"text\" name=\"duracion\" value=" + dto2.getDuracion()+ "></td>\n"
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

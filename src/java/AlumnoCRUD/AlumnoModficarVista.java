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
public class AlumnoModficarVista extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("idItem");
        Alumno dto = new Alumno(), dto2 = null;
        dto.setMatriculaa(Integer.parseInt(key));

        AlumnoDAO dao = new AlumnoDAO();
        try {
            dto2 = dao.load(dto, conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (dto2 == null) {
            response.sendRedirect("AlumnoMostrar");
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
     
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AlumnoUpdate</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylesheet.css\"/>");
            out.println("<script type=\"text/javascript\" src=\"js/jquery-1.11.1.js\"></script>");
            out.println("<script type=\"text/javascript\" src=\"js/anim.js\"></script>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"AlumnoModificar\" method=\"POST\">\n<input type=\"hidden\" value=" + dto2.getMatriculaa() + " name=\"idAlumno\" >"
                    + "          <input type=\"hidden\" value=\"update\" name=\"accion\" >" + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th  align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td><input disable type=\"text\" name=\"matricula\" value=\"" + dto2.getMatriculaa() + "\" placeholder=\"Matricula\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=\"" + dto2.getNombre() + "\" placeholder=\"Nombre\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"paterno\" value=\"" + dto2.getPaterno() + "\" placeholder=\"Paterno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"materno\" value=\"" + dto2.getMaterno() + "\" placeholder=\"Materno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"fecha\" value=\"" + dto2.getFechan().toString() + "\" placeholder=\"Fecha\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"calle\" value=\"" + dto2.getCalle() + "\" placeholder=\"Calle\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"colonia\" value=\"" + dto2.getColonia() + "\" placeholder=\"Colonia\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"numero\" value=\"" + dto2.getNum() + "\" placeholder=\"Numero\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"cp\" value=\"" + dto2.getCp() + "\" placeholder=\"C.P.\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"sexo\" value=\"" + dto.getSexo() + "\" placeholder=\"Sexo\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"email\" value=\"" + dto2.getEmail() + "\" placeholder=\"E-mail\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"hidden\" name= \"clave\" value=\"-\" placeholder=\"clave\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"idcarrera\" value=\"" + dto2.getIdcarrera() + "\" placeholder=\"Carrera\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td align=\"Center\"><input type=\"submit\" value=\"Actualizar\"></td>\n"
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

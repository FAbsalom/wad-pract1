/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlumnoCRUD;

import Utilerias.CargaSelect;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pwned
 */
public class AlumnoAgregarVista extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>AlumnoUpdate</title>");
            out.println("</head>");
            out.println("<body style=\"background-color: red\">\n"
                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
                    + "        <div align=\"Center\">\n"
                    + "        	<form action=\"AlumnoAgregar\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idAlumno\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th  align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"matricula\" value=\"\" placeholder=\"Matricula\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"nombre\" value=\"\" placeholder=\"Nombre\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"paterno\" value=\"\" placeholder=\"Paterno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"materno\" value=\"\" placeholder=\"Materno\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"fecha\" value=\"\" placeholder=\"Fecha\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"calle\" value=\"\" placeholder=\"Calle\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"colonia\" value=\"\" placeholder=\"Colonia\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"numero\" value=\"\" placeholder=\"Numero\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"cp\" value=\"\" placeholder=\"C.P.\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"text\" name= \"sexo\" value=\"\" placeholder=\"Sexo\" " + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td><input type=\"text\" name=\"email\" value=\"\" placeholder=\"E-mail\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td> <input type=\"hidden\" name= \"clave\" value=\"-\" placeholder=\"clave\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    //+ "        				<td><input type=\"text\" name=\"idcarrera\" value=\"\" placeholder=\"Carrera\"" + "></td>\n"
                    + CargaSelect.conCarrera()
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td align=\"Center\"><input type=\"submit\" value=\"Guardar\"></td>\n"
                    + "        			</tr>\n"
                    + "        		</tbody>\n"
                    + "        	</table>\n"
                    + "        	</form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");
        }finally {
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

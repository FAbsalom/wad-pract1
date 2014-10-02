/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CarreraCRUD;

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
public class CarreraAgregarVista extends HttpServlet {

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
            throws ServletException, IOException{
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
                    + "        	<form action=\"CarreraAgregar\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idCarrera\" >"
                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
                    + "        	<table>\n"
                    + "        		<thead>\n"
                    + "        			<tr>\n"
                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
                    + "        			</tr>\n"
                    + "        		</thead>\n"
                    + "        		<tbody>\n"
                    + "        			<tr>\n"
                    + "        				<td>nombre: </td>\n"
                    + "        				<td><input type=\"text\" name=\"nombre\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "                                    <td><label>duracion:</label></td>\n"
                    + "        				<td> <input type=\"text\" name= \"duracion\" value=\"\"" + "></td>\n"
                    + "        			</tr>\n"
                    + "        			<tr>\n"
                    + "        				<td colspan=\"2\" align=\"Center\"><input type=\"submit\" value=\"Add\"></td>\n"
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

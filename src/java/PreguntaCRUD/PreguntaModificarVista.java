/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PreguntaCRUD;

import DAO.ExamenDAO;
import DAO.PreguntaDAO;
import DTO.Examen;
import DTO.Pregunta;
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

/**
 *
 * @author Pwned
 */
public class PreguntaModificarVista extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreguntaDAO dao = new PreguntaDAO();
        Pregunta dto = new Pregunta(), dato = null;
        dto.setIdpregunta(Integer.parseInt(request.getParameter("idItem")));
        ExamenDAO udao = new ExamenDAO();
        List listaDatos = null;
        try {
            dato = dao.load(dto, conn.ObtenerConexion());
            if(dato==null){
                response.sendRedirect("PreguntaMostrar");
                return;
            }
            listaDatos = udao.loadALL(conn.ObtenerConexion());
        } catch (SQLException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExamenCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "	<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "    <title>Modificar Pregunta</title>\n"
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
                    + "<form class=\"form-horizontal\" id=\"\" action=\"PreguntaModificar\" method=\"post\">     \n"
                    +"<input type=\"hidden\" value=" + dato.getIdpregunta() + " name=\"idItem\" >"
                    + "    <h2>Introduzca los datos</h2>\n"
                    + "\n"
                    + "    <div class=\"line\" text-center></div>\n"
                    + "    <LABEL for=\"getPregunta\" style=\"text-align:center\">Pregunta: </LABEL>            \n"
                    + "		<INPUT style=\"text-align:center\" type=\"text\" name=\"getPregunta\" id=\"getPregunta\"      value=\""+dato.getPregunta()+"\">                    \n"
                    + "    <LABEL for=\"getIdexamen\" style=\"text-align:center\">IdExamen: </LABEL>            \n"
                    + "        <INPUT style=\"text-align:center\" type=\"text\" name=\"getIdexamen\" id=\"getIdexamen\" value=\""+dato.getIdexamen()+"\">                    		\n"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar  Datos\n"
                    + "    </button>	\n"
                    + "</form>\n"
                    + "<a href=\"PreguntaMostrar\">\n"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\">\n"
                    + "</a>\n"
                    + "</body>\n"
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

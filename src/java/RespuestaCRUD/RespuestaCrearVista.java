/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RespuestaCRUD;

import Utilerias.CargaSelect;
import Utilerias.Conexion;
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
public class RespuestaCrearVista extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "	<head>"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Dar de Alta Respuesta</title>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <!-- Bootstrap -->"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>    "
                    + "</head>"
                    + "<body>"
                    + "<div class=\"logo\">  "
                    + "</div>"
                    + "    "
                    + "<form class=\"form-horizontal\" id=\"\" action=\"RespuestaAgregar\" method=\"post\">     "
                    + "    <h2>Introduzca los datos</h2>"
                    + "    <div class=\"line\" text-center></div>"
                    + "    <LABEL for=\"getRespuesta\" style=\"text-align:center\">Respuesta: </LABEL>            "
                    + "		<INPUT style=\"text-align:center\" type=\"text\" name=\"getRespuesta\" id=\"getRespuesta\">                    "
                    + "    <LABEL for=\"IdPregunta\" style=\"text-align:center\">IdPregunta: </LABEL>            "
                    + CargaSelect.conPregunta()
                    //+ "        <INPUT style=\"text-align:center\" type=\"text\" name=\"IdPregunta\" id=\"IdPregunta\">                    		"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos"
                    + "    </button>	"
                    + "</form>"
                    + "<a href=\"RespuestaMostrar\">"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\">"
                    + "</a>"
                    + "</body>"
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

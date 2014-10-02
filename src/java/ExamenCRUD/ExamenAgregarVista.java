/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenCRUD;

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
public class ExamenAgregarVista extends HttpServlet {

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
            
                 out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "	<head>"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Examen Pregunta</title>"
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
                    + "<form class=\"form-horizontal\" id=\"\" action=\"ExamenAgregar\" method=\"post\">     "                    
                    + "    <h2>Introduzca los datos</h2>"
                    + ""
                    + "    <div class=\"line\" text-center></div>"
                    + "    <LABEL for=\"getRespuesta\" style=\"text-align:center\">Fecha: </LABEL>            "
                    + "		<INPUT style=\"text-align:center\" type=\"text\" name=\"fecha\" id=\"getRespuesta\" value=\" \">                    "
                    + "    <LABEL for=\"getRespuesta\" style=\"text-align:center\">Materia: </LABEL>            "
                    + "		<INPUT style=\"text-align:center\" type=\"text\" name=\"materia\" id=\"getRespuesta\" value=\" \">                    "
                    + "    <LABEL for=\"getRespuesta\" style=\"text-align:center\">Periodo: </LABEL>            "
                    + "		<INPUT style=\"text-align:center\" type=\"text\" name=\"periodo\" id=\"getRespuesta\" value=\"\">                    "
                  + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Agregar  Datos"
                    + "    </button>	"
                    + "</form>"
                    + "<a href=\"RespuestaMostrar\">"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\">"
                    + "</a>"
                    + "</body>"
                    + "</html>");
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>ExamenUpdate</title>");
//            out.println("</head>");
//            out.println("<body style=\"background-color: red\">\n"
//                    + "        <div align=\"Center\"><h3>Registro</h3></div>\n"
//                    + "        <div align=\"Center\">\n"
//                    + "        	<form action=\"ExamenCRUD\" method=\"POST\">\n<input type=\"hidden\" value=\"\"" + " name=\"idExamen\" >"
//                    + "          <input type=\"hidden\" value=\"create\" name=\"accion\" >"
//                    + "        	<table>\n"
//                    + "        		<thead>\n"
//                    + "        			<tr>\n"
//                    + "        			<th colspan=\"2\" align=\"Center\">Introduzca sus datos.</th>\n"
//                    + "        			</tr>\n"
//                    + "        		</thead>\n"
//                    + "        		<tbody>\n"
//                    + "        			<tr>\n"
//                    + "        				<td>fecha: </td>\n"
//                    + "        				<td><input type=\"text\" name=\"fecha\" value=\"\"" + "></td>\n"
//                    + "        			</tr>\n"
//                    + "        			<tr>\n"
//                    + "                                    <td><label>materia:</label></td>\n"
//                    + "        				<td> <input type=\"text\" name= \"materia\" value=\"\"" + "></td>\n"
//                    + "        			</tr>\n"
//                    + "        			<tr>\n"
//                    + "        				<td>periodo:</td>\n"
//                    + "        				<td><input type=\"text\" name=\"periodo\" value=\"\"" + "></td>\n"
//                    + "        			</tr>\n"
//                    + "        			<tr>\n"
//                    + "        				<td colspan=\"2\" align=\"Center\"><input type=\"submit\" value=\"Add\"></td>\n"
//                    + "        			</tr>\n"
//                    + "        		</tbody>\n"
//                    + "        	</table>\n"
//                    + "        	</form>\n"
//                    + "        </div>\n"
//                    + "    </body>\n"
//                    + "</html>");
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

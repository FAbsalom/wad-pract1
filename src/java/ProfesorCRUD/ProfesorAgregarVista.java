/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfesorCRUD;

import Utilerias.Conexion;
import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pwned
 */
public class ProfesorAgregarVista extends HttpServlet {

    Conexion conn = new Conexion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String se = "";
            ConfiguraSession s1 = new ConfiguraSession();
            if (s1.isSession(request)) {
                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
           //     se = (String) sesion.getAttribute(ConfiguraSession.login_name);
            } else {
                response.sendRedirect("Login.html");
                return;
            }
            String fecha="07/10/1991";
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "	<head>"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Inicio de Sesión</title>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <!-- Bootstrap -->"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"logo\">  "
                    + "</div>"
                    + "    "
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"ProfesorAgregar\" method=\"post\">"
                    + "     "
                    + "    <h2>Registro de Profesores</h2>"
                    + "    <div class=\"line\" text-center></div>"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Matricula: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"matricula\" id=\"matricula\">                    "
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Nombre: </LABEL>            "
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"nombre\" id=\"nombre\">                    "
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >Apellido Paterno: </LABEL>"
                    + "             <INPUT  style=\"text-align:center\"  type=\"text\" name=\"paterno\" id=\"paterno\"> "
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">Apellido Materno: </LABEL>"
                    + "                <INPUT  style=\"text-align:center\" type=\"text\" name=\"materno\" id=\"materno\"> "
                    + "        <LABEL for=\"email\" style=\"text-align:center\" >email: </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"email\" id=\"email\"> "
                    + "       <LABEL for=\"fechaN\" style=\"text-align:center\" >Fecha de Nacimiento </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"date\" name=\"fechaN\" id=\"fechaN\" values=\""+fecha+"\"> "
                    + "        <LABEL for=\"calle\" style=\"text-align:center\" >Callle </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"calle\" id=\"calle\"> "
                    + "        <LABEL for=\"colonia\" style=\"text-align:center\" >Colonia </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"colonia\" id=\"colonia\"> "
                    + "       <LABEL for=\"Numero\" style=\"text-align:center\" >Número </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"Numero\" id=\"Numero\"> "
                    + "        <LABEL for=\"Cp\" style=\"text-align:center\" >Codigo Postal </LABEL>"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"CP\" id=\"CP\"> "
                    + "        <LABEL for=\"sexo\" style=\"text-align:center\" >Sexo </LABEL>"
                    + "               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\"> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\"> Femenino\n"
                    + "               <br>"
                    + ""
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>   "
                    + "</form>"
                    + "<a href=\"ProfesorMostrar\">"
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

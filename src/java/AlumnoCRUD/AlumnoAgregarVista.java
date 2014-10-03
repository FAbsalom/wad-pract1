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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "	<head>\n"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
                    + "    <title> Inicio de Sesión </title>\n"
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
                    + "<form class=\"form-horizontal\" id=\"formulario_registro1\" action=\"AlumnoAgregar\" method=\"post\">     \n"
                    + "    <h2>Registro de Usuario</h2>\n"
                    + "\n"
                    + "    <div class=\"line\" text-center></div>\n"
                    + "    <LABEL for=\"matricula\" style=\"text-align:center\">Matricula: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"matricula\" id=\"matricula\">                    \n"
                    + "        <LABEL for=\"nombre\" style=\"text-align:center\">Nombre: </LABEL>            \n"
                    + "            <INPUT style=\"text-align:center\" type=\"text\" name=\"nombre\" id=\"nombre\">                    \n"
                    + "        <LABEL for=\"apellidoP\" style=\"text-align:center\" >Apellido Paterno: </LABEL>\n"
                    + "             <INPUT  style=\"text-align:center\"  type=\"text\" name=\"paterno\" id=\"paterno\"> \n"
                    + "        <LABEL for=\"apellidoM\" style=\"text-align:center\">Apellido Materno: </LABEL>\n"
                    + "                <INPUT  style=\"text-align:center\" type=\"text\" name=\"materno\" id=\"materno\">  \n"
                    + "       <LABEL for=\"fechaN\" style=\"text-align:center\" >Fecha de Nacimiento </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"date\" name=\"fecha\" id=\"fechaN\"> \n"
                    + "        <LABEL for=\"calle\" style=\"text-align:center\" >Callle </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"calle\" id=\"calle\"> \n"
                    + "        <LABEL for=\"colonia\" style=\"text-align:center\" >Colonia </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"colonia\" id=\"colonia\"> \n"
                    + "       <LABEL for=\"Numero\" style=\"text-align:center\" >Número </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"numero\" id=\"Numero\"> \n"
                    + "        <LABEL for=\"Cp\" style=\"text-align:center\" >Codigo Postal </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"cp\" id=\"CP\"> \n"
                    + "        <LABEL for=\"sexo\" style=\"text-align:center\" >Sexo </LABEL>\n"
                    + "               <input style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"M\"> Masculino\n"
                    + "               <input  style=\"text-align:center\" type=\"radio\" name=\"sexo\" value=\"F\"> Femenino\n"
                    + "               <br>\n"
                    + "        <LABEL for=\"email\" style=\"text-align:center\" >E-mail: </LABEL>\n"
                    + "               <INPUT  style=\"text-align:center\" type=\"text\" name=\"email\" id=\"email\">\n"
                    +CargaSelect.conCarrera()
                    + "\n"
                    + "    <button name=\"Registar\" type=\"submit\" class=\"btn btn-lg btn-primary btn-sign-in\" >Guardar Datos\n"
                    + "    </button>    \n"
                    + "</form>\n"
                    + "    <a href=\"login.html\">	\n"
                    + "<input class=\"btn btn-lg btn-primary btn-sign-in\" type=\"submit\" value=\"Regresar\"></a>\n"
                    + "</body>\n"
                    + "</html>\n"
                    + "");
            
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

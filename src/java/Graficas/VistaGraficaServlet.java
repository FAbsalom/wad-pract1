/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficas;

import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Pwned
 */
public class VistaGraficaServlet extends HttpServlet {

    public  void processRequest(HttpServletRequest request, HttpServletResponse response,String nombreimagen,String Titulo)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
//            String se = "";
//            ConfiguraSession s1 = new ConfiguraSession();
//            if (s1.isSession(request)) {
//                HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
//                se = (String) sesion.getAttribute(ConfiguraSession.login_name);
//            } else {
//                response.sendRedirect("Login.html");
//            }
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "	<head>"
                    + "	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">"
                    + "    <title>Reportes Graficos</title>"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                    + "    <!-- Bootstrap -->"
                    + "    <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">"
                    + "    <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--> </script>"
                    + "    <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"logo\">  ");
            //out.println("<p class=\"NombreUsuario\"> Bienvenido\t" + " <a href=\"CerrarSesion\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.png\"> </a></p>");
            //out.println("<a href=\"MostarModificarServlet\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.\"> </a>");
            out.println("<br/> <br/>  <br/>");
            out.println("<div class=\"panel-heading text-center\"> <h1>"+Titulo+"</h1> </div>");
            out.println("<img src=\""+nombreimagen+"\">");
            out.println("</body>");
        } finally {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
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
//                processRequest(request, response);
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

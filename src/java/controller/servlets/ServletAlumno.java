/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

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
 * @author absalom
 */
public class ServletAlumno extends HttpServlet {

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

        ConfiguraSession se = new ConfiguraSession();
        if (!se.isSession(request)) {
            response.sendRedirect("Login.html");
        }
        if(!se.isType(request).equalsIgnoreCase("alumno")){
            response.sendRedirect("ErrorServletl");
        }

        request.getSession().getAttribute("usuario");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//            ConfiguraSession s1=new ConfiguraSession();
//            if(s1.isSession(request)){
//                HttpSession sesion=request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
//		se=(String) sesion.getAttribute(ConfiguraSession.login_name);
//            }
//            else          
//                 response.sendRedirect("Login.html");
//            



        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">       \n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <title>Nueva Cuenta</title>\n"
                    + "\n"
                    + "        <!-- Bootstrap -->\n"
                    + "        <link href = \"./Css/bootstrap.min.css\" rel = \"stylesheet\">\n"
                    + "        <link href = \"./Css/styles.css\" rel = \"stylesheet\">\n"
                    + "        <link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">\n"
                    + "        <script src=\"./js/jquery-2.1.1.js\" type=\"text/javascript\"><!--mce:0--><!--mce:0--></script>\n"
                    + "        <script src=\"js/jquery.validate.js\" type=\"text/javascript\"><!--mce:1--><!--mce:1--></script>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "\n"
                    + "        <div class = \"navbar navbar-inverse navbar-static-top\">\n"
                    + "            <div class = \"container\">                               \n"
                    + "                <a href = \"#\" class = \"navbar-brand\">WEB APPILCATION </a>                               \n"
                    + "                <button class = \"navbar-toggle\" data-toggle = \"collapse\" data-target = \".navHeaderCollapse\">\n"
                    + "                    <span class = \"icon-bar\"></span>\n"
                    + "                    <span class = \"icon-bar\"></span>\n"
                    + "                    <span class = \"icon-bar\"></span>\n"
                    + "                </button>                               \n"
                    + "                <div class = \"collapse navbar-collapse navHeaderCollapse\">                               \n"
                    + "                    <ul class = \"nav navbar-nav navbar-right\">                                       \n"
                    + "                        <li class = \"active\"><a href = \"ServletProfesor\">INICIO</a></li>      \n"
                    + "                        <li class = \"dropdown\">                                                       \n"
                    + "                            <a href = \"\" class = \"dropdown-toggle\" data-toggle = \"dropdown\">ALUMNO <b class = \"caret\"></b></a>\n"
                    + "                            <ul class = \"dropdown-menu\">\n"
                    + "                                <li><a href = \"ProfesorMostrar\">Mostrar MIS DATOS</a></li>\n"
                    + "                                <li><a href = \"ProfesorAgregarVista\">AGREGAR A UN NUEVO ALUMNO</a></li>\n"
                    + "                            </ul>                                               \n"
                    + "                        </li>\n"
                    + "                    </ul>                               \n"
                    + "                </div>                               \n"
                    + "            </div>\n"
                    + "        </div> \n"
                    + "        <script src = \"http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js\"></script>\n"
                    + "        <script src = \"./js/bootstrap.js\"></script>\n"
                    + "        \n"
                    + "    </body>\n"
                    + "</html>\n"
                    + "");


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

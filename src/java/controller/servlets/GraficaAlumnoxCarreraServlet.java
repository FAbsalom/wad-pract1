/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlets;

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
public class GraficaAlumnoxCarreraServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Grafica de Alumnos</title>");            
            out.println(" <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">" +
                "<link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">");
            out.println("</head>");            
            out.println("<body>");               
            out.println("<div class=\"panel panel-default container\">");
            out.println("<p class=\"NombreUsuario\"> Bienvenido\t"+" <a href=\"CerrarSesion\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.png\"> </a></p>");
            //out.println("<a href=\"MostarModificarServlet\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.\"> </a>");
            out.println("<br/> <br/>  <br/>" );
            out.println("<div class=\"panel-heading text-center\"> <h1>Grafica de Alumnos</h1> </div>");
            out.println("<img src=\"AlumnosxCarrera.jpeg\">");          
            out.println("</body>");
//            out.println("</html>");
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

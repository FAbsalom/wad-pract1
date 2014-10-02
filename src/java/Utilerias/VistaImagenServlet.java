/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import Utilerias.ConfiguraSession;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class VistaImagenServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             String se="";
            ConfiguraSession s1=new ConfiguraSession();
            if(s1.isSession(request)){
                HttpSession sesion=request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
		//se=(String) sesion.getAttribute(ConfiguraSession.login_name);
            }
            else          
                 response.sendRedirect("Login.html");
                        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Grafica de Alumnos</title>");            
            out.println(" <link href=\"./Css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\">" +
                "<link href=\"./Css/Estilos.css\" rel=\"stylesheet\" media=\"screen\">");
            out.println("</head>");            
            out.println("<body>");               
            out.println("<div class=\"panel panel-default container\">");
            out.println("<p class=\"NombreUsuario\"> Bienvenido\t"+se+" <a href=\"CerrarSesion\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.png\"> </a></p>");
            //out.println("<a href=\"MostarModificarServlet\"> <img  class=\"pequeña\" src=\"./Imagenes/logout.\"> </a>");
            out.println("<br/> <br/>  <br/>" );
            out.println("<div class=\"panel-heading text-center\"> <h1>Grafica de Alumnos</h1> </div>");
            out.println("<img src=\"grafica.jpeg\">");          
            out.println("</body>");
//            out.println("</html>");
//             
//            out.println("");
//            out.println("");
//            out.println("");
//            
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet VistaImagenServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");            
//            out.println("<p class=\"NombreUsuario\"> Bienvenido\t"+se+"</p>");
//            
//            out.println("<img src=\"grafica.jpeg\">");            
//            out.println("</body>");
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

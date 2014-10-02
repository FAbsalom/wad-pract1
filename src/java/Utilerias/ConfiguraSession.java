package Utilerias;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfiguraSession extends HttpServlet {

    public static final String login_objeto = "objeto.datos"; //crea un String de tipo publico ,estatico y final
    public static final String tipo_ = "tipo.usuario"; //crea un String de tipo publico ,estatico y final
    public static final String password = "password"; //crea un String de tipo publico ,estatico y final

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void CreaSession(HttpServletRequest request, HttpServletResponse respose, Object o,String tipo) {
        HttpSession sesion = request.getSession(true); //devuelve una sesion y la almacea en sesion como recibe como argumento true la implementación creará una sesión si es necesario
        sesion.setAttribute(login_objeto, o); //Enlaza un objeto a esta sesión, utilizando el nombre del primer parametro. Si un objeto del mismo nombre ya está enlazado a la sesión, se sustituye el objeto.
        sesion.setAttribute(tipo_, tipo); //Enlaza un objeto a esta sesión, utilizando el nombre del primer parametro. Si un objeto del mismo nombre ya está enlazado a la sesión, se sustituye el objeto.
    }
  

    public void EliminaSession(HttpServletRequest request, HttpServletResponse response) {
        HttpSession sesion = request.getSession(true);  //devuelve una sesion y la almacea en sesion
        sesion.removeAttribute(login_objeto);
                sesion.removeAttribute(tipo_); //Quita el objeto vinculado con el nombre especificado de esta sesión. Si la sesión no tiene un objeto vinculado con el nombre especificado, este método no hace nada.
        if (sesion != null) { //pregunta si el objeto httpSession es null
            sesion.invalidate();			 //invalida la sesion
        }
    }

    public boolean isSession(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
        if (sesion == null) {
            return false;
        } else {
            return sesion.getAttribute(login_objeto) != null; //Devuelve el objeto unido con el nombre especificado en esta sesión
        }
    }
    
    public String  isType(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
         return sesion.getAttribute(tipo_).toString() ; //Devuelve el objeto unido con el nombre especificado en esta sesión
        
    }
    public Object getObjeto(HttpServletRequest request) {
        HttpSession sesion = request.getSession(false);  //getSession (false) comprobará la existencia de la sesión. Si existe la sesión, entonces se devuelve la referencia de ese objeto de sesión, si no es así, estos métodos se devolverá null.
         return sesion.getAttribute(login_objeto) ; //Devuelve el objeto unido con el nombre especificado en esta sesión
        
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

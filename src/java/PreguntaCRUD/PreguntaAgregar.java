/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PreguntaCRUD;

import DAO.PreguntaDAO;
import DTO.Pregunta;
import Utilerias.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class PreguntaAgregar extends HttpServlet {

   Conexion conn = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Pregunta dto = new Pregunta();
            PreguntaDAO dao= new PreguntaDAO();            
            String getPregunta=request.getParameter("getPregunta");
            String getIdexamen=request.getParameter("combo");
            dto.setIdexamen(Integer.parseInt(getIdexamen));
            dto.setPregunta(getPregunta);            
            dao.create(dto, conn.ObtenerConexion());
            response.sendRedirect("PreguntaMostrar");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PreguntaModificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaModificar.class.getName()).log(Level.SEVERE, null, ex);
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
